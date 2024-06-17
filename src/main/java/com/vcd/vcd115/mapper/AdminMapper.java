package com.vcd.vcd115.mapper;


import com.vcd.vcd115.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AdminMapper {
    Admin checkNameAndPass(@Param("sname") String adminName);
}
