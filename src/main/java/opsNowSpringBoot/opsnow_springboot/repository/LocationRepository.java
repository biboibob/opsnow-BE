package opsNowSpringBoot.opsnow_springboot.repository;

import opsNowSpringBoot.opsnow_springboot.model.Location;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class LocationRepository {

    private final JdbcTemplate jdbc;

    public LocationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbc = jdbcTemplate;
    }

    public List<Location> findAll() {
        return jdbc.query("SELECT * FROM location", new BeanPropertyRowMapper<>(Location.class));
    }

    public Location findById(String id) {
        return jdbc.queryForObject("SELECT * FROM location WHERE locationcode = ?", new BeanPropertyRowMapper<>(Location.class), id);
    }

    public int save(Location loc) {
        return jdbc.update("INSERT INTO location (locationcode, locationname) VALUES (?, ?)", loc.getLocationcode(), loc.getLocationname());
    }

    public int update(Location loc) {
        return jdbc.update("UPDATE location SET locationname = ? WHERE locationcode = ?", loc.getLocationname(), loc.getLocationcode());
    }

    public int delete(String id) {
        return jdbc.update("DELETE FROM location WHERE locationcode = ?", id);
    }
}
