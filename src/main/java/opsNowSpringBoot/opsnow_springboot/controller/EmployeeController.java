package opsNowSpringBoot.opsnow_springboot.controller;

import opsNowSpringBoot.opsnow_springboot.model.Employee;
import opsNowSpringBoot.opsnow_springboot.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Employee> getAll() {
        return service.getAllEmployees();
    }

//    @GetMapping("/{empno}")
//    public Employee getById(@PathVariable int empno) {
//        return service.getEmployeeById(empno);
//    }
//
//    @PostMapping
//    public void add(@RequestBody Employee emp) {
//        service.addEmployee(emp);
//    }
//
//    @PutMapping("/{empno}")
//    public void update(@PathVariable int empno, @RequestBody Employee emp) {
//        emp.setEmpno(empno);
//        service.updateEmployee(emp);
//    }
//
//    @DeleteMapping("/{empno}")
//    public void delete(@PathVariable int empno) {
//        service.deleteEmployee(empno);
//    }
}
