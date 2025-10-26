package opsNowSpringBoot.opsnow_springboot.repository;

import opsNowSpringBoot.opsnow_springboot.model.Tier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class TierRepository {

    private final JdbcTemplate jdbc;

    public TierRepository(JdbcTemplate jdbcTemplate) {
        this.jdbc = jdbcTemplate;
    }

    public List<Tier> findAll() {
        return jdbc.query("SELECT * FROM tier", new BeanPropertyRowMapper<>(Tier.class));
    }

    public Tier findById(int id) {
        return jdbc.queryForObject("SELECT * FROM tier WHERE tiercode = ?", new BeanPropertyRowMapper<>(Tier.class), id);
    }

    public int save(Tier tier) {
        return jdbc.update("INSERT INTO tier (tiercode, tiername) VALUES (?, ?)", tier.getTiercode(), tier.getTiername());
    }

    public int update(Tier tier) {
        return jdbc.update("UPDATE tier SET tiername = ? WHERE tiercode = ?", tier.getTiername(), tier.getTiercode());
    }

    public int delete(int id) {
        return jdbc.update("DELETE FROM tier WHERE tiercode = ?", id);
    }


}
