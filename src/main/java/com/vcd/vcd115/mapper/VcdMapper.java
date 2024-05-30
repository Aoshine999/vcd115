package com.vcd.vcd115.mapper;
import com.vcd.vcd115.entity.Vcd;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface VcdMapper {
    public List<Vcd> findAll();

    public Vcd findById(@Param("Vno") String vno);

    public List<Vcd> findByType(@Param("VType") String VType);


    public Boolean updateById(@Param("vcd") Vcd vcd);

    public Boolean insertVcd(@Param("vcd") Vcd vcd);

    public Boolean deleteById(@Param("Vno") String vno);


    @Select("select * from vcd.vcd where Vno = #{Vno}")
    public Vcd findByIdT(String vno);



}
