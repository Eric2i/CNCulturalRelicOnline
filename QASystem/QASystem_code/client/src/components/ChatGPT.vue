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
                            <p>弓箭手的戒指</p>
                            <div
                                style="width: 150px;height: 150px;margin: auto;background-image: url(http://ocr-museum.cn/api/upload/20210423/18394733-f470-4ed3-a748-fab7b5c676f9.jpg);background-size: 100% 100%;">
                            </div>
                        </el-carousel-item>
                        <el-carousel-item>
                            <p>有盖的芯片香盒</p>
                            <div
                                style="width: 150px;height: 150px;margin: auto;background-image: url(http://ocr-museum.cn/api/upload/20210423/4f2d65a5-9e55-4e3e-af65-2f886dcd1e88.jpg);background-size: 100% 100%;">
                            </div>
                        </el-carousel-item>
                        <el-carousel-item>
                            <p>多乳博局式鏡</p>
                            <div
                                style="width: 150px;height: 150px;margin: auto;background-image: url(http://ocr-museum.cn/api/upload/20210423/3c57af67-5b6e-4a65-8336-49558af26245.jpg);background-size: 100% 100%;">
                            </div>
                        </el-carousel-item>
                        <el-carousel-item>
                            <p>翡翠西瓜</p>
                            <div
                                style="width: 150px;height: 150px;margin: auto;background-image: url(http://ocr-museum.cn/api/upload/20210423/844e6723-be65-4ee9-b521-67b5cbd04eaa.jpg);background-size: 100% 100%;">
                            </div>
                        </el-carousel-item>
                    </el-carousel>

                    <!-- openai官网的超链接 -->
                    <el-link href="http://ocr-museum.cn/#/jingdianxinxidetail?id=17" target="_blank" style="margin: 200px 0 0 0 ; font-size: 30px; ">克利夫兰博物馆</el-link>
                    <br>
                    <el-link href="http://ocr-museum.cn/#/jingdianxinxidetail?id=17" target="_blank" style="margin: 20px 0 0 0; font-size: 30px; ">纽约现代艺术博物馆</el-link>
                    <br>
                    <el-link href="http://ocr-museum.cn/#/jingdianxinxidetail?id=15" target="_blank" style="margin: 20px 0 0 0; font-size: 30px; ">比利时皇家美术馆</el-link>
                    <br>
                    <el-link href="http://ocr-museum.cn/#/jingdianxinxidetail?id=7" target="_blank" style="margin: 20px 0 0 0; font-size: 30px; ">大英博物馆</el-link>
                    <br>
                    <el-link href="http://ocr-museum.cn/#/index" target="_blank" style="margin: 20px 0 150px 0; font-size: 30px; ">返回首页</el-link>

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
                                    <el-link v-if="item.url" :href="item.url" target="_blank">点击查看详情</el-link>
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
                                    size="large">美国的主要博物馆</el-button>
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
            let url = 'http://localhost:8099/request?question=' + this.question;
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
                , message: "克利夫兰艺术博物馆是美国最重要的美术馆和博物馆。位于俄亥俄州克里夫兰市中心以东克利夫兰大学圈地区。1913年成立，艺术作品超过43000件，其永久性画廊是1916年建设的。它以其广泛收集前哥伦布艺术，中世纪欧洲、亚洲和印度的艺术而出名。博物馆收藏的亚洲艺术品是美国拥有最好的。美国克利夫兰艺术博物馆克里夫兰艺术博物馆，成立于1913年。"
                , image: "http://ocr-museum.cn/api/upload/20210423/36b5b579-f6a3-4e58-8a32-e55bbbc38430.webp"
                , url: "http://ocr-museum.cn/#/jingdianxinxidetail?id=17"
            };
            this.chatRecord.push(you);
            this.chatRecord.push(ai);
            this.question = "";
            this.click = false;
        },
        autoAnser2() {
            this.click = true;
            var you = { sender: "YOU:", message: "美国的主要博物馆" };
            var ai = {
                sender: "小助手:"
                , message: "美国主要的博物馆有：\n1.圣地亚哥艺术博物馆\n2.克利夫兰博物馆\n3.纽约现代艺术博物馆\n4.大都会艺术博物馆"
                , image: "http://ocr-museum.cn/api/upload/20210423/d3f448d9-9ccf-4e26-84f8-c2e4828b0b6a.jpg"
                , url: "http://ocr-museum.cn/#/jingdianxinxi?jingdianbianhao=&jingdianmingcheng=&suoshudiqu=14&tupian=&kaifangshijian=&fujinmeishi=&dizhi=&piaojia_start=&piaojia_end=&liulanliang_start=&liulanliang_end=&miaoshu=&addtime=&page=1&pagesize=12"
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
            var you = { sender: "YOU:", message: "文物保护法是什么？" };
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