package opsNowSpringBoot.opsnow_springboot.service;

import opsNowSpringBoot.opsnow_springboot.model.Department;
import opsNowSpringBoot.opsnow_springboot.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository repo;

    public DepartmentService(DepartmentRepository repo) {
        this.repo = repo;
    }

    public List<Department> getAll() {
        return repo.findAll();
    }

    public Department getById(String id) {
        return repo.findById(id);
    }

    public Department create(Department d) {
        repo.save(d);   // assuming it persists the record
        return d;
    }

    public int update(Department d) {
        return repo.update(d);
    }

    public int delete(String id) {
        return repo.delete(id);
    }
}
