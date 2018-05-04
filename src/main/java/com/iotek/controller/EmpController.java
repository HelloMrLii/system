package com.iotek.controller;

import com.iotek.biz.*;
import com.iotek.model.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/4/26.
 */
@Controller
public class EmpController {
    @Resource
    private InvitedService invitedService;
    @Resource
    private EmpService empService;
    @Resource
    private ResumeService resumeService;
    @Resource
    private UserService userService;
    @Resource
    private RecruitService recruitService;
    @Resource
    private DeptService deptService;
    @Resource
    private PostService postService;
    @Resource
    private RecruitController recruitController;
    //录入员工
    @RequestMapping("/addemp")
    public String addemp(Invited invited,HttpSession session)throws Exception{//传入游客ID
      Resume resume=new Resume();
      resume.setRes_id(invited.getRes_id());
      //通过游客Id查出密码
      Users users=new Users();
      users.setU_id(invited.getU_id());
      Users users1=userService.selectID(users);
      //通过简历ID获取简历中的员工信息
      Resume resume1=resumeService.selectID(resume);
        Emp emp=new Emp();
        emp.setEmp_name(resume1.getRes_phone());
        emp.setEmp_sex(resume1.getRes_sex());
        emp.setEmp_pass(users1.getU_pass());
        emp.setEmp_real_name(resume1.getRes_name());
        //通过简历ID从面试邀请表中查出面试的岗位
        Recruit recruit=new Recruit();
        recruit.setRes_id(resume1.getRes_id());
        Recruit recruit1=recruitService.selectResid(recruit);
        System.out.println(recruit1.getRe_job()+"**********************************");
        String str[]=recruit1.getRe_job().split("部");
        String dept_name=str[0]+"部";
        String post_name=str[1];
        Dept dept=new Dept();
        dept.setDept_name(dept_name);
        Dept dept1=deptService.selectDept(dept);
        emp.setDept_id(dept1.getDept_id());
        Post post=new Post();
        post.setDept_id(dept1.getDept_id());
        post.setPost_name(post_name);
        Post post1=postService.selectNameandID(post);
        System.out.println("************"+post1);
        emp.setPost_id(post1.getPost_id());
        emp.setU_id(resume1.getU_id());
        Date date=new Date();
        java.sql.Date date1=new java.sql.Date(date.getTime());
        emp.setEmp_time(date1);
        emp.setEmp_state("试用期");
        if (empService.addEmp(emp)){
            Invited invited1=new Invited();
            invited1.setInv_pass("已录用");
            invited1.setInv_state("已阅读");
            invitedService.updateState(invited1);
            return recruitController.selectrecruit(session);
        }
        return "adminhome";
    }

    @RequestMapping("/updatedept")
    public String selectemp(Model model)throws Exception{
        List<Emp> emps=empService.selectAll();
        List<Dept> dept=deptService.selectAll();
        model.addAttribute("emp",emps);
        model.addAttribute("dept",dept);
        return "updatedept";
    }

     @RequestMapping("/updateempdept")
    public String update(Emp emp,Model model)throws Exception{
        if (empService.updatedept(emp)){
            return selectemp(model);
        }
        return "adminhome";

     }
}
