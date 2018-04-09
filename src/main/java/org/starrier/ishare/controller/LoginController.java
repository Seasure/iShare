package org.starrier.ishare.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.starrier.ishare.dao.Impl.UserDaoImpl;
import org.starrier.ishare.dao.UserDao;
import org.starrier.ishare.entity.User;
import org.starrier.ishare.entity.UserBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

/**
 * @Author Starrier
 * @Time 2018/3/23.
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charaset=utf-8");
        PrintWriter out =response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserBean userBean=new UserBean();
        userBean.setAccount(username);
        userBean.setPassword(password);

        if (checkUser(userBean)) {
            request.setAttribute("USER", userBean);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/loginSuccess.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("/iShare/loginFailed.jsp");
        }

    }

    private boolean checkUser(UserBean userBean) {
        UserDaoImpl userDao =new UserDaoImpl();

        if (userDao.searchUser(userBean)) {
            return true;
        } else {
            return false;
        }

    }
}
