package org.starrier.ishare.action;

import com.opensymphony.xwork2.ActionSupport;
import lombok.Data;
import org.starrier.ishare.entity.User;
import org.starrier.ishare.entity.UserBean;
import org.starrier.ishare.serivice.UserService;

/**
 * @Author Starrier
 * @Time 2018/3/3.
 */
@Data
public class UserAction extends ActionSupport {

    private UserBean loginUser;

    @Override
    public String execute() {
        UserService userService=new UserService();
        if (userService.login(loginUser)) {
            return "success";
        }
        return "fail";
    }

    public String login() {
        UserService userService=new UserService();
        if (userService.login(loginUser)) {
            return "success";
        }
        return "fail";
    }

    public String register() {
        UserService userService=new UserService();
        if (userService.register(loginUser)) {
            return "registersuccess";
        }
        return "registerfail";
    }
}
