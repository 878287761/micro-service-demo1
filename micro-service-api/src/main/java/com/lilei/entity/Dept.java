package com.lilei.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Dept {
    private Integer deptNo;
    private String deptName;
    private String dbSource;
}
