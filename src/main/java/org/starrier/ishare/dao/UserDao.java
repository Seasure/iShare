package org.starrier.ishare.dao;

import org.starrier.ishare.entity.User;
import org.starrier.ishare.entity.UserBean;

import java.sql.Connection;

/**
 * @Author Starrier
 * @Time 2018/3/3.
 */
public interface UserDao {
    public String addUser(User user);

    public boolean searchUser(UserBean userBean);

    public Connection getConnection();
}
