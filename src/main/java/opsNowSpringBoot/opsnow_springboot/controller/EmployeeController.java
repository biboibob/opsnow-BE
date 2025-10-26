package opsNowSpringBoot.opsnow_springboot.controller;

import opsNowSpringBoot.opsnow_springboot.model.Employee;
import opsNowSpringBoot.opsnow_springboot.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.time.LocalDateTime;

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

    @GetMapping("/{empno}")
    public ResponseEntity<Employee> getById(@PathVariable int empno) {
        Employee employee = service.getEmployeeById(empno);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public void add(@RequestBody Employee emp) {
        emp.setEntrydate(LocalDateTime.now());
        service.addEmployee(emp);
    }

    @PutMapping("/{empno}")
    public void update(@PathVariable int empno, @RequestBody Employee emp) {
        emp.setEmpno(empno);
        service.updateEmployee(emp);
    }


    @DeleteMapping("/{empno}")
    public void delete(@PathVariable int empno) {
        service.deleteEmployee(empno);
    }
}
