package com.vcd.vcd115.service;


import com.vcd.vcd115.entity.Client;
import com.vcd.vcd115.mapper.ClientMapper;
import jakarta.annotation.Resource;

import java.util.List;

public class ClientService {

    @Resource
    ClientMapper clientMapper;
    public List<Client> findById(String cno) { return clientMapper.findById(cno); }

    public Boolean insertClient(Client client) { return clientMapper.insertClient(client); }

    public Boolean deleteById(String cno) { return clientMapper.deleteById(cno); }
}
