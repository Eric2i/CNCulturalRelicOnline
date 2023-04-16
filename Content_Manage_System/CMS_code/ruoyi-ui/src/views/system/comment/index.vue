<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="项目ID" prop="itemId">
        <el-input
          v-model="queryParams.itemId"
          placeholder="请输入项目ID"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="类型" prop="type">
        <el-select v-model="queryParams.type" placeholder="请选择类型" clearable size="small">
          <el-option
            v-for="dict in dict.type.a_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="评论用户ID" prop="commentUserId">
        <el-input
          v-model="queryParams.commentUserId"
          placeholder="请输入评论用户ID"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="评论用户" prop="commentUserNickName">
        <el-input
          v-model="queryParams.commentUserNickName"
          placeholder="请输入评论用户"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="评论用户头像" prop="commentUserAvatar">
        <el-input
          v-model="queryParams.commentUserAvatar"
          placeholder="请输入评论用户头像"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="被评论用户ID" prop="targetUserId">
        <el-input
          v-model="queryParams.targetUserId"
          placeholder="请输入被评论用户ID"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="被评论用户" prop="targetUserNickName">
        <el-input
          v-model="queryParams.targetUserNickName"
          placeholder="请输入被评论用户"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="被评论用户头像" prop="targetUserAvatar">
        <el-input
          v-model="queryParams.targetUserAvatar"
          placeholder="请输入被评论用户头像"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="评论时间" prop="createDate">
        <el-date-picker clearable size="small"
          v-model="queryParams.createDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择评论时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="是否精选" prop="recommend">
        <el-input
          v-model="queryParams.recommend"
          placeholder="请输入是否精选"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:comment:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:comment:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:comment:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:comment:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="commentList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="项目ID" align="center" prop="itemId" />
      <el-table-column label="类型" align="center" prop="type">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.a_type" :value="scope.row.type"/>
        </template>
      </el-table-column>
      <el-table-column label="评论用户ID" align="center" prop="commentUserId" />
      <el-table-column label="评论用户" align="center" prop="commentUserNickName" />
      <el-table-column label="评论用户头像" align="center" prop="commentUserAvatar" />
      <el-table-column label="被评论用户ID" align="center" prop="targetUserId" />
      <el-table-column label="被评论用户" align="center" prop="targetUserNickName" />
      <el-table-column label="被评论用户头像" align="center" prop="targetUserAvatar" />
      <el-table-column label="评论内容" align="center" prop="content" />
      <el-table-column label="评论时间" align="center" prop="createDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="是否精选" align="center" prop="recommend" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:comment:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:comment:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改评论信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="项目ID" prop="itemId">
          <el-input v-model="form.itemId" placeholder="请输入项目ID" />
        </el-form-item>
        <el-form-item label="类型" prop="type">
          <el-select v-model="form.type" placeholder="请选择类型">
            <el-option
              v-for="dict in dict.type.a_type"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="评论用户ID" prop="commentUserId">
          <el-input v-model="form.commentUserId" placeholder="请输入评论用户ID" />
        </el-form-item>
        <el-form-item label="评论用户" prop="commentUserNickName">
          <el-input v-model="form.commentUserNickName" placeholder="请输入评论用户" />
        </el-form-item>
        <el-form-item label="评论用户头像" prop="commentUserAvatar">
          <el-input v-model="form.commentUserAvatar" placeholder="请输入评论用户头像" />
        </el-form-item>
        <el-form-item label="被评论用户ID" prop="targetUserId">
          <el-input v-model="form.targetUserId" placeholder="请输入被评论用户ID" />
        </el-form-item>
        <el-form-item label="被评论用户" prop="targetUserNickName">
          <el-input v-model="form.targetUserNickName" placeholder="请输入被评论用户" />
        </el-form-item>
        <el-form-item label="被评论用户头像" prop="targetUserAvatar">
          <el-input v-model="form.targetUserAvatar" placeholder="请输入被评论用户头像" />
        </el-form-item>
        <el-form-item label="评论内容">
          <editor v-model="form.content" :min-height="192"/>
        </el-form-item>
        <el-form-item label="评论时间" prop="createDate">
          <el-date-picker clearable size="small"
            v-model="form.createDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择评论时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="是否精选" prop="recommend">
          <el-input v-model="form.recommend" placeholder="请输入是否精选" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listComment, getComment, delComment, addComment, updateComment } from "@/api/system/comment";

export default {
  name: "Comment",
  dicts: ['a_type'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 评论信息表格数据
      commentList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        itemId: null,
        type: null,
        commentUserId: null,
        commentUserNickName: null,
        commentUserAvatar: null,
        targetUserId: null,
        targetUserNickName: null,
        targetUserAvatar: null,
        content: null,
        createDate: null,
        recommend: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询评论信息列表 */
    getList() {
      this.loading = true;
      listComment(this.queryParams).then(response => {
        this.commentList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        itemId: null,
        type: null,
        commentUserId: null,
        commentUserNickName: null,
        commentUserAvatar: null,
        targetUserId: null,
        targetUserNickName: null,
        targetUserAvatar: null,
        content: null,
        createDate: null,
        recommend: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加评论信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getComment(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改评论信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateComment(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addComment(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除评论信息编号为"' + ids + '"的数据项？').then(function() {
        return delComment(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/comment/export', {
        ...this.queryParams
      }, `comment_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
