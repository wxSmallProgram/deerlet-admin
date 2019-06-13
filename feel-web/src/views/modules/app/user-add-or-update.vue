<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" label-position="left" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="用户名" prop="username">
      <el-input v-model="dataForm.username" placeholder="用户名"></el-input>
    </el-form-item>
    <el-form-item label="密码" prop="password">
      <el-input v-model="dataForm.password" placeholder="密码"></el-input>
    </el-form-item>
    <el-form-item label="昵称" prop="nickName">
      <el-input v-model="dataForm.nickName" placeholder="昵称"></el-input>
    </el-form-item>
    <el-form-item label="头像" prop="photo">
      <el-input v-model="dataForm.photo" placeholder="头像"></el-input>
    </el-form-item>
    <el-form-item label="个人照片" prop="images">
      <el-input v-model="dataForm.images" placeholder="个人照片"></el-input>
    </el-form-item>
    <el-form-item label="微信openid" prop="openid">
      <el-input v-model="dataForm.openid" placeholder="微信openid"></el-input>
    </el-form-item>
    <el-form-item label="省份" prop="province">
      <el-input v-model="dataForm.province" placeholder="省份"></el-input>
    </el-form-item>
    <el-form-item label="城市" prop="city">
      <el-input v-model="dataForm.city" placeholder="城市"></el-input>
    </el-form-item>
    <el-form-item label="手机号" prop="mobile">
      <el-input v-model="dataForm.mobile" placeholder="手机号"></el-input>
    </el-form-item>
    <el-form-item label="真实姓名" prop="realName">
      <el-input v-model="dataForm.realName" placeholder="真实姓名"></el-input>
    </el-form-item>
    <el-form-item label="性别1.男 2.女 3.其他" prop="sex">
      <el-input v-model="dataForm.sex" placeholder="性别1.男 2.女 3.其他"></el-input>
    </el-form-item>
    <el-form-item label="生日" prop="birthday">
      <el-input v-model="dataForm.birthday" placeholder="生日"></el-input>
    </el-form-item>
    <el-form-item label="星座 1 2 3" prop="zodiac">
      <el-input v-model="dataForm.zodiac" placeholder="星座 1 2 3"></el-input>
    </el-form-item>
    <el-form-item label="身高" prop="height">
      <el-input v-model="dataForm.height" placeholder="身高"></el-input>
    </el-form-item>
    <el-form-item label="学历 1 2 3" prop="education">
      <el-input v-model="dataForm.education" placeholder="学历 1 2 3"></el-input>
    </el-form-item>
    <el-form-item label="毕业院校" prop="graduation">
      <el-input v-model="dataForm.graduation" placeholder="毕业院校"></el-input>
    </el-form-item>
    <el-form-item label="行业/职业 1 2 3" prop="occupation">
      <el-input v-model="dataForm.occupation" placeholder="行业/职业 1 2 3"></el-input>
    </el-form-item>
    <el-form-item label="收入 1 2 3" prop="lncome">
      <el-input v-model="dataForm.lncome" placeholder="收入 1 2 3"></el-input>
    </el-form-item>
    <el-form-item label="微信号" prop="wechat">
      <el-input v-model="dataForm.wechat" placeholder="微信号"></el-input>
    </el-form-item>
    <el-form-item label="身份证" prop="idCard">
      <el-input v-model="dataForm.idCard" placeholder="身份证"></el-input>
    </el-form-item>
    <el-form-item label="信誉分" prop="credit">
      <el-input v-model="dataForm.credit" placeholder="信誉分"></el-input>
    </el-form-item>
    <el-form-item label="钱包" prop="payment">
      <el-input v-model="dataForm.payment" placeholder="钱包"></el-input>
    </el-form-item>
    <el-form-item label="人群类型 1单身  2 恋爱  3 已婚  4 离异 5.其他" prop="crowd">
      <el-input v-model="dataForm.crowd" placeholder="人群类型 1单身  2 恋爱  3 已婚  4 离异 5.其他"></el-input>
    </el-form-item>
    <el-form-item label="关于我" prop="aboutme">
      <el-input v-model="dataForm.aboutme" placeholder="关于我"></el-input>
    </el-form-item>
    <el-form-item label="兴趣爱好" prop="hobby">
      <el-input v-model="dataForm.hobby" placeholder="兴趣爱好"></el-input>
    </el-form-item>
    <el-form-item label="感情观" prop="emotion">
      <el-input v-model="dataForm.emotion" placeholder="感情观"></el-input>
    </el-form-item>
    <el-form-item label="心仪的人" prop="admire">
      <el-input v-model="dataForm.admire" placeholder="心仪的人"></el-input>
    </el-form-item>
    <el-form-item label="账户类型  1.游客 2.会员 3.管理员" prop="accType">
      <el-input v-model="dataForm.accType" placeholder="账户类型  1.游客 2.会员 3.管理员"></el-input>
    </el-form-item>
    <el-form-item label="账户状态  1.正常 2.冻结 3.封号" prop="accStatus">
      <el-input v-model="dataForm.accStatus" placeholder="账户状态  1.正常 2.冻结 3.封号"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="修改时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="修改时间"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          userId: 0,
          username: '',
          password: '',
          nickName: '',
          photo: '',
          images: '',
          openid: '',
          province: '',
          city: '',
          mobile: '',
          realName: '',
          sex: '',
          birthday: '',
          zodiac: '',
          height: '',
          education: '',
          graduation: '',
          occupation: '',
          lncome: '',
          wechat: '',
          idCard: '',
          credit: '',
          payment: '',
          crowd: '',
          aboutme: '',
          hobby: '',
          emotion: '',
          admire: '',
          accType: '',
          accStatus: '',
          createTime: '',
          updateTime: ''
        },
        dataRule: {
          username: [
            { required: true, message: '用户名不能为空', trigger: 'blur' }
          ],
          password: [
            { required: true, message: '密码不能为空', trigger: 'blur' }
          ],
          nickName: [
            { required: true, message: '昵称不能为空', trigger: 'blur' }
          ],
          photo: [
            { required: true, message: '头像不能为空', trigger: 'blur' }
          ],
          images: [
            { required: true, message: '个人照片不能为空', trigger: 'blur' }
          ],
          openid: [
            { required: true, message: '微信openid不能为空', trigger: 'blur' }
          ],
          province: [
            { required: true, message: '省份不能为空', trigger: 'blur' }
          ],
          city: [
            { required: true, message: '城市不能为空', trigger: 'blur' }
          ],
          mobile: [
            { required: true, message: '手机号不能为空', trigger: 'blur' }
          ],
          realName: [
            { required: true, message: '真实姓名不能为空', trigger: 'blur' }
          ],
          sex: [
            { required: true, message: '性别1.男 2.女 3.其他不能为空', trigger: 'blur' }
          ],
          birthday: [
            { required: true, message: '生日不能为空', trigger: 'blur' }
          ],
          zodiac: [
            { required: true, message: '星座 1 2 3不能为空', trigger: 'blur' }
          ],
          height: [
            { required: true, message: '身高不能为空', trigger: 'blur' }
          ],
          education: [
            { required: true, message: '学历 1 2 3不能为空', trigger: 'blur' }
          ],
          graduation: [
            { required: true, message: '毕业院校不能为空', trigger: 'blur' }
          ],
          occupation: [
            { required: true, message: '行业/职业 1 2 3不能为空', trigger: 'blur' }
          ],
          lncome: [
            { required: true, message: '收入 1 2 3不能为空', trigger: 'blur' }
          ],
          wechat: [
            { required: true, message: '微信号不能为空', trigger: 'blur' }
          ],
          idCard: [
            { required: true, message: '身份证不能为空', trigger: 'blur' }
          ],
          credit: [
            { required: true, message: '信誉分不能为空', trigger: 'blur' }
          ],
          payment: [
            { required: true, message: '钱包不能为空', trigger: 'blur' }
          ],
          crowd: [
            { required: true, message: '人群类型 1单身  2 恋爱  3 已婚  4 离异 5.其他不能为空', trigger: 'blur' }
          ],
          aboutme: [
            { required: true, message: '关于我不能为空', trigger: 'blur' }
          ],
          hobby: [
            { required: true, message: '兴趣爱好不能为空', trigger: 'blur' }
          ],
          emotion: [
            { required: true, message: '感情观不能为空', trigger: 'blur' }
          ],
          admire: [
            { required: true, message: '心仪的人不能为空', trigger: 'blur' }
          ],
          accType: [
            { required: true, message: '账户类型  1.游客 2.会员 3.管理员不能为空', trigger: 'blur' }
          ],
          accStatus: [
            { required: true, message: '账户状态  1.正常 2.冻结 3.封号不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '修改时间不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.userId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.userId) {
            this.$http({
              url: this.$http.adornUrl(`/app/user/info/${this.dataForm.userId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 1) {
                this.dataForm.username = data.user.username
                this.dataForm.password = data.user.password
                this.dataForm.nickName = data.user.nickName
                this.dataForm.photo = data.user.photo
                this.dataForm.images = data.user.images
                this.dataForm.openid = data.user.openid
                this.dataForm.province = data.user.province
                this.dataForm.city = data.user.city
                this.dataForm.mobile = data.user.mobile
                this.dataForm.realName = data.user.realName
                this.dataForm.sex = data.user.sex
                this.dataForm.birthday = data.user.birthday
                this.dataForm.zodiac = data.user.zodiac
                this.dataForm.height = data.user.height
                this.dataForm.education = data.user.education
                this.dataForm.graduation = data.user.graduation
                this.dataForm.occupation = data.user.occupation
                this.dataForm.lncome = data.user.lncome
                this.dataForm.wechat = data.user.wechat
                this.dataForm.idCard = data.user.idCard
                this.dataForm.credit = data.user.credit
                this.dataForm.payment = data.user.payment
                this.dataForm.crowd = data.user.crowd
                this.dataForm.aboutme = data.user.aboutme
                this.dataForm.hobby = data.user.hobby
                this.dataForm.emotion = data.user.emotion
                this.dataForm.admire = data.user.admire
                this.dataForm.accType = data.user.accType
                this.dataForm.accStatus = data.user.accStatus
                this.dataForm.createTime = data.user.createTime
                this.dataForm.updateTime = data.user.updateTime
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/app/user/${!this.dataForm.userId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'userId': this.dataForm.userId || undefined,
                'username': this.dataForm.username,
                'password': this.dataForm.password,
                'nickName': this.dataForm.nickName,
                'photo': this.dataForm.photo,
                'images': this.dataForm.images,
                'openid': this.dataForm.openid,
                'province': this.dataForm.province,
                'city': this.dataForm.city,
                'mobile': this.dataForm.mobile,
                'realName': this.dataForm.realName,
                'sex': this.dataForm.sex,
                'birthday': this.dataForm.birthday,
                'zodiac': this.dataForm.zodiac,
                'height': this.dataForm.height,
                'education': this.dataForm.education,
                'graduation': this.dataForm.graduation,
                'occupation': this.dataForm.occupation,
                'lncome': this.dataForm.lncome,
                'wechat': this.dataForm.wechat,
                'idCard': this.dataForm.idCard,
                'credit': this.dataForm.credit,
                'payment': this.dataForm.payment,
                'crowd': this.dataForm.crowd,
                'aboutme': this.dataForm.aboutme,
                'hobby': this.dataForm.hobby,
                'emotion': this.dataForm.emotion,
                'admire': this.dataForm.admire,
                'accType': this.dataForm.accType,
                'accStatus': this.dataForm.accStatus,
                'createTime': this.dataForm.createTime,
                'updateTime': this.dataForm.updateTime
              })
            }).then(({data}) => {
              if (data && data.code === 1) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
