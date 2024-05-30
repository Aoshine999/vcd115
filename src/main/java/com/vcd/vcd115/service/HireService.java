package com.vcd.vcd115.service;

import com.vcd.vcd115.entity.Hire;
import com.vcd.vcd115.mapper.HireMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HireService {
    @Resource
    HireMapper hireMapper;

    public Boolean insertHirer(Hire hirer) { return hireMapper.insertHirer(hirer); }

    public List<Hire> findAll() { return hireMapper.findAll(); }
}
