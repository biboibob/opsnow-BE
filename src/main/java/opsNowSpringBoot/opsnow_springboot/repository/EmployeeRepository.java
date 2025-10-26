package opsNowSpringBoot.opsnow_springboot.repository;

import org.springframework.dao.EmptyResultDataAccessException;
import opsNowSpringBoot.opsnow_springboot.model.Employee;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.Timestamp;

import java.util.List;

@Repository
public class EmployeeRepository {
    private final JdbcTemplate jdbc;

    public EmployeeRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Employee> findAll() {
        String sql = "SELECT * FROM employee";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(Employee.class));
    }

    public Employee findById(int empno) {
        String sql = "SELECT * FROM employee WHERE empno = ?";
        try {
            return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(Employee.class), empno);
        } catch (EmptyResultDataAccessException e) {
            return null; // ✅ No data found, return null safely
        }
    }

    public int insert(Employee e) {
        String sql = "INSERT INTO employee (empno, empname, tiercode, locationcode, departmentcode, supervisorcode, salary, entrydate) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbc.update(sql,
                e.getEmpno(),
                e.getEmpname(),
                e.getTiercode(),
                e.getLocationcode(),
                e.getDepartmentcode(),
                e.getSupervisorcode(),
                e.getSalary(),
                Timestamp.valueOf(e.getEntrydate()));
    }

    public int update(Employee e) {
        String sql = "UPDATE employee SET empname=?, tiercode=?, locationcode=?, departmentcode=?, supervisorcode=?, salary=? WHERE empno=?";
        return jdbc.update(sql,
                e.getEmpname(),
                e.getTiercode(),
                e.getLocationcode(),
                e.getDepartmentcode(),
                e.getSupervisorcode(),
                e.getSalary(),
                e.getEmpno());
    }

    public int delete(int empno) {
        String sql = "DELETE FROM employee WHERE empno=?";
        return jdbc.update(sql, empno);
    }


}
