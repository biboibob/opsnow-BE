package opsNowSpringBoot.opsnow_springboot.rest;

import jakarta.annotation.PostConstruct;
import opsNowSpringBoot.opsnow_springboot.entity.departmentE;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class department {

    private List<departmentE> departmentList;

    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }

    @PostConstruct
    public void loadData() {
        departmentList = new ArrayList<>();

        departmentList.add(new departmentE("G", "Governance"));
        departmentList.add(new departmentE("E", "ETL"));
    }

    @GetMapping("/departments")
    public List<departmentE> getDepartmentList() {
        return departmentList;
    }

    @GetMapping("/departments/{departmentIdx}")
    public departmentE getDepartement(@PathVariable int departmentIdx) {
        return departmentList.get(departmentIdx);
    }


}
