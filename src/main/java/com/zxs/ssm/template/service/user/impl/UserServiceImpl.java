package com.zxs.ssm.template.service.user.impl;

import com.zxs.ssm.template.dao.api.IUserDao;
import com.zxs.ssm.template.model.UserModel;
import com.zxs.ssm.template.service.user.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Project Name:ssm-template
 * File Name:UserServiceImpl
 * Package Name:com.zxs.ssm.template.service.user.impl
 * Date:2019/2/19
 * Author:zengxueshan
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */

@Service("userService")
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserDao userDao;

    @Override
    public int add(UserModel userModel) throws Exception{
        checkAdd(userModel);
        return userDao.add(userModel);
    }

    private void checkAdd(UserModel userModel) throws Exception{
        if(userModel == null){
            throw new Exception("参数不能为空");
        }
        if(userModel.getUsername()==null || userModel.getUsername().isEmpty()){
            throw new Exception("用户名不能为空");
        }
        if(userModel.getPassword()==null || userModel.getPassword().isEmpty()){
            throw new Exception("密码不能为空");
        }
        userModel.setId(UUID.randomUUID().toString());
    }

    @Override
    public int delete(String id) throws Exception{
        if(id==null || id.isEmpty()){
            throw new Exception("id不能为空");
        }
        return userDao.delete(id);
    }

    @Override
    public int update(UserModel userModel) throws Exception{
        return userDao.update(checkUpdate(userModel));
    }

    private UserModel checkUpdate(UserModel userModel) throws Exception{
        if(userModel == null){
            throw new Exception("参数不能为空");
        }
        if(userModel.getId()==null || userModel.getId().isEmpty()){
            throw new Exception("id不能为空");
        }
        UserModel temp = queryById(userModel.getId());
        if(temp == null){
            throw new Exception("当前用户不存在");
        }
        if(userModel.getUsername()!=null && !userModel.getUsername().isEmpty()){
            temp.setUsername(userModel.getUsername());
        }
        if(userModel.getPassword()!=null && !userModel.getPassword().isEmpty()){
            temp.setPassword(userModel.getPassword());
        }
        return temp;
    }

    @Override
    public UserModel queryById(String id) throws Exception{
        if(id==null || id.isEmpty()){
            throw new Exception("id不能为空");
        }
        return userDao.queryById(id);
    }

    @Override
    public List<UserModel> queryAll() throws Exception{
        return userDao.queryAll();
    }
}
