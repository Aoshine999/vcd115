package com.vcd.vcd115.controller;

import com.vcd.vcd115.entity.Vcd;
import com.vcd.vcd115.mapper.VcdMapper;
import com.vcd.vcd115.service.VcdService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/vcd")
public class VcdController {
    @Resource
    private VcdService vcdService;

    @GetMapping("/findById/{vno}")
    public Vcd findById(@PathVariable("vno") String vno){
        System.out.println("查询vcd by vno " + vno);
 //       return vcdMapper.findByIdT(vno);
       return vcdService.findById(vno);
//        return null;
    }

    @GetMapping("/findByPage/{page}/{size}")
    public List<Vcd> findByPage(@PathVariable("page") int page, @PathVariable("size") int size){
        System.out.println("查询列表分页" + page + " " + size);
        return vcdService.findByPage(page,size);
    }


    @GetMapping("/findByType/{VType}")
    public List<Vcd> findByType(@PathVariable("VType") String vtype){
        System.out.println("查询vcd by Type: " + vtype);
        return vcdService.findByType(vtype);
    }



    @GetMapping("/getLength")
    public Integer getLength(){ return vcdService.getLength();}



    @GetMapping("/updateById")
    public Boolean updateById(@RequestBody Vcd vcd){
        System.out.println("更新 " + vcd);
        return vcdService.updateById(vcd);
    }



    @GetMapping("/insertVcd")
    public Boolean insertVcd(@RequestBody Vcd vcd){
        System.out.println("添加 " + vcd);
        return vcdService.insertVcd(vcd);
    }


    @GetMapping("/deleteById/{vno}")
    public Boolean deleteById(@PathVariable("vno") String vno){
        System.out.println("正在删除 vcd vno: " + vno);
        return vcdService.deleteById(vno);
    }

}
