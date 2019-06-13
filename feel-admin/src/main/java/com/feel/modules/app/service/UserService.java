package com.feel.modules.app.service;


import com.baomidou.mybatisplus.service.IService;
import com.feel.common.utils.PageUtils;
import com.feel.modules.app.entity.UserEntity;
import com.feel.modules.app.form.LoginForm;

import java.util.Map;

/**
 * 用户
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:22:06
 */
public interface UserService extends IService<UserEntity> {

	UserEntity queryByMobile(String mobile);

	/**
	 * 用户登录
	 * @param form    登录表单
	 * @return        返回用户ID
	 */
	String login(LoginForm form);

	PageUtils selectListPage(Map<String, Object> params);

}
