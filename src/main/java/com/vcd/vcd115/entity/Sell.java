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
public class Sell {
    private String Vno;

    private String Cno;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate Stime;

    private Integer Samount;
}
