package org.starrier.ishare.serivice;

import org.starrier.ishare.dao.UserDao;
import org.starrier.ishare.entity.User;
import org.starrier.ishare.entity.UserBean;

import javax.transaction.Transactional;

/**
 * @Author Starrier
 * @Time 2018/3/3.
 */
@Transactional
public class UserService {

    public boolean login(UserBean loginUser) {
        /**  该 代码 片段为简化代码逻辑 设置 用户名和密码一致**/
        if (loginUser.getAccount().equals(loginUser.getPassword())) {
            return  true;
        }return false;
    }

    public boolean register(UserBean userBean) {
        return  false;
    }

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao=userDao;
    }

    public String addUser(User user) {
        return userDao.addUser(user);
    }
}
