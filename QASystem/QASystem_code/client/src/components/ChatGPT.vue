<!-- views/chatgpt.vue -->

<template>
    <div class="chatbot-layout" style="height: 100%; ">
        <el-container style="height: 100%;">
            <!-- 顶部 -->
            <el-header
                style="background-image: url(https://s1.ax1x.com/2022/12/30/pS9keyt.jpg);background-size:auto;margin-bottom: 5px;">
                <h1>智能问答小助手</h1>
            </el-header>

            <el-container>
                <el-aside
                    style="background-image: url(https://s1.ax1x.com/2022/12/30/pS9keyt.jpg);background-size: 530% 100% ;text-align: center;height: 100%;">
                    <!-- 添加一个轮播图模块 -->
                    <el-carousel :interval="4000" type="card" height="200px">
                        <el-carousel-item>
                            <p>白玉雕三羊纹执壶</p>
                            <div
                                style="width: 150px;height: 150px;margin: auto;background-image: url(https://s1.ax1x.com/2023/05/08/p90QnsI.jpg);background-size: 100% 100%;">
                            </div>
                        </el-carousel-item>
                        <el-carousel-item>
                            <p>金玉石珐琅桃鹿盆景</p>
                            <div
                                style="width: 150px;height: 150px;margin: auto;background-image: url(https://s1.ax1x.com/2023/05/08/p90QmQA.jpg);background-size: 100% 100%;">
                            </div>
                        </el-carousel-item>
                        <el-carousel-item>
                            <p>金累丝嵌珍珠五凤钿</p>
                            <div
                                style="width: 150px;height: 150px;margin: auto;background-image: url(https://s1.ax1x.com/2023/05/08/p90QVRH.jpg);background-size: 100% 100%;">
                            </div>
                        </el-carousel-item>
                        <el-carousel-item>
                            <p>金甪端形香熏</p>
                            <div
                                style="width: 150px;height: 150px;margin: auto;background-image: url(https://s1.ax1x.com/2023/05/08/p90QEJe.jpg);background-size: 100% 100%;">
                            </div>
                        </el-carousel-item>
                    </el-carousel>

                    <!-- openai官网的超链接 -->
                    <el-link href="https://www.clevelandart.org/" target="_blank" style="margin: 200px 0 0 0 ; font-size: 30px; ">克利夫兰艺术博物馆</el-link>
                    <br>
                    <el-link href="https://openai.com/" target="_blank" style="margin: 20px 0 0 0; font-size: 30px; ">OpenAI</el-link>
                    <br>
                    <el-link href="https://github.com/Eric2i/CNCulturalRelicOnline" target="_blank" style="margin: 20px 0 0 0; font-size: 30px; ">Git仓库</el-link>
                    <br>
                    <el-link href="https://www.buct.edu.cn/main.htm" target="_blank" style="margin: 20px 0 200px 0; font-size: 30px; ">BUCT</el-link>

                </el-aside>
                <el-container style="height: 100%;">
                    <el-main
                        style="background-color:#FFFFFF;height:100%;background-image: ;align-items: stretch;box-sizing: border-box;
                    display: flex;flex-basis: 0%;flex-direction: column;flex-grow: 1;flex-shrink: 1;overflow-x: hidden;position: relative;">

                        <el-descriptions column=1 size="small" border="true" style="width: 100%;height: 70vh;">
                            <div v-for="item in chatRecord" :key="item">
                                <el-descriptions-item :label="item.sender" label-align="center">
                                    <span v-html=item.message style="white-space: pre-line;"></span>
                                    <br>
                                    <img v-if="item.image" :src="item.image"
                                        style="display: block; max-width: 300px; max-height: 300px;margin: auto;" />
                                </el-descriptions-item>
                            </div>
                        </el-descriptions>

                    </el-main>

                    <el-footer>
                        <div
                            style="bottom: 0px;box-sizing: border-box;display: inline-block;left: 0px;bottom: 0px; padding-top: 8px;position: relative;
                                width: 100%;background-color: rgba(0, 0, 0, 0);background-image: linear-gradient();margin: auto;">

                            <div>
                                <el-button type="primary" @click="autoAnser1()" style="margin: 5px 5px;width:200px;"
                                    size="large">介绍一下克利夫兰博物馆</el-button>
                                <el-button type="primary" @click="autoAnser2()" style="margin: 5px 5px;width:200px;"
                                    size="large">克利夫兰博物馆主要藏品</el-button>
                                <el-button type="primary" @click="autoAnser3()" style="margin: 5px 5px;width:200px;"
                                    size="large">世界上著名的博物馆</el-button>
                                <el-button type="primary" @click="autoAnser4()" style="margin: 5px 5px;width:200px;"
                                    size="large">文物保护法是什么？</el-button>
                            </div>

                            <div style="width: 600px;margin: auto;">

                                <el-input v-model="question" type="textarea" placeholder="请输入你的问题"
                                    :autosize="{ minRows: 1, maxRows: 7 }" resize="none" show-word-limit maxlength="300" />
                                <div style="text-align: right;">
                                    <el-button color="#8d3d45" @click="chat" plain style="margin: 5px 0;width:100px;"
                                        size="large" :disabled="click">提交</el-button>
                                </div>
                            </div>

                        </div>
                    </el-footer>

                </el-container>
            </el-container>
        </el-container>
    </div>
</template>

<script>

export default {
    name: 'ChatGPT',
    data() {
        return {
            question: "",
            count: 0,
            click: false,
            chatRecord: [{
                sender: "小助手 :",
                message: "您好！我是知识问答系统认知小模型，能够学习和理解人类的语言，进行多轮对话，回答相关问题，高效便捷地帮助您获取信息、知识和灵感。",
                image: ""
            }]
        }
    },
    methods: {
        chat() {
            this.click = true;
            let url = 'http://127.0.0.1:8080/request?question=' + this.question;
            //let url = 'https://chat-bot-29072-7-1316779917.sh.run.tcloudbase.com/request?question=' + this.question;
            var you = { sender: "YOU:", message: this.question };
            var ai = { sender: "小助手:", message: "" };
            this.chatRecord.push(you);
            this.chatRecord.push(ai);
            this.question = "";
            let es = new EventSource(url);
            es.addEventListener('message', event => {
                console.log(event.data);
                this.count++;
                if (this.count > 2) {
                    if (event.data.toString() === "Answer Done!") {
                        es.close();
                        this.count = 0;
                        this.click = false;
                    } else {
                        var ai = this.chatRecord[this.chatRecord.length - 1]
                        ai.message += event.data;
                        this.chatRecord[this.chatRecord.length - 1] = ai;
                    }
                }
            });
        },
        autoAnser1() {
            this.click = true;
            var you = { sender: "YOU:", message: "介绍一下克利夫兰博物馆" };
            var ai = {
                sender: "小助手:"
                , message: "克利夫兰博物馆的艺术品收藏非常丰富，其中的一些藏品属于世界级别。例如，该博物馆拥有美国最大的亚洲艺术收藏之一，以及美国最著名的欧洲绘画和雕塑收藏之一。此外，博物馆还拥有古希腊、罗马和埃及艺术品、非洲艺术品、印第安艺术品和古代近东艺术品等。克利夫兰博物馆还是一个文化中心，经常举办各种艺术展览、讲座、音乐会和表演活动等，以及提供教育计划和社区项目，为游客提供了一个深入了解不同文化和艺术领域的机会。克利夫兰博物馆的建筑本身也是一个艺术品，由哈佛大学毕业生考特·格里瑟姆设计，是一座现代化的建筑，拥有充足的空间来展示丰富的藏品。博物馆的设计体现了现代化与传统元素的融合，如大理石、青铜和玻璃等材料的运用，使得博物馆成为了克利夫兰市的地标之一。"
                , image: "https://s1.ax1x.com/2023/05/11/p9rvxSS.jpg"
            };
            this.chatRecord.push(you);
            this.chatRecord.push(ai);
            this.question = "";
            this.click = false;
        },
        autoAnser2() {
            this.click = true;
            var you = { sender: "YOU:", message: "克利夫兰博物馆主要藏品" };
            var ai = {
                sender: "小助手:"
                , message: "克利夫兰博物馆是位于美国俄亥俄州克利夫兰的一座艺术博物馆，成立于1913年，是美国著名的文化机构之一。其收藏涵盖了来自全球各地的超过61,000件艺术和文化遗产，其中包括：\n1.欧洲绘画：收藏了超过4,000幅欧洲绘画作品，其中包括许多重要的作品，如梵高的《星空》、达芬奇的《美丽的弥赛亚》等。\n2.亚洲艺术：收藏了超过1万件来自亚洲各地的艺术品，包括中国、日本、印度、泰国等国家的艺术品，其中一些作品可以追溯到公元前1500年。\n3.美洲艺术：收藏了超过5,000件来自美洲地区的艺术品，包括美国、加拿大、墨西哥等国家的艺术品，其中包括古代美洲文化的艺术品和现代美国艺术作品。\n4.现代和当代艺术：收藏了超过1万件现代和当代艺术品，包括波洛克、毕加索、沃霍尔、卡拉维吉奥等重要的艺术家的作品。\n此外，克利夫兰博物馆还收藏了大量的装饰艺术品、雕塑、摄影、版画等艺术品，以及古代文物、珍贵书籍等文化遗产。"
                , image: "https://s1.ax1x.com/2023/05/11/p9rvjW8.jpg"
            };
            this.chatRecord.push(you);
            this.chatRecord.push(ai);
            this.question = "";
            this.click = false;
        },
        autoAnser3() {
            this.click = true;
            var you = { sender: "YOU:", message: "世界上著名的博物馆" };
            var ai = {
                sender: "小助手:"
                , message: "以下是世界上最著名的十大博物馆：\n1.大英博物馆（British Museum）\n2.卢浮宫（Musée du Louvre）\n3.大都会艺术博物馆（Metropolitan Museum of Art）\n4.爱荷华州艺术博物馆（Des Moines Art Center）\n5.索菲亚王后博物馆（Queen Sofia Museum）\n6.南京博物院：\n7.国立东京博物馆（National Museum of Tokyo）\n8.史密森尼国家自然历史博物馆（Smithsonian National Museum of Natural History）\n9.国立西班牙考古博物馆（National Archaeological Museum of Spain）：位于西班牙马德里，是世界上最重要的考古博物馆之一，收藏了大量古代西班牙和古罗马文物。\n10.普拉多博物馆（Prado Museum）"
                , image: "https://s1.ax1x.com/2023/05/11/p9spam4.jpg"
            };
            this.chatRecord.push(you);
            this.chatRecord.push(ai);
            this.question = "";
            this.click = false;
        },
        autoAnser4() {
            this.click = true;
            var you = { sender: "YOU:", message: "介绍一下克利夫兰博物馆" };
            var ai = {
                sender: "小助手:"
                , message: "《中华人民共和国文物保护法》是为了加强对文物的保护，继承中华民族优秀的历史文化遗产，促进科学研究工作，进行爱国主义和革命传统教育，建设社会主义精神文明和物质文明，而制定的法规。\n该法规由第五届全国人民代表大会常务委员会第二十五次会议于1982年11月19日通过，自1982年11月19日起施行。当前版本为2015年4月24日第十二届全国人民代表大会常务委员会第十四次会议修改。\n2017年11月4日，第十二届全国人民代表大会常务委员会第三十次会议决定，通过对《中华人民共和国文物保护法》作出修改。"
                , image: "https://s1.ax1x.com/2023/05/11/p9sp61K.jpg"
            };
            this.chatRecord.push(you);
            this.chatRecord.push(ai);
            this.question = "";
            this.click = false;
        }
    }
}
</script>