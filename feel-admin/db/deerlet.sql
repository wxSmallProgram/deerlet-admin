
--业务基本表

drop table if exists db_user;

/*==============================================================*/
/* Table: db_user                                               */
/*==============================================================*/
create table db_user
(
   user_id              varchar(100) not null comment '用户ID',
   username             varchar(100) comment '用户名',
   password             varchar(100) comment '密码',
   nick_name            varchar(100) comment '昵称',
   photo                varchar(100) comment '头像',
   images               varchar(100) comment '个人照片',
   openid               varchar(100) comment '微信openid',
   province             varchar(100) comment '省份',
   city                 varchar(100) comment '城市',
   mobile               varchar(100) comment '手机号',
   real_name            varchar(100) comment '真实姓名',
   sex                  integer(2) comment '性别1.男 2.女 3.其他',
   birthday             varchar(100) comment '生日',
   zodiac               integer(2) comment '星座 1 2 3',
   height               varchar(100) comment '身高',
   education            integer(2) comment '学历 1 2 3',
   graduation           varchar(100) comment '毕业院校',
   occupation           integer(2) comment '行业/职业 1 2 3',
   lncome               integer(2) comment '收入 1 2 3',
   wechat               varchar(100) comment '微信号',
   id_card              varchar(100) comment '身份证',
   credit               varchar(100) comment '信誉分',
   payment              char(10) comment '钱包',
   crowd                integer(2) comment '人群类型 1单身  2 恋爱  3 已婚  4 离异 5.其他',
   aboutme              varchar(100) comment '关于我',
   hobby                varchar(100) comment '兴趣爱好',
   emotion              varchar(100) comment '感情观',
   admire               varchar(100) comment '心仪的人',
   acc_type             integer(2) comment '账户类型  1.游客 2.会员 3.管理员',
   acc_status           integer(2) comment '账户状态  1.正常 2.冻结 3.封号',
   create_time          varchar(100) comment '创建时间',
   update_time          varchar(100) comment '修改时间',
   primary key (user_id)
);

alter table db_user comment '用户表';

