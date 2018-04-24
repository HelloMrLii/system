package com.iotek.controller;

import com.iotek.biz.HotelService;
import com.iotek.biz.ResumeService;
import com.iotek.model.Hotel;
import com.iotek.model.Resume;
import com.iotek.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
        resume.setU_ID(users.getU_ID());
        System.out.println("简历表中的ID"+resume.getU_ID());
        List<Resume> resumes=resumeService.selectUID(resume);
        List<Resume> resumes1=new ArrayList<Resume>();
        if (hotelList!=null){
            session.setAttribute("hotel",hotelList);
            for (Resume r:resumes){
                if (r.getRES_STATE().equals("未投递")){
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
}
