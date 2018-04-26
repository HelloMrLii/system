package com.iotek.controller;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.iotek.biz.DeptService;
import com.iotek.biz.HotelService;
import com.iotek.biz.PostService;
import com.iotek.biz.ResumeService;
import com.iotek.model.Dept;
import com.iotek.model.Hotel;
import com.iotek.model.Resume;
import com.iotek.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/4/23.
 */
@Controller
public class HotelController {
    @Resource
    private HotelService hotelService;
    @Resource
    private ResumeService resumeService;
@Resource
private DeptService deptService;
@Resource
private PostService postService;
    /**
     * 查看所有招聘信息
     * @return
     * @throws Exception
     */
    @RequestMapping("/selecthotel")
    public String selecthotel(HttpSession session)throws Exception{
        List<Hotel> hotelList=hotelService.selectHotel();
        Users users= (Users) session.getAttribute("user");
        Resume resume=new Resume();
        resume.setU_id(users.getU_id());
        List<Resume> resumes=resumeService.selectUID(resume);
        List<Resume> resumes1=new ArrayList<Resume>();
        if (hotelList!=null){
            session.setAttribute("hotel",hotelList);
            for (Resume r:resumes){
                if (r.getRes_state().equals("未投递")){
                    resumes1.add(r);
                }
            }
            session.setAttribute("resume",resumes1);
            System.out.println("resume*****************"+resumes1.size());
            System.out.println("过来了");
            return "selecthotel";
        }else {
            return "userhome";
        }
    }
    @RequestMapping("/skip")
    public String skip(){
        return "userhome";
    }


    @RequestMapping("/addhotel")
    public String addhotel(Model model)throws Exception{
        List<Dept> depts=deptService.selectAll();
        model.addAttribute("depts",depts);
        return "addhotel";
    }

    @RequestMapping("/inserthotel")
    public String inserthotel(Hotel hotel,HttpServletRequest request,Model model)throws Exception{
        Date date=new Date();
        java.sql.Date date1=new java.sql.Date(date.getTime());
        hotel.setHot_rel_time(date1);
        String dept=request.getParameter("dept");
        String post=request.getParameter("post");
        String hot_post=dept+post;
        System.out.println(hot_post);
        hotel.setHot_post(hot_post);
        if (hotelService.addHotel(hotel)){
            return "adminhome";
        }
        return addhotel(model);
    }
}
