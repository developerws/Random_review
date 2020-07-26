package com.ws.review.serviceImpl;

import com.ws.review.mapper.UserMapper;
import com.ws.review.pojo.User;
import com.ws.review.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public int queryFileNumber(int id) {
        return userMapper.selectById(id);
    }

    @Override
    public Integer increaseFileNumber(int id) {
        return userMapper.updateNumById(id);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public User checkUser(String user_name, String password) {
        return userMapper.findByUsernameAndPassword(user_name,password);
    }
}
