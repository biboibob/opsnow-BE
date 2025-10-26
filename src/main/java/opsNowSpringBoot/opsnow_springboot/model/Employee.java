package opsNowSpringBoot.opsnow_springboot.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Employee {
    private int empno;
    private String empname;
    private int tiercode;
    private String locationcode;
    private String departmentcode;
    private Integer supervisorcode;
    private int salary;
    private LocalDateTime entrydate;
}
