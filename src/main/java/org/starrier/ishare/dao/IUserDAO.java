package com.ishare.dao;

import com.ishare.entity.User;

import java.util.List;

/**
 * 用户数据访问接口
 */
public interface IUserDAO {

    void saveUser(String userName,String password);

    boolean isExist(String userName);

    /**
     * 去核对用户
     * @param user
     * @return
     */
    boolean isLogin(User user);



}

