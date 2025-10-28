package opsNowSpringBoot.opsnow_springboot.controller;

import opsNowSpringBoot.opsnow_springboot.model.Department;
import opsNowSpringBoot.opsnow_springboot.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import opsNowSpringBoot.opsnow_springboot.util.ResponseUtil;
import opsNowSpringBoot.opsnow_springboot.dto.APIResponse;

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
    public ResponseEntity<APIResponse<Department>> create(@RequestBody Department d) {
        Department created = service.create(d);
        return ResponseUtil.success(created);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody Department d) {
        d.setDepartmentcode(id);
        service.update(d);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
