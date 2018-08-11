package com.ccblog.service.impl;

import com.ccblog.dao.UserMapper;
import com.ccblog.pojo.po.User;
import com.ccblog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/2/2/002.
 */
@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    @Override
    public User testShowUser(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}
