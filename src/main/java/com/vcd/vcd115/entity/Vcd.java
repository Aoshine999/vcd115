package com.vcd.vcd115.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vcd {

    private String Vno;

    private String Vname;

    private String Author;

    private Double Price;

    private Integer amount;

    private String VType;
}
