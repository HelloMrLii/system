package com.iotek.controller;

import com.iotek.biz.ResumeService;
import com.iotek.model.Resume;
import com.iotek.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2018/4/23.
 */
@Controller
public class ResumeController {
    @Resource
    private ResumeService resumeService;

    /**
     * 创建简历
     * @param resume
     * @return
     * @throws Exception
     */
    @RequestMapping("/insertresume")
    public String inster(Resume resume,HttpSession session)throws Exception{
        Users users= (Users) session.getAttribute("user");
        resume.setU_ID(users.getU_ID());
        resume.setRES_STATE("未投递");
        resume.setRES_READ_STATE("未阅读");
        if (resumeService.addResume(resume)){
            return "userhome";
        }else {
            return "userhome";
        }

    }

    /**
     * 游客查看简历
     * @param session
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping("/selectresume")
    public String select(HttpSession session)throws Exception{
        Users users= (Users) session.getAttribute("user");
        System.out.println(users);
        Resume resume=new Resume();
        resume.setU_ID(users.getU_ID());
        System.out.println("简历表中的用户ID"+resume.getU_ID());
        List<Resume> resumes=resumeService.selectUID(resume);
        if (resumes.size()==0){
            return "insertresume";
        }else {
            session.setAttribute("resume",resumes);
            System.out.println("查看简历中的简历长度"+resumes.size());
           return "selectresume";
        }
    }

    /***
     * 跳转到添加简历页面
     * @return
     */
    @RequestMapping("/addresume")
    public String addresume(){
        return "insertresume";
    }

    /**
     * 删除简历
     * @param resume
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/delectresume")
    public String delectresume(Resume resume,HttpSession session)throws Exception{
        if (resume.getRES_READ_STATE().equals("未阅读")){
            return select(session);
        }
        if (resumeService.delectResume(resume)){
            return select(session);
        }else {
            return "selectresume";
        }
    }

    /**
     * 管理员查看求职者简历
     * @param resume
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/selectresumeid")
    public String selectResumeid(Resume resume,HttpSession session)throws Exception{
        Resume resume1=resumeService.selectID(resume);
        if (resume1!=null){
            session.setAttribute("resumes",resume1);
            return "selectresumeid";
        }else {
            return "selectrecruit";
        }
    }
}
