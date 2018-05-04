package com.iotek.controller;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.iotek.biz.DeptService;
import com.iotek.biz.HotelService;
import com.iotek.biz.PostService;
import com.iotek.biz.ResumeService;
import com.iotek.model.*;
import com.sun.org.apache.xpath.internal.operations.Mod;
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
        for (Dept d:depts){
            System.out.println(d);
        }
        model.addAttribute("depts",depts);
        return "addhotel";
    }
//添加招聘信息
    @RequestMapping("/inserthotel")
    public String inserthotel(Hotel hotel,HttpServletRequest request,Model model)throws Exception{
        String dept=request.getParameter("dept");//获取前台的部门名称
        String post=request.getParameter("post");//获取前台的职位名称
        String hot_post=dept+post;//岗位
        Hotel hotel2=new Hotel();
        hotel2.setHot_post(hot_post);
        Hotel hotel1=hotelService.selectHotpost(hotel2);//查看表中是否已有此岗位的招聘信息
        if (hotel1!=null){
            return "adminhome";
        }
        Date date=new Date();
        java.sql.Date date1=new java.sql.Date(date.getTime());//获取发布时间
        hotel.setHot_rel_time(date1);//set发布时间
        System.out.println(hot_post);
        hotel.setHot_post(hot_post);//set岗位
        Dept dept1=new Dept();
        dept1.setDept_name(dept);
        Dept dept2=deptService.selectDept(dept1);//查出部门信息，与职位对应
        Post post1=new Post();
        post1.setPost_name(post);//set职位名称
        post1.setDept_id(dept2.getDept_id());//set部门ID
        Post post2=postService.selectNameandID(post1);//目的是获取薪资
        hotel.setHot_money(post2.getPost_money());
        if (hotelService.addHotel(hotel)){
            return "adminhome";
        }
        return addhotel(model);
    }
    //管理员查看招聘信息
    @RequestMapping("/selecthotela")
    public String selecthotela(Model model)throws Exception{
        List<Hotel> hotelList=hotelService.selectHotel();
        if (hotelList!=null){
            model.addAttribute("hotel",hotelList);
            return "selecthoteladmin";
        }
        return addhotel(model);
    }
    //管理员删除招聘信息
    @RequestMapping("/delecthotel")
    public String delecthotel(Hotel hotel,Model model)throws Exception{
        if (hotelService.delecthotel(hotel)){
            return selecthotela(model);
        }
        return "adminhome";
    }
    //管理员修改招聘信息
    @RequestMapping("/updatehotel")
    public String updatehotel(Hotel hotel,Model model)throws Exception{
        if(hotelService.updatehotel(hotel)){
            return selecthotela(model);
        }
        return "adminhome";
    }
}
