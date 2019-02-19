package com.zxs.ssm.template.dao.api;

import com.zxs.ssm.template.model.UserModel;

import java.util.List;

/**
 * Project Name:ssm-template
 * File Name:IUserDao
 * Package Name:com.zxs.ssm.template.dao.api
 * Date:2019/2/19
 * Author:zengxueshan
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


public interface IUserDao {
    int add(UserModel userModel);
    int delete(String id);
    int update(UserModel userModel);
    UserModel queryById(String id);
    List<UserModel> queryAll();
}
