package com.vcd.vcd115.service;

import com.vcd.vcd115.entity.Admin;
import com.vcd.vcd115.mapper.AdminMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Resource
    AdminMapper adminMapper;

    public Admin checkNameAndPass(String username){
        Admin res = adminMapper.checkNameAndPass(username);
        return res;
    }
}
