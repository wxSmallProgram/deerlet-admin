package com.feel.modules.app.controller;

import java.util.Arrays;
import java.util.Map;

import com.feel.common.utils.TimeUtils;
import com.feel.common.utils.generate.IDGenerator;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.feel.modules.app.entity.UserEntity;
import com.feel.modules.app.service.UserService;
import com.feel.common.utils.PageUtils;
import com.feel.common.utils.R;



/**
 * 用户表
 *
 * @author zz
 * @email
 * @date 2019-06-12 23:46:14
 */
@RestController
@RequestMapping("app/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:user:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userService.selectListPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{userId}")
    @RequiresPermissions("app:user:info")
    public R info(@PathVariable("userId") String userId){
		UserEntity user = userService.selectById(userId);

        return R.ok().put("user", user);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:user:save")
    public R save(@RequestBody UserEntity user){
        user.setUserId(IDGenerator.SNOW_FLAKE.generate()+"");
        user.setCreateTime(TimeUtils.getNowTime());
		userService.insert(user);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:user:update")
    public R update(@RequestBody UserEntity user){
		userService.updateById(user);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:user:delete")
    public R delete(@RequestBody String[] userIds){
		userService.deleteBatchIds(Arrays.asList(userIds));

        return R.ok();
    }

}
