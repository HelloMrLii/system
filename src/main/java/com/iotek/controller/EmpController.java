package com.iotek.controller;

import com.iotek.biz.EmpService;
import com.iotek.biz.ResumeService;
import com.iotek.model.Invited;
import com.iotek.model.Resume;
import com.iotek.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2018/4/26.
 */
@Controller
public class EmpController {
    @Resource
    private EmpService empService;
    @Resource
    private ResumeService resumeService;
    @RequestMapping("/addemp")
    public String addemp(Invited invited, Model model)throws Exception{
        Resume resume=new Resume();
        resume.setU_id(invited.getU_id());
        Resume resume1=resumeService.selectID(resume);
        model.addAttribute("resume",resume1);
        return null;
    }

}
