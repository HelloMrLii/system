package com.iotek.controller;

import com.iotek.biz.DeptService;
import com.iotek.biz.PostService;
import com.iotek.model.Dept;
import com.iotek.model.Post;
import javafx.geometry.Pos;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/4/25.
 */
@Controller
public class DeptController {
    @Resource
    private DeptService deptService;
    @Resource
    private PostService postService;
    /**
     * 查找所有部门，并跳转界面
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/adddept")
    public String adddept(Model model)throws Exception{
        List<Dept> depts=deptService.selectAll();
        model.addAttribute("dept",depts);
        return "adddept";
    }

    /**
     * 插入部门和职位表
     * @param dept
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/insertdept")
    public String insertdept(Dept dept, HttpServletRequest request,Model model)throws Exception{
        dept.setDept_name(request.getParameter("select"));//获取前台传回的部门名称
        int number= Integer.parseInt(request.getParameter("class"));//获取前台传回的等级
        Dept depts=deptService.selectDept(dept);//传回部门名称然后在表中找是否有相同
        Date date=new Date();
        java.sql.Date date1=new java.sql.Date(date.getTime());//获取创建的时间
        String post_name=request.getParameter("post_name");//接收前台传回的职位名称
        System.out.println("********"+post_name);
        if (depts!=null){//如果部门表中有相同的部门
            if (post_name!=null){//而且前台传回的值不是个空
                Post post=new Post();
                post.setPost_name(post_name);//职位名称
                Post post1=postService.selectName(post);//在职位表中查询是否有相同的职位
                if (post1==null){//如果没有相同的职位
                    post.setDept_id(depts.getDept_id());//set部门id
                    post.setPost_name(post_name);//set职位名称
                    post.setPost_class(number);//set职位等级
                    switch (number){//set职位的基本工资
                        case 1:
                            post.setPost_money(8000);
                            break;
                        case 2:
                            post.setPost_money(6000);
                            break;
                        case 3:
                            post.setPost_money(4000);
                            break;
                    }
                    postService.insertPost(post);
                    return "adminhome";
                }else {
                    return adddept(model);
                }
            }
        }else {//如果传回的部门名称表中没有
            dept.setDept_time(date1);//set部门创建时间
            deptService.insertDept(dept);//插入数据
            if (post_name!=null){//如果传回来的职位名称不为空
                Dept dept1 = deptService.selectDept(dept);//通过传回来的部门名称查找出来用部门名称
                Post post = new Post();
                post.setDept_id(dept1.getDept_id());//set职位所对应的部门id
                post.setPost_name(post_name);//set职位的名字
                post.setPost_class(number);//set职位的等级
                switch (number){//set职位的基本工资
                    case 1:
                        post.setPost_money(8000);
                        break;
                    case 2:
                        post.setPost_money(6000);
                        break;
                    case 3:
                        post.setPost_money(4000);
                        break;
                }
                postService.insertPost(post);
                return "adminhome";
            }
        }
        return "adminhome";
    }
    //查看部门信息
    @RequestMapping("/selectdepta")
    public String selectdept(Model model,HttpSession session)throws Exception{
        List<Dept> depts=deptService.selectAll();
        if (depts!=null){
            session.setAttribute("depts",depts);
            return "selectdepta";
        }
        return adddept(model);
    }
    //添加培训
    @RequestMapping("/addtrain")
    public String addtrain(Model model)throws Exception{
        List<Dept> depts=deptService.selectAll();
        model.addAttribute("dept",depts);
        return "addtrain";
    }
}
