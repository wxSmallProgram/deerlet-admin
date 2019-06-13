<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.key" placeholder="参数名" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('app:user:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('app:user:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
      </el-form-item>
    </el-form>
    <el-table :data="dataList" border v-loading="dataListLoading" @selection-change="selectionChangeHandle" style="width: 100%;">
      <el-table-column type="selection" header-align="center" align="center" width="50"> </el-table-column>
        <el-table-column :show-overflow-tooltip="true"  prop="userId"  header-align="center"  align="center"  label="用户ID">
        </el-table-column>
        <el-table-column :show-overflow-tooltip="true"  prop="username"  header-align="center"  align="center"  label="用户名">
        </el-table-column>
        <el-table-column :show-overflow-tooltip="true"  prop="password"  header-align="center"  align="center"  label="密码">
        </el-table-column>
        <el-table-column :show-overflow-tooltip="true"  prop="nickName"  header-align="center"  align="center"  label="昵称">
        </el-table-column>
        <el-table-column :show-overflow-tooltip="true"  prop="photo"  header-align="center"  align="center"  label="头像">
        </el-table-column>
        <el-table-column :show-overflow-tooltip="true"  prop="images"  header-align="center"  align="center"  label="个人照片">
        </el-table-column>
        <el-table-column :show-overflow-tooltip="true"  prop="openid"  header-align="center"  align="center"  label="微信openid">
        </el-table-column>
        <el-table-column :show-overflow-tooltip="true"  prop="province"  header-align="center"  align="center"  label="省份">
        </el-table-column>
        <el-table-column :show-overflow-tooltip="true"  prop="city"  header-align="center"  align="center"  label="城市">
        </el-table-column>
        <el-table-column :show-overflow-tooltip="true"  prop="mobile"  header-align="center"  align="center"  label="手机号">
        </el-table-column>
        <el-table-column :show-overflow-tooltip="true"  prop="realName"  header-align="center"  align="center"  label="真实姓名">
        </el-table-column>
        <el-table-column :show-overflow-tooltip="true"  prop="sex"  header-align="center"  align="center"  label="性别1.男 2.女 3.其他">
        </el-table-column>
        <el-table-column :show-overflow-tooltip="true"  prop="birthday"  header-align="center"  align="center"  label="生日">
        </el-table-column>
        <el-table-column :show-overflow-tooltip="true"  prop="zodiac"  header-align="center"  align="center"  label="星座 1 2 3">
        </el-table-column>
        <el-table-column :show-overflow-tooltip="true"  prop="height"  header-align="center"  align="center"  label="身高">
        </el-table-column>
        <el-table-column :show-overflow-tooltip="true"  prop="education"  header-align="center"  align="center"  label="学历 1 2 3">
        </el-table-column>
        <el-table-column :show-overflow-tooltip="true"  prop="graduation"  header-align="center"  align="center"  label="毕业院校">
        </el-table-column>
        <el-table-column :show-overflow-tooltip="true"  prop="occupation"  header-align="center"  align="center"  label="行业/职业 1 2 3">
        </el-table-column>
        <el-table-column :show-overflow-tooltip="true"  prop="lncome"  header-align="center"  align="center"  label="收入 1 2 3">
        </el-table-column>
        <el-table-column :show-overflow-tooltip="true"  prop="wechat"  header-align="center"  align="center"  label="微信号">
        </el-table-column>
        <el-table-column :show-overflow-tooltip="true"  prop="idCard"  header-align="center"  align="center"  label="身份证">
        </el-table-column>
        <el-table-column :show-overflow-tooltip="true"  prop="credit"  header-align="center"  align="center"  label="信誉分">
        </el-table-column>
        <el-table-column :show-overflow-tooltip="true"  prop="payment"  header-align="center"  align="center"  label="钱包">
        </el-table-column>
        <el-table-column :show-overflow-tooltip="true"  prop="crowd"  header-align="center"  align="center"  label="人群类型 1单身  2 恋爱  3 已婚  4 离异 5.其他">
        </el-table-column>
        <el-table-column :show-overflow-tooltip="true"  prop="aboutme"  header-align="center"  align="center"  label="关于我">
        </el-table-column>
        <el-table-column :show-overflow-tooltip="true"  prop="hobby"  header-align="center"  align="center"  label="兴趣爱好">
        </el-table-column>
        <el-table-column :show-overflow-tooltip="true"  prop="emotion"  header-align="center"  align="center"  label="感情观">
        </el-table-column>
        <el-table-column :show-overflow-tooltip="true"  prop="admire"  header-align="center"  align="center"  label="心仪的人">
        </el-table-column>
        <el-table-column :show-overflow-tooltip="true"  prop="accType"  header-align="center"  align="center"  label="账户类型  1.游客 2.会员 3.管理员">
        </el-table-column>
        <el-table-column :show-overflow-tooltip="true"  prop="accStatus"  header-align="center"  align="center"  label="账户状态  1.正常 2.冻结 3.封号">
        </el-table-column>
        <el-table-column :show-overflow-tooltip="true"  prop="createTime"  header-align="center"  align="center"  label="创建时间">
        </el-table-column>
        <el-table-column :show-overflow-tooltip="true"  prop="updateTime"  header-align="center"  align="center"  label="修改时间">
        </el-table-column>
      <el-table-column fixed="right" header-align="center" align="center" width="150" label="操作">
        <template slot-scope="scope">
          <el-button type="text" size="small" @click="addOrUpdateHandle(scope.row.userId)">修改</el-button>
          <el-button type="text" size="small" @click="deleteHandle(scope.row.userId)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination  @size-change="sizeChangeHandle"  @current-change="currentChangeHandle"
      :current-page="pageIndex"
      :page-sizes="[10, 20, 50, 100]"
      :page-size="pageSize"
      :total="totalPage"
      layout="total, sizes, prev, pager, next, jumper">
    </el-pagination>
    <!-- 弹窗, 新增 / 修改 -->
    <add-or-update v-if="addOrUpdateVisible" ref="addOrUpdate" @refreshDataList="getDataList"></add-or-update>
  </div>
</template>

<script>
  import AddOrUpdate from './user-add-or-update'
  export default {
    data () {
      return {
        dataForm: {
          key: ''
        },
        dataList: [],
        pageIndex: 1,
        pageSize: 10,
        totalPage: 0,
        dataListLoading: false,
        dataListSelections: [],
        addOrUpdateVisible: false
      }
    },
    components: {
      AddOrUpdate
    },
    activated () {
      this.getDataList()
    },
    methods: {
      // 获取数据列表
      getDataList () {
        this.dataListLoading = true
        this.$http({
          url: this.$http.adornUrl('/app/user/list'),
          method: 'get',
          params: this.$http.adornParams({
            'page': this.pageIndex,
            'limit': this.pageSize,
            'key': this.dataForm.key
          })
        }).then(({data}) => {
          if (data && data.code === 1) {
            this.dataList = data.page.list
            this.totalPage = data.page.totalCount
          } else {
            this.dataList = []
            this.totalPage = 0
          }
          this.dataListLoading = false
        })
      },
      // 每页数
      sizeChangeHandle (val) {
        this.pageSize = val
        this.pageIndex = 1
        this.getDataList()
      },
      // 当前页
      currentChangeHandle (val) {
        this.pageIndex = val
        this.getDataList()
      },
      // 多选
      selectionChangeHandle (val) {
        this.dataListSelections = val
      },
      // 新增 / 修改
      addOrUpdateHandle (id) {
        this.addOrUpdateVisible = true
        this.$nextTick(() => {
          this.$refs.addOrUpdate.init(id)
        })
      },
      // 删除
      deleteHandle (id) {
        var ids = id ? [id] : this.dataListSelections.map(item => {
          return item.userId
        })
        this.$confirm(`确定对[id=${ids.join(',')}]进行[${id ? '删除' : '批量删除'}]操作?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$http({
            url: this.$http.adornUrl('/app/user/delete'),
            method: 'post',
            data: this.$http.adornData(ids, false)
          }).then(({data}) => {
            if (data && data.code === 1) {
              this.$message({
                message: '操作成功',
                type: 'success',
                duration: 1500,
                onClose: () => {
                  this.getDataList()
                }
              })
            } else {
              this.$message.error(data.msg)
            }
          })
        })
      }
    }
  }
</script>
