package com.zxs.ssm.template.controller;

import com.zxs.ssm.template.model.UserModel;
import com.zxs.ssm.template.model.response.ResponseResult;
import com.zxs.ssm.template.service.user.api.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project Name:ssm-template
 * File Name:UserController
 * Package Name:com.zxs.ssm.template.controller
 * Date:2019/2/19
 * Author:zengxueshan
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */

@RestController("userController")
public class UserController {

    @Resource(name = "userService")
    private IUserService userService;

    @PostMapping("user/add")
    public Object add(@RequestBody UserModel userModel) {
        try{
            int res = this.userService.add(userModel);
            Map<String,Object> map = new HashMap<>();
            map.put("count",res);
            return new ResponseResult(0, ResponseResult.ResponseState.SUCCESS, map, "");
        }catch (Exception e){
            return new ResponseResult(1, ResponseResult.ResponseState.EXCEPTION, new HashMap<>(), e.getMessage());
        }
    }
    @PostMapping("user/delete")
    public Object delete(@RequestParam String id) {
        try{
            int res = this.userService.delete(id);
            Map<String,Object> map = new HashMap<>();
            map.put("count",res);
            return new ResponseResult(0, ResponseResult.ResponseState.SUCCESS, map, "");
        }catch (Exception e){
            return new ResponseResult(1, ResponseResult.ResponseState.EXCEPTION, new HashMap<>(), e.getMessage());
        }
    }
    @PostMapping("user/update")
    public Object update(@RequestBody UserModel userModel) {
        try{
            int res = this.userService.update(userModel);
            Map<String,Object> map = new HashMap<>();
            map.put("count",res);
            return new ResponseResult(0, ResponseResult.ResponseState.SUCCESS, map, "");
        }catch (Exception e){
            return new ResponseResult(1, ResponseResult.ResponseState.EXCEPTION, new HashMap<>(), e.getMessage());
        }
    }

    @GetMapping("user/queryById")
    public Object queryById(@RequestParam String id) {
        try{
            UserModel userModel = this.userService.queryById(id);
            Map<String,Object> map = new HashMap<>();
            map.put("user",userModel);
            return new ResponseResult(0, ResponseResult.ResponseState.SUCCESS, map, "");
        }catch (Exception e){
            return new ResponseResult(1, ResponseResult.ResponseState.EXCEPTION, new HashMap<>(), e.getMessage());
        }
    }
    @GetMapping("user/queryAll")
    public Object queryAll() {
        try{
            List<UserModel> list = this.userService.queryAll();
            Map<String,Object> map = new HashMap<>();
            map.put("user",list);
            return new ResponseResult(0, ResponseResult.ResponseState.SUCCESS, map, "");
        }catch (Exception e){
            return new ResponseResult(1, ResponseResult.ResponseState.EXCEPTION, new HashMap<>(), e.getMessage());
        }
    }

}
