package com.iotek.controller;

import com.iotek.biz.AdminService;
import com.iotek.biz.UserService;
import com.iotek.model.Admin;
import com.iotek.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2018/4/23.
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private AdminService adminService;
    /**
     * 登录
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/login")
    public String login(HttpSession session,Model model,HttpServletRequest request)throws Exception{
        String name=request.getParameter("u_name");
        String pass=request.getParameter("u_pass");
        System.out.println(name+"22222222"+pass);
        if (pass.equals("admin")){
            Admin admin=new Admin();
            admin.setAd_name(name);
            admin.setAd_pass(pass);
            Admin admin1=adminService.login(admin);
            if (admin1!=null){
                session.setAttribute("user",admin1);
                return "adminhome";
            }else {
                model.addAttribute("error","用户名或密码错误");
                return "../../index";
            }
        }else {
            Users users=new Users();
            users.setU_name(name);
            users.setU_pass(name);
            Users users1=userService.selectUSers(users);
            if (users1!=null){
                session.setAttribute("user",users1);
                return "userhome";
            }else {
                return "../../index";
            }
        }
    }

    /**
     * 跳转
     * @return
     */
    @RequestMapping("/insert")
    public String insert(){
        return "register";
    }

    /**
     * 注册，管理员注册和游客注册（员工用分配的账号和密码，不需要注册）
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/register")
    public String register(HttpServletRequest request)throws Exception{
        String name=request.getParameter("U_NAME");
        String pass=request.getParameter("U_PASS");
        Users users=new Users();
        Admin admin=new Admin();
        if (pass.equals("admin")){
            admin.setAd_name(name);
            admin.setAd_pass(pass);
            admin.setAd_state(3);
            if (adminService.insertAdmin(admin)){
                return "../../index";
            }
        }else {
            users.setU_name(name);
            users.setU_pass(name);
            users.setU_state(1);
            if (userService.addUser(users)){
                return "../../index";
            }
        }
        return "register";
    }
}
