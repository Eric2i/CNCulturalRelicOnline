<!-- views/chatgpt.vue -->

<template>
 <div class="common-layout">
    <el-container >
    <!-- 顶部 -->
      <el-header style="background-color: #DEB887;">
        <h1>智能问答小助手</h1>
      </el-header>

      <el-container>
        <el-aside style="background-color: #FFDAB9;text-align: center;">
            <div style="width: 15px;margin: 100px auto; font-size: 30px; ">
                输入文字点击提交提问
            </div>
        </el-aside>

        <el-container>
          <el-main style="background-color:#FFFFFF;height:500px;background-image: ;">
            <el-descriptions column=1 size="small" border="true" style="width:1000px;" >
                <div v-for="item in chatRecord" :key="item">
                    <el-descriptions-item :label="item.sender" label-align="center" >
                        <span v-html=item.message></span>
                    </el-descriptions-item>
                </div>
            </el-descriptions>
          </el-main>

          <el-footer style="padding:10px;height:300px;">
           <div style="width:1000px; height: 200px;">
                <el-input v-model="question" type="textarea" placeholder="请输入你的问题" :autosize="{ minRows: 5, maxRows: 7 }" resize="none" show-word-limit maxlength="300"/>
                <div style="text-align: right;">
                    <el-button color="#8d3d45" @click="chat" plain style="margin: 5px 0;width:100px;" size="large" :disabled="click">提交</el-button>
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
            chatRecord: [{ sender: "小助手 :", message: "您好！有什么需要向我提问的吗？"}]
        }
    },
    methods: {
        chat() {
            this.click=true;
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
                    }else {
                        var ai = this.chatRecord[this.chatRecord.length - 1]
                        ai.message += event.data;
                        this.chatRecord[this.chatRecord.length - 1] = ai;
                    }
                }
            });
        }
    }
}
</script>