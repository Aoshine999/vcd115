package com.vcd.vcd115.controller;

import com.vcd.vcd115.entity.Admin;
import com.vcd.vcd115.service.AdminService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class AdminController {
    @Resource
    AdminService adminService;

    @PostMapping("/login")
    public Boolean login(@RequestBody Admin admin){
        System.out.println("验证管理员信息登录");
        Admin admin1 = adminService.checkNameAndPass(admin.getPassword());
        System.out.println(admin1);
        if(admin1 == null | !admin.getPassword().equals(admin1.getPassword())){
            System.out.println("返回失败");
            return false;
        }
        else {
            System.out.println("返回成功");
            return true;
        }
    }
}
