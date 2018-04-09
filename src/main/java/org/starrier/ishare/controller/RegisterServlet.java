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
 * Created by lenovo on 2018/4/4.
 */
public class RegisterServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName=req.getParameter("userName");
        String password=req.getParameter("password");
        String rePassword=req.getParameter("rePassword");


        //如果输入的参数为空，操作终止
        if("".equals(userName)||"".equals(password)||"".equals(rePassword)){
            req.setAttribute("msg","用户名和密码均不能为空！");
            req.getRequestDispatcher("register.jsp").forward(req,resp);
            return;
        }

        //输入密码与重复密码不一致的时候
        if(!password.equals(rePassword)){
            req.setAttribute("msg","设置的密码与重复密码必须一致！");
            req.getRequestDispatcher("register.jsp").forward(req,resp);
            return;
        }

        //用户名符合tel或email的格式要求
        String em = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        String ph = "^[1][34578]\\d{9}$";
        if (!userName.matches(em)&&!userName.matches(ph)){
            req.setAttribute("msg","该用户名格式错误！");
            req.getRequestDispatcher("register.jsp").forward(req,resp);
            return;
        }


        IUserDAO userDAO = new UserDAO();
        //如果用户名已经注册
        if (userDAO.isExist(userName)){
            req.setAttribute("msg","该用户名已经注册！");
            req.getRequestDispatcher("register.jsp").forward(req,resp);
            return;
        }




        User user=new User();
        user.setUserName(userName);
        user.setPassword(password);
        userDAO.saveUser(userName,password);


        resp.sendRedirect("login.jsp");
    }

}
