package com.example.ahn.controller;

import com.example.ahn.pojo.ResultData;
import com.example.ahn.pojo.UserInfo;
import com.example.ahn.service.UserInfoService;
import com.example.ahn.utils.JWT;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    UserInfoService userInfoService;

    @ApiOperation(value = "用户登录", notes = "用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "passwd", value = "密码", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "string", paramType = "header")
    })
    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public ResultData login() {
        String token = JWT.sign(userInfoService.selectUserInfoById("1"), 30L * 24L * 3600L * 1000L);
        return new ResultData(true, "登录成功！", token);
    }

    @ApiOperation(value = "用户列表", notes = "用户列表接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "令牌", required = true, dataType = "string", paramType = "header")
    })
    @RequestMapping(value = "/queryUserInfoList", method = {RequestMethod.POST})
    public ResultData queryUserInfoList() {
        PageHelper.startPage(1, 2);
        List<UserInfo> userInfoList = userInfoService.selectUserInfoList();
        return new ResultData(true, "查询成功！", new PageInfo(userInfoList));
    }
}
