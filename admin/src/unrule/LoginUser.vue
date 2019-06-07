<template>
  <section>
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-form :inline="true" :model="filters">
        <el-form-item>
          <el-input v-model="filters.query" placeholder="姓名/手机号等条件" />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" v-on:click="handleQuery" icon="el-icon-search">查询</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" v-on:click="handleAdd" icon="el-icon-plus">添加</el-button>
        </el-form-item>
      </el-form>
    </el-col>
    <el-table :data="rows" style="width: 100%;overflow: auto;" :height="clientHeight" stripe border highlight-current-row v-loading="pageLoading">
      <el-table-column label="账户" width="180">
        <template slot-scope="scope">
          <i class="el-icon-time"></i>
          <span style="margin-left: 10px">{{ scope.row.login_name }}</span>
        </template>
      </el-table-column>
      <el-table-column label="密码" width="330">
        <template slot-scope="scope">
          <i class="el-icon-time"></i>
          <span style="margin-left: 10px">{{ scope.row.login_pwd }}</span>
        </template>
      </el-table-column>

      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="primary"
            @click="handleEdit(scope.$index, scope.row)"><i class="el-icon-edit"></i>修改密码</el-button>
          <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)"><i class="el-icon-delete"></i>删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!--底部-->
    <el-col :span="24" class="toolbar">
      <el-pagination layout="prev, pager, next" @current-change="handleCurrentChange" :page-size="5" :total="total" style="float:right;">
      </el-pagination>
    </el-col>

    <!--对话框-->
    <el-dialog :title="form && form.id ? '修改密码' : '新增' " :visible.sync="formVisible" :close-on-click-modal="false">
      <el-form :model="form" label-width="100px" :rules="rules" ref="form">
        <el-form-item label="密码" prop="login_pwd">
          <el-input v-model="form.login_pwd" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click.native="formVisible = false">取消</el-button>
        <el-button type="primary" @click.native="handleSubmit" :loading="formLoading">提交</el-button>
      </div>
    </el-dialog>

  </section>
</template>

<script>
  const rules = {
    login_name: [{
      required: true,
      message: '请输入账户',
      trigger: 'blur'
    }],
    login_pwd: [{
      required: true,
      message: '请输入密码',
      trigger: 'blur',
    }],
  }

  let data = () => {
    return {
      //页码
      page: 1,
      //每页数量
      size: 5,
      //总数
      total: 0,
      //查询条件
      filters: {},
      //页面数据
      rows: [],
      //页面载入状态
      pageLoading: false,
      //列表高度
      clientHeight: '100%',
      //表单数据
      form: {},
      //验证规则
      rules: rules,
      //对话框隐藏状态
      formVisible: false,
      //表单提交状态
      formLoading: false
    }
  }

  let handleAdd = function() {
    this.form = {}
    this.form.sex = 1
    this.formVisible = true
  }

  let handleEdit = function(index, row) {
    this.form = Object.assign({}, row)
    this.formVisible = true
  }

  let handleDelete = function(index, row) {
    if (this.pageLoading)
      return

    this.$confirm('此操作将永久删除该数据, 是否继续?', '提示', {
      confirmButtonText: '确定',
      cancelButtonText: '取消',
      type: 'warning'
    }).then(() => {
      this.pageLoading = true
      this.$axios.get('/api/userlogin/remove/' + row.login_name).then(res => {
        this.pageLoading = false
        if (!res.data.success) {
          this.$message({
            type: 'error',
            message: res.data.message
          })
          return
        }
        this.$message({
          type: 'success',
          message: '删除成功!'
        })
        this.page = 1
        this.getRows()
      }).catch(e => this.pageLoading = false)
    }).catch(e => {})
  }

  let getRows = function() {
    if (this.pageLoading)
      return
    this.pageLoading = true

    let params = {
      page: this.page,
      size: this.size,
      query: this.filters.query
    }
    //调用post请求
    this.$axios.post('/api/userlogin/loadPage', params).then(res => {
      this.pageLoading = false
      if (!res.data || !res.data.rows)
        return
      //总数赋值
      this.total = res.data.total
      this.page++;
      //页面元素赋值
      this.rows = res.data.rows
    }).catch(e => this.pageLoading = false)
  }

  let handleSubmit = function() {
    if (this.formLoading)
      return

    this.$refs.form.validate(valid => {
      if (!valid)
        return

      this.formLoading = true

      //调用http协议
      this.$axios.post('/api/userlogin/save', this.form).then(res => {
        this.formLoading = false
        if (!res.data.success) {
          this.$message({
            showClose: true,
            message: res.data.message,
            type: 'error'
          });
          return
        }
        this.$message({
          type: 'success',
          message: '保存成功!'
        })

        //重新载入数据
        this.page = 1
        this.getRows()
        this.formVisible = false
      }).catch(e => this.formLoading = false)
    })
  }

  let handleQuery = function() {
    this.page = 1
    this.getRows()
  }

  let handleCurrentChange = function(val) {
    this.page = val
    this.getRows()
  }

  let initHeight = function() {
    this.clientHeight = (document.documentElement.clientHeight - 258) + 'px'
  }

  export default {
    data: data,
    methods: {
      //查询
      handleQuery,
      //添加
      handleAdd,
      //修改
      handleEdit,
      //删除
      handleDelete,
      //页数改变
      handleCurrentChange,
      //获取分页
      getRows,
      //初始化高度
      initHeight,
      //提交数据
      handleSubmit
    },
    mounted: function() {
      window.addEventListener('resize', this.initHeight)
      this.initHeight()
      this.getRows()
    }
  }
</script>

<style scoped>
</style>
