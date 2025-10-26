package opsNowSpringBoot.opsnow_springboot.service;

import opsNowSpringBoot.opsnow_springboot.model.Employee;
import opsNowSpringBoot.opsnow_springboot.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    public Employee getEmployeeById(int empno) {
        return repo.findById(empno);
    }

    public void addEmployee(Employee emp) {
        repo.insert(emp);
    }

    public void updateEmployee(Employee emp) {
        repo.update(emp);
    }

    public void deleteEmployee(int empno) {
        repo.delete(empno);
    }
}
