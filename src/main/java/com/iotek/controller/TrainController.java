package com.iotek.controller;

import com.iotek.biz.DeptService;
import com.iotek.biz.TrainService;
import com.iotek.model.Dept;
import com.iotek.model.Train;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/5/3.
 */
@Controller
public class TrainController {
    @Resource
    private TrainService trainService;
    @Resource
    private DeptController controller;
    @Resource
    private DeptService deptService;
    //添加培训信息
    @RequestMapping("/inserttrain")
    public String inserttrain(String start_Time,String over_Time,Train train, Model model, HttpServletRequest request)throws Exception{
        String start_time=start_Time.substring(0,10)+" "+start_Time.substring(11,16);
        String over_time=over_Time.substring(0,10)+" "+over_Time.substring(11,16);
        Date startTime=new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(start_time);
        Date overTime=new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(over_time);
        train.setT_start_time(startTime);
        train.setT_over_time(overTime);
        System.out.println(train+"*****************************");
        train.setT_ps("未开始");
        if (trainService.addTrain(train)) {
            return "adminhome";
        }
        return controller.addtrain(model);
    }
    //管理员浏览培训信息
    @RequestMapping("/selecttrain")
    public String selecttrain(Model model)throws Exception{
        List<Train> trains=trainService.selectAll();
        if (trains.size()!=0){
            model.addAttribute("train",trains);
            return "selecttrain";
        }
        return "adminhome";
    }
    //管理员修改培训信息
    @RequestMapping("/updatetrain")
    public String updatetrain(String t_Dept,Train train,Model model)throws Exception{
        Dept dept=new Dept();
        dept.setDept_name(t_Dept);
        Dept dept1=deptService.selectDept(dept);
        if (dept1==null){
            return selecttrain(model);
        }
        train.setT_dept(t_Dept);
        if (trainService.updatetrain(train)){
            return selecttrain(model);
        }
        return "adminhome";
    }
    //删除培训信息
    @RequestMapping("/delecttrain")
    public String delecttrain(Train train,Model model)throws Exception{
        if (train.getT_ps().equals("培训中")){
            return selecttrain(model);
        }
        if (trainService.delecttrain(train)){
            return selecttrain(model);
        }
        return "adminhome";
    }
}
