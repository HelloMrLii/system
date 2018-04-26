package com.iotek.controller;

import com.iotek.biz.AdminService;
import com.iotek.model.Admin;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/4/25.
 */
@Controller
public class AdminController {
    @Resource
    private AdminService adminService;

}
