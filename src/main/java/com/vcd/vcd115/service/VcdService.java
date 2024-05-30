package com.vcd.vcd115.service;

import com.vcd.vcd115.entity.Vcd;
import com.vcd.vcd115.mapper.VcdMapper;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class VcdService {
    @Resource
    VcdMapper vcdMapper;

    public List<Vcd> findByPage(Integer num, Integer size){
        // num: 第几页, size 一页多大
        // num: 从0开始
        List<Vcd> vcdList = vcdMapper.findAll();
        ArrayList<Vcd> list = new ArrayList<>();

        int start = size * num;
        int end = size * (num + 1);
        int sz = vcdList.size();

        for(int i = start; i < end && i < sz; i++){
            list.add(vcdList.get(i));
        }

        return list;
    }

    public Vcd findById(String vno){ return vcdMapper.findById(vno);}

    public List<Vcd> findByType(String VType){ return vcdMapper.findByType(VType);}



    public Integer getLength(){ return vcdMapper.findAll().size();}



    public Boolean updateById(Vcd vcd){ return vcdMapper.updateById(vcd); }


    public Boolean insertVcd(Vcd vcd){ return vcdMapper.insertVcd(vcd); }

    public Boolean deleteById(String vno){ return vcdMapper.deleteById(vno); }
}
