package com.iotek.controller;

import com.iotek.biz.*;
import com.iotek.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/23.
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private AdminService adminService;
    @Resource
    private EmpService empService;
    @Resource
    private DeptService deptService;
    @Resource
    private TrainService trainService;

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
            users.setU_pass(pass);
            Users users1=userService.selectUSers(users);
            if (users1!=null){
                Emp emp=new Emp();
                emp.setU_id(users1.getU_id());
                Emp emp1=empService.selectUid(emp);
                session.setAttribute("user",users1);
                session.setAttribute("emp",emp1);
                return "userhome";
            }else {
               Emp emp2=new Emp();
               emp2.setEmp_name(name);
               emp2.setEmp_pass(pass);
               Emp emp3=empService.login(emp2);
               if (emp3!=null){
                   Dept dept=new Dept();
                   dept.setDept_id(emp3.getDept_id());
                   Dept dept1=deptService.selectID(dept);
                   List<Train> train=trainService.selectAll();
                   List<Train> trains=new ArrayList<Train>();
                   for (Train t:train){
                       if (dept1.getDept_name().equals(t.getT_dept())&&!t.getT_ps().equals("已结束")){
                           trains.add(t);
                       }
                   }
                   model.addAttribute("train",trains);
                   model.addAttribute("emp",emp3);
                   return "emphome";
               }
            }
        }
        return null;
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
            users.setU_pass(pass);
            users.setU_state(1);
            if (userService.addUser(users)){
                return "../../index";
            }
        }
        return "register";
    }
    @RequestMapping("/returnlogin")
    public String returnlogin(){
        return "../../index";
    }
}
