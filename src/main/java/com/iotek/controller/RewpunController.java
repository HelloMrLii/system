package com.iotek.controller;

import com.iotek.biz.EmpService;
import com.iotek.biz.RewpunService;
import com.iotek.model.Emp;
import com.iotek.model.Rewpun;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/5/3.
 */
@Controller
public class RewpunController {
    @Resource
    private RewpunService rewpunService;
    @Resource
    private EmpService empService;
    @RequestMapping("/addrewpunadmin")
    public String addrewpunadmin(Model model)throws Exception{
        List<Emp> emp=empService.selectAll();
        model.addAttribute("emp",emp);
        return "addrewpunadmin";
    }
    @RequestMapping("/insertrewpunadmin")
    public String insertrewpunadmin(Rewpun rewpun,Model model)throws Exception{
        Date date=new Date();
        java.sql.Date date1=new java.sql.Date(date.getTime());
        rewpun.setRewpun_time(date1);
        if (rewpunService.insertRewpun(rewpun)){
            return addrewpunadmin(model);
        }
        return "adminhome";
    }
}
