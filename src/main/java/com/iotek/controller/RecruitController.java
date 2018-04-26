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
        recruit.setRe_state("未阅读");//招聘表的状态
        Resume resume=new Resume();//简历表对象
        resume.setRes_title(request.getParameter("res_title"));//获取简历表的标题
        System.out.println(resume.getRes_title());
        resume.setRes_state("已投递");//改变投递状态
        System.out.println("");
        resumeService.updateState(resume);//改变简历表中的投递状态
        Resume resume1=resumeService.selectTitle(resume);
        System.out.println(resume1);
        recruit.setRes_id(resume1.getRes_id());
        recruit.setU_name(resume1.getRes_name());
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

    /**
     * 管理员删除求职信息
     * @param recruit
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/delectrecruit")
    public String delectrecruit(Recruit recruit,HttpSession session)throws Exception{
        if (recruitService.delectRecruit(recruit)){
            Resume resume=new Resume();
            resume.setRes_id(recruit.getRes_id());
            resume.setRes_read_state("已阅读");
            resume.setRes_state("未投递");
            resumeService.updateReadstate(resume);
            return selectrecruit(session);
        }else {
            return null;
        }
    }
}
