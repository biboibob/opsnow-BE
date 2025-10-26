package opsNowSpringBoot.opsnow_springboot.repository;

import opsNowSpringBoot.opsnow_springboot.model.Tier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class TierRepository {

    private final JdbcTemplate jdbc;

    public TierRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Tier> findAll() {
        String sql = "SELECT * FROM tier";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(Tier.class));
    }


}
