package com.iotek.controller;

import com.iotek.biz.DeptService;
import com.iotek.biz.EmpService;
import com.iotek.biz.PostService;
import com.iotek.model.Dept;
import com.iotek.model.Emp;
import com.iotek.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/26.
 */
@Controller
public class PostController {
    @Resource
    private PostService postService;
    @Resource
    private DeptService deptService;
    @Resource
    private EmpService empService;
    @RequestMapping("/selectpost")
    @ResponseBody
    public List<Post> selectpost(Dept dept)throws Exception{
        System.out.println(dept);
        Dept dept1=deptService.selectDept(dept);
        Post post=new Post();
        post.setDept_id(dept1.getDept_id());
        List<Post> posts=postService.selectDeptid(post);
        return posts;
    }
    @RequestMapping("/selectpostid")
    @ResponseBody
    public List<Post> selectpostid(Dept dept)throws Exception{
       Dept dept1=deptService.selectID(dept);
       Post post=new Post();
       post.setDept_id(dept1.getDept_id());
        List<Post> posts=postService.selectDeptid(post);
        return posts;
    }

}
