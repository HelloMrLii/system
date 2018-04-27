package com.iotek.controller;

import com.iotek.biz.*;
import com.iotek.model.*;
import com.sun.org.apache.regexp.internal.RE;
import javafx.geometry.Pos;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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
        //通过简历ID从面试邀请表中查出面试的岗位
        Recruit recruit=new Recruit();
        recruit.setRes_id(resume1.getRes_id());
        Recruit recruit1=recruitService.selectResid(recruit);
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
        emp.setPost_id(post1.getPost_id());
        emp.setU_id(resume1.getU_id());
        if (empService.addEmp(emp)){
            Invited invited1=new Invited();
            invited1.setInv_pass("已录用");
            invited1.setInv_state("已阅读");
            invitedService.updateState(invited1);
            return recruitController.selectrecruit(session);
        }
        return "adminhome";
    }



}
