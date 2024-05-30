package com.vcd.vcd115.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {

    private String Vno;

    private String Samount;

    private Date Stime;
}
