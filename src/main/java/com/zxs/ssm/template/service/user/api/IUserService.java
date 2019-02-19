package com.zxs.ssm.template.service.user.api;

import com.zxs.ssm.template.model.UserModel;

import java.util.List;

/**
 * Project Name:ssm-template
 * File Name:IUserService
 * Package Name:com.zxs.ssm.template.service.user.api
 * Date:2019/2/19
 * Author:zengxueshan
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


public interface IUserService {
    int add(UserModel userModel)throws Exception;
    int delete(String id)throws Exception;
    int update(UserModel userModel)throws Exception;
    UserModel queryById(String id)throws Exception;
    List<UserModel> queryAll()throws Exception;
}
