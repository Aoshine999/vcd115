package com.vcd.vcd115.controller;

import com.vcd.vcd115.entity.Hire;
import com.vcd.vcd115.service.HireService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/Hire")
public class HireController {
    @Resource
    HireService hireService;

    @GetMapping("/insertHirer")
    public Boolean insertHirer(@RequestBody Hire hirer) {
        System.out.println("插入Hire中");
        try{
            Boolean resp = hireService.insertHirer(hirer);
            if(resp){
                System.out.println("----------------------------------插入成功");
            }
            return resp;
        }
        catch (Exception exception){
            System.out.println("插入失败");
            exception.printStackTrace();
            return false;
        }
    }

    @GetMapping("/findAll")
    public List<Hire> findAll(){
        System.out.println("查询所有");
        List<Hire> all = hireService.findAll();
       all.stream().forEach(t -> System.out.println(t));
       return all;
    }
}
