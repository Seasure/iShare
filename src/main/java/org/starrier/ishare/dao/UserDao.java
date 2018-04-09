package com.ishare.dao;

import com.ishare.entity.User;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 用户数据访问对象
 */
@Repository
public class UserDAO implements IUserDAO {
    private PreparedStatement ps;
    private ResultSet rs;

    public void saveUser(String userName,String password) {
        Connection connection= ConnectionManager.getConnection();

        String sql="insert into user values(null,?,?)";

        try {
            ps=connection.prepareStatement(sql);
            ps.setString(1,userName);
            ps.setString(2,password);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (ps!=null){
                    ps.close();
                }
                if (connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isExist(String userName) {
        boolean flag=false;
        Connection connection= ConnectionManager.getConnection();
        String sql="select * from user where username = ?";

        try {
            ps=connection.prepareStatement(sql);
            ps.setString(1,userName);
            rs=ps.executeQuery();
            if (rs.next()){
                flag=true;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (rs!=null){
                    rs.close();
                }
                if (ps!=null){
                    ps.close();
                }
                if (connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    public boolean isLogin(User user) {
        boolean flag=false;
        Connection connection= ConnectionManager.getConnection();
        String sql="select * from user where username = ? and password = ?";

        try {
            ps=connection.prepareStatement(sql);
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getPassword());
            rs=ps.executeQuery();
            if (rs.next()){
                flag=true;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (rs!=null){
                    rs.close();
                }
                if (ps!=null){
                    ps.close();
                }
                if (connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }




}
