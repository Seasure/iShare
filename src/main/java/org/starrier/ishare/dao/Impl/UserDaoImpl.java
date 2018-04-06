package org.starrier.ishare.dao.Impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.starrier.ishare.dao.UserDao;
import org.starrier.ishare.entity.User;
import org.starrier.ishare.entity.UserBean;

import java.sql.*;

/**
 * @Author Starrier
 * @Time 2018/3/3.
 */

@Log4j
@Data
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    private static final String GET_ONE_SQL = "SELECT * FROM t_user WHERE username= ? and password = ?";

    public UserDaoImpl() {}

    @Override
    public String addUser(User user) {
        getHibernateTemplate().save(user);
        return "success";
    }

    @Override
    public boolean searchUser(UserBean userBean) {
        // 按用户名和密码 校验用户名是否合法
      Connection connection=null;
      PreparedStatement preparedStatement=null;
      ResultSet resultSet=null;

        try {
            connection=getConnection();
            preparedStatement = connection.prepareStatement(GET_ONE_SQL);
            preparedStatement.setString(1, userBean.getAccount());
            preparedStatement.setString(2, userBean.getPassword());
            resultSet=preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Connection getConnection() {

        Connection connection=null;
        String driver="org.postgresql.Driver";
        String dburl = "jdbc:mysql://localhost:3306/iShare";
        String username = "Starrier";
        String password = "starrier&1103";

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(dburl, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
