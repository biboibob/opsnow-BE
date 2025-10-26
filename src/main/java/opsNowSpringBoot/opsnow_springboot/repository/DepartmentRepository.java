package opsNowSpringBoot.opsnow_springboot.repository;

import opsNowSpringBoot.opsnow_springboot.model.Department;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class DepartmentRepository {

    private final JdbcTemplate jdbc;

    public DepartmentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbc = jdbcTemplate;
    }

    public List<Department> findAll() {
        return jdbc.query("SELECT * FROM department", new BeanPropertyRowMapper<>(Department.class));
    }

    public Department findById(String id) {
        return jdbc.queryForObject("SELECT * FROM department WHERE departmentcode = ?", new BeanPropertyRowMapper<>(Department.class), id);
    }

    public int save(Department dept) {
        return jdbc.update("INSERT INTO department (departmentcode, departmentname) VALUES (?, ?)", dept.getDepartmentcode(), dept.getDepartmentname());
    }

    public int update(Department dept) {
        return jdbc.update("UPDATE department SET departmentname = ? WHERE departmentcode = ?", dept.getDepartmentname(), dept.getDepartmentcode());
    }

    public int delete(String id) {
        return jdbc.update("DELETE FROM department WHERE departmentcode = ?", id);
    }
}
