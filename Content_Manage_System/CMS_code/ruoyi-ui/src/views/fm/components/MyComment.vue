<template>
  <comment :commentList="commentList" :commentNum="commentList.length" :avatar="avatar" @doSend="doSend" @doChidSend="doChidSend"></comment>
</template>

<script>
import { mapGetters } from 'vuex'
import comment from 'bright-comment'
import {addComment, listComment} from "../../../api/system/comment";

export default {
  name: "MyComment",
  components:{comment},
  data() {
    return {
      commentList: []
    }
  },
  computed: {
    ...mapGetters([
      'userId',
      'avatar',
      'name'
    ])
  },
  props: {
    productId: {
      type: String,
      default: '0'
    },
    can: {
      type: Boolean,
      default: false
    },
  },
  methods: {
    doSend(content) {
      if (!this.can) {
        this.$modal.msgError('请从订单页面选择订单评论！')
        return
      }
      if (!content) {
        this.$modal.msgError('请输入内容！')
        return
      }
      let data = {
        productId: this.productId,
        commentUserId: this.userId,
        commentUserNickName: this.name,
        commentUserAvatar: this.avatar,
        // targetUserId:this.userId,
        // targetUserNickName:this.userId,
        // targetUserAvatar:this.userId,
        content: content
      }
      addComment(data).then(res => {
        this.$modal.msgSuccess(res.msg)
        this.listComments()
      })
    },
    /**
     * @param content 评论内容
     * @param bid 被评论用户id
     * @param pid 被评论用户id
     */
    doChidSend(content, bid, pid) {
      console.log(content, bid, pid)
    },
    listComments() {
      listComment({ productId: this.productId }).then(res => {
        this.commentList = res.rows.map(value => {
          let [
            id,
            commentUser,
            targetUser,
            content,
            createDate
          ] = [
            value.id,
            { id: value.commentUserId, nickName: value.commentUserNickName, avatar: value.commentUserAvatar },
            { id: value.targetUserId, nickName: value.targetUserNickName, avatar: value.targetUserAvatar },
            value.content,
            value.createDate
          ]
          return {
            id,
            commentUser,
            targetUser,
            content,
            createDate
          }
        })
      })
    },
  },
  created() {
    this.listComments()
  }
}
</script>

<style scoped>

/deep/.icon-reply {
  display: none!important;
}
</style>
