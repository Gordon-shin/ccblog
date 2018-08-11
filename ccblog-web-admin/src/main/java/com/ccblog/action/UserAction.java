package com.ccblog.action;

import com.ccblog.pojo.po.User;
import com.ccblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2018/2/3/003.
 */
@Controller
public class UserAction {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(){
        return "login2";
    }

    @RequestMapping("/logincheck")
    public String loginCheck(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username为"+username);
        System.out.println("password为"+password);
        User user = userService.testShowUser(1);
        request.getSession().setAttribute("user", user);
        //获得ip地址
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        System.out.println("ip地址为"+ip);

        return  "redirect:/ ";
    }

    //退出登录
    @RequestMapping("/logout")
    public String logout(HttpSession session) throws Exception {
        session.removeAttribute("user");
        session.invalidate();
        return "redirect:/login";
    }
}
