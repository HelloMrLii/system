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
        Dept depts=deptService.selectDept(dept);
        String post_name=request.getParameter("post_name");
        if (depts!=null){
            Post post=new Post();
            post.setPost_name(post_name);
            Post post1=postService.selectName(post);
            if (post1==null){
                post.setDept_id(depts.getDept_id());
                post.setPost_name(post_name);
                postService.insertPost(post);
                return "adminhome";
            }else {
                return adddept(model);
            }
        }else {
            deptService.insertDept(dept);//插入数据
            Dept dept1 = deptService.selectDept(dept);//查找出来用id
            Post post = new Post();
            post.setDept_id(dept1.getDept_id());
            post.setPost_name(post_name);
            postService.insertPost(post);
            return "adminhome";
        }
    }
}
