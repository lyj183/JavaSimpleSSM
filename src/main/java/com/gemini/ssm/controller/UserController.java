package com.gemini.ssm.controller;

import com.gemini.ssm.model.User;
import com.gemini.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author: linyijin
 * @Date: Created in 2018/2/6 10:44
 * @Description:
 **/

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/showUser")
    public String toIndex(HttpServletRequest request, Model model) {
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserByID(userId);
        // 绑定对象到User.jsp
        model.addAttribute("user", user);
        return "User";
    }

    /**
     * 以下内容均为自己练习添加
     */

    @RequestMapping("/hello")
    public String home(Model model) {
        // 绑定对象到Hello.jsp
        model.addAttribute("message", "hello, world");
        return "Hello";
    }

    @RequestMapping("/showAddUser")
    public String addToIndex(HttpServletRequest request, Model model) {
        int userId = Integer.parseInt(request.getParameter("id"));
        String userName = request.getParameter("name");
        String pin = request.getParameter("password");
        int age = Integer.parseInt(request.getParameter("age"));
        this.userService.addUser(userId, userName, pin, age);
        User user = this.userService.getUserByID(userId);
        // 绑定对象到User.jsp
        model.addAttribute("user", user);
        return "User";
    }

    @RequestMapping("/removeUser")
    public String removeFromIndex(HttpServletRequest request, Model model) {
        int userId = Integer.parseInt(request.getParameter("id"));
        String string = this.userService.removeUser(userId);
        // 绑定对象到User.jsp
        model.addAttribute("message", string);
        return "Hello";
    }

    @RequestMapping("/updateUser")
    public String updatFromIndex(HttpServletRequest request, Model model) {
        User user = new User();
        if (request.getParameter("id") != null) {
            int userId = Integer.parseInt(request.getParameter("id"));
            user.setId(userId);
        }
        if (request.getParameter("name") != null) {
            String userName = request.getParameter("name");
            user.setUserName(userName);
        }
        if (request.getParameter("password") != null) {
            String pin = request.getParameter("password");
            user.setPassword(pin);
        }
        if (request.getParameter("age") != null) {
            int age = Integer.parseInt(request.getParameter("age"));
            user.setId(age);
        }
        String string = this.userService.updateUser(user);
        // 绑定对象到User.jsp
        model.addAttribute("message", string);
        return "Hello";
    }
}
