package com.vcd.vcd115.mapper;

import com.vcd.vcd115.entity.Client;
import com.vcd.vcd115.entity.Stock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClientMapper {
    public List<Client> findById(@Param("Cno") String cno);

    public Boolean insertClient(@Param("Client") Client client);

    public Boolean deleteById(@Param("Cno") String cno);
}
