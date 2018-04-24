package com.iotek.controller;

import com.iotek.biz.RecruitService;
import com.iotek.biz.ResumeService;
import com.iotek.model.Recruit;
import com.iotek.model.Resume;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2018/4/24.
 */
@Controller
public class RecruitController {
    @Resource
    private RecruitService recruitService;
    @Resource
    private ResumeService resumeService;
    @Resource
    private HotelController hotelController;

    /**
     * 投递简历
     * @param recruit
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/addrecruit")
    public String addrecruit(Recruit recruit, HttpServletRequest request, HttpSession session)throws Exception{
        recruit.setRE_STATE("未阅读");//招聘表的状态
        Resume resume=new Resume();//简历表对象
        resume.setRES_TITLE(request.getParameter("RES_TITLE"));
        resume.setRES_STATE("已投递");
        System.out.println("");
        resumeService.updateState(resume);//改变简历表中的投递状态
        Resume resume1=resumeService.selectTitle(resume);
        System.out.println(resume1);
        recruit.setRES_ID(resume1.getRES_ID());
        recruit.setU_NAME(resume1.getRES_NAME());
        if (recruitService.addRecruit(recruit)){
           return hotelController.selecthotel(session);
        }else {
            return "userhome";
        }
    }

    /**
     * 管理员查看求职信息
     * @param session
     * @return
     */
    @RequestMapping("/selectrecruit")
    public String selectrecruit(HttpSession session){
        List<Recruit> recruits=recruitService.selectRecruit();
        System.out.println("管理员查看所有邮件:"+recruits.size());
        if (recruits.size()!=0){
            session.setAttribute("recruit",recruits);
            return "selectrecruit";
        }else {
            return "adminhome";
        }
    }
}
