package com.example.service.impl;

import com.example.domain.MyUser;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import com.example.util.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public MyUser selectByUserName(String username) {
        return userMapper.selectByPrimaryKey(username);
    }

    @Override
    public boolean add(MyUser user) {
        // 给密码进行加密处理
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // 对于不能为空的两个参数给默认值
        user.setCreateTime(DateFormatUtils.dateFormat("yyyy-MM-dd hh:mm:ss",new Date()));
        user.setUpdateTime(DateFormatUtils.dateFormat("yyyy-MM-dd hh:mm:ss",new Date()));
        int row = userMapper.insert(user);
        return row > 0;
    }
}
