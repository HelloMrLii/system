package com.iotek.controller;

import com.iotek.biz.HotelService;
import com.iotek.biz.InvitedService;
import com.iotek.biz.RecruitService;
import com.iotek.model.Hotel;
import com.iotek.model.Invited;
import com.iotek.model.Recruit;
import com.iotek.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/25.
 */
@Controller
public class InvitedController {
    @Resource
    private InvitedService invitedService;
    @Resource
    private RecruitService recruitService;
    @Resource
    private HotelService hotelService;
    @Resource
    private RecruitController recruitController;

    /**
     * 插入面试邀请表
     * @param invited
     * @param request
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/insertinvite")
    public String insertinvited(Invited invited, HttpServletRequest request, HttpSession session)throws Exception{
        Date date= Date.valueOf(request.getParameter("time"));
        System.out.println("*********"+date);
        invited.setInv_time(date);//面试时间
        invited.setInv_pass("未面试");
        invited.setInv_state("未阅读");
        Recruit recruit=new Recruit();
        recruit.setRes_id(invited.getRes_id());
        Recruit recruit1=recruitService.selectResid(recruit);//通过简历的ID在求职表中找到想对应的职位
        Hotel hotel=new Hotel();
        hotel.setHot_post(recruit1.getRe_job());
        Hotel hotel1=hotelService.selectHotpost(hotel);
        invited.setInv_site(hotel1.getHot_site());
        if(invitedService.insertInvited(invited)){
            return recruitController.selectrecruit(session);
        }else {
            return "adminhome";
        }
    }

    /**
     * 用户查看面试邀请邮箱
     * @param session
     * @return
     */
    @RequestMapping("/selectinvited")
    public String selectinvited(HttpSession session){
        Invited invited=new Invited();
        Users users= (Users) session.getAttribute("user");
        invited.setU_id(users.getU_id());
        List<Invited> inviteds=invitedService.selectInvited(invited);
        for (Invited i:inviteds){
            if (i.getInv_pass().equals("未面试")&&inviteds.size()!=0){
                session.setAttribute("invited",inviteds);
                return "selectinvited";
            }
        }
        return "userhome";
    }

    /**
     * 用户处理面试邀请
     * @param invited
     * @param request
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateinvited")
    public String updateinvited(Invited invited,HttpServletRequest request,HttpSession session)throws Exception{
        String res=request.getParameter("res");
        invited.setInv_state("已阅读");
        if (res.equals("是")){
            invited.setInv_pass("面试中");
            invitedService.updateState(invited);
            return selectinvited(session);
        }else {
            invited.setInv_pass("放弃面试");
            invitedService.updateState(invited);
            return selectinvited(session);
        }
    }

    @RequestMapping("/selectinviteda")
    public String selectinviteda(HttpSession session){
        List<Invited> inviteds=invitedService.selectInviteda();
        List<Invited> inviteds1=new ArrayList<Invited>();
        for (Invited i:inviteds){
            if (!i.getInv_pass().equals("已录用")&&!i.getInv_pass().equals("已淘汰")){
                inviteds1.add(i);
            }
        }
        if (inviteds1.size()!=0){
            session.setAttribute("inviteda",inviteds1);
            return "selectinviteda";
        }
        return "adminhome";
    }
    //不被录用的处理
    @RequestMapping("/updateinviteda")
    public String updateinviteda(Invited invited,HttpSession session)throws Exception{
        invited.setInv_pass("已淘汰");
        invited.setInv_state("已阅读");
        System.out.println("********************"+invited.getInv_id());
        if (invitedService.updateState(invited)){
            return selectinviteda(session);
        }
        return "adminhome";
    }
    @RequestMapping("/adminhome")
    public String adminhome()throws Exception{
        return "adminhome";
    }
}
