package com.vcd.vcd115.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hire {

    private String Vno;

    private String Cno;

    private Double Hprice;

    private Integer Hamount;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate Htime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate Rtime;

    /**
     * 1为借，0为归还
     */
    private boolean status;

}
