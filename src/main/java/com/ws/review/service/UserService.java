package com.ws.review.service;

import com.ws.review.pojo.User;

public interface UserService {
    int queryFileNumber(int id);
    Integer increaseFileNumber(int id);
    int addUser(User user);
    User checkUser(String user_name, String password);
}
