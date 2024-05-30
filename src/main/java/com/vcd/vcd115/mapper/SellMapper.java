package com.vcd.vcd115.mapper;

import com.vcd.vcd115.entity.Sell;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SellMapper {

    public Boolean insertBuyer(@Param("Sell") Sell sell);

    public List<Sell> findBySearch(@Param("Sell") Sell sell);

}
