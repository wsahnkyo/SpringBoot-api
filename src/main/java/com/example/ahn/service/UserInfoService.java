package com.example.ahn.service;

import com.example.ahn.dao.UserInfoMapper;
import com.example.ahn.pojo.UserInfo;
import com.example.ahn.pojo.UserInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;

    public List<UserInfo> selectUserInfoList() {
        return userInfoMapper.selectByExample(new UserInfoExample());
    }


    public UserInfo selectUserInfoById(String userId) {
        return userInfoMapper.selectByPrimaryKey(userId);
    }
}
