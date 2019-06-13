package com.feel.modules.app.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.feel.common.exception.RRException;
import com.feel.common.utils.PageUtils;
import com.feel.common.utils.Query;
import com.feel.common.validator.Assert;
import com.feel.modules.app.dao.UserDao;
import com.feel.modules.app.entity.UserEntity;
import com.feel.modules.app.form.LoginForm;
import com.feel.modules.app.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

	@Resource
	private UserDao userDao;

	@Override
	public PageUtils selectListPage(Map<String, Object> params) {
		Map<String,Object> param = new Query<>(params);
		List<UserEntity> list = userDao.selectListByMap(param);
		int count = userDao.selectCounts();
		PageUtils page = new PageUtils(list , count , ((Query) param).getLimit() , ((Query) param).getCurrPage());
		return page;
	}

	@Override
	public UserEntity queryByMobile(String mobile) {
		UserEntity userEntity = new UserEntity();
		userEntity.setMobile(mobile);
		return baseMapper.selectOne(userEntity);
	}

	@Override
	public String login(LoginForm form) {
		UserEntity user = queryByMobile(form.getMobile());
		Assert.isNull(user, "手机号或密码错误");

		//密码错误
		if(!user.getPassword().equals(DigestUtils.sha256Hex(form.getPassword()))){
			throw new RRException("手机号或密码错误");
		}

		return user.getUserId();
	}
}
