package com.vcd.vcd115.mapper;


import com.vcd.vcd115.entity.Hire;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HireMapper {


    public List<Hire> findAll();


    public Boolean insertHirer(@Param("Hire") Hire hirer);

    public Boolean updateById(@Param("Hire") Hire hirer);
}
