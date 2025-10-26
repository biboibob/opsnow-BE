package opsNowSpringBoot.opsnow_springboot.controller;

import opsNowSpringBoot.opsnow_springboot.model.Department;
import opsNowSpringBoot.opsnow_springboot.service.DepartmentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Department> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Department getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping
    public String create(@RequestBody Department d) {
        service.create(d);
        return "Department created successfully";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable String id, @RequestBody Department d) {
        d.setDepartmentcode(id);
        service.update(d);
        return "Department updated successfully";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        service.delete(id);
        return "Department deleted successfully";
    }
}
