package com.feel.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import lombok.Data;

/**
 * 用户表
 *
 * @author zz
 * @email
 * @date 2019-06-13 02:39:52
 */

@Data
@TableName("db_user")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	private String userId;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 昵称
	 */
	private String nickName;
	/**
	 * 头像
	 */
	private String photo;
	/**
	 * 个人照片
	 */
	private String images;
	/**
	 * 微信openid
	 */
	private String openid;
	/**
	 * 省份
	 */
	private String province;
	/**
	 * 城市
	 */
	private String city;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 真实姓名
	 */
	private String realName;
	/**
	 * 性别1.男 2.女 3.其他
	 */
	private Integer sex;
	/**
	 * 生日
	 */
	private String birthday;
	/**
	 * 星座 1 2 3
	 */
	private Integer zodiac;
	/**
	 * 身高
	 */
	private String height;
	/**
	 * 学历 1 2 3
	 */
	private Integer education;
	/**
	 * 毕业院校
	 */
	private String graduation;
	/**
	 * 行业/职业 1 2 3
	 */
	private Integer occupation;
	/**
	 * 收入 1 2 3
	 */
	private Integer lncome;
	/**
	 * 微信号
	 */
	private String wechat;
	/**
	 * 身份证
	 */
	private String idCard;
	/**
	 * 信誉分
	 */
	private String credit;
	/**
	 * 钱包
	 */
	private String payment;
	/**
	 * 人群类型 1单身  2 恋爱  3 已婚  4 离异 5.其他
	 */
	private Integer crowd;
	/**
	 * 关于我
	 */
	private String aboutme;
	/**
	 * 兴趣爱好
	 */
	private String hobby;
	/**
	 * 感情观
	 */
	private String emotion;
	/**
	 * 心仪的人
	 */
	private String admire;
	/**
	 * 账户类型  1.游客 2.会员 3.管理员
	 */
	private Integer accType;
	/**
	 * 账户状态  1.正常 2.冻结 3.封号
	 */
	private Integer accStatus;
	/**
	 * 创建时间
	 */
	private String createTime;
	/**
	 * 修改时间
	 */
	private String updateTime;

}
