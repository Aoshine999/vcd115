package com.vcd.vcd115.service;

import com.vcd.vcd115.entity.Stock;
import com.vcd.vcd115.mapper.StockMapper;
import jakarta.annotation.Resource;

import java.util.List;

public class StockService {
    @Resource
    StockMapper stockMapper;

    public List<Stock> findById(String vno){ return stockMapper.findById(vno); }

    public Boolean insertStock(Stock stock){ return stockMapper.insertStock(stock); }

    public Boolean deleteById(String vno) {return stockMapper.deleteById(vno); }
}
