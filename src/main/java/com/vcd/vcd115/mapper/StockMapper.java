package com.vcd.vcd115.mapper;

import com.vcd.vcd115.entity.Stock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StockMapper {
    public List<Stock> findById(@Param("Vno") String vno);

    public Boolean insertStock(@Param("stock") Stock stock);

    public Boolean deleteById(@Param("Vno") String vno);
}
