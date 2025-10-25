package opsNowSpringBoot.opsnow_springboot.rest;

import  opsNowSpringBoot.opsnow_springboot.entity.departmentE;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class department {

    private List<department> departmentList;

    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }

    @GetMapping("/departments")
    public List<departmentE> getDepartmentList() {
        List<departmentE> departmentList = new ArrayList<>();

        departmentList.add((new departmentE("G", "Governance")));
        departmentList.add((new departmentE("E", "ETL")));


        return departmentList;

    }


}
