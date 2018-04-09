package com.ishare.controller;

import com.ishare.dao.IUserDAO;
import com.ishare.dao.UserDAO;
import com.ishare.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lenovo on 2018/4/7.
 */
public class LoginServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName=req.getParameter("userName");
        String password=req.getParameter("password");

        //如果输入的参数为空，操作终止
        if("".equals(userName)||"".equals(password)){
            req.setAttribute("msg","用户名和密码均不能为空！");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
            return;
        }

        IUserDAO userDAO=new UserDAO();
        User user=new User();
        user.setUserName(userName);
        user.setPassword(password);

        if (userDAO.isLogin(user)){
            req.setAttribute("msg","登录成功！");
            req.getRequestDispatcher("result.jsp").forward(req,resp);
        }else {
            req.setAttribute("msg","密码错误或用户名不存在！");
            req.getRequestDispatcher("result.jsp").forward(req,resp);
        }

    }
}
