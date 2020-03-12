package com.rui.dao;

import com.rui.pojo.User;

public interface UserMapper {

    //根据id查询用户
    User getUserById(int id);
}
