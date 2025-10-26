package opsNowSpringBoot.opsnow_springboot.repository;

import opsNowSpringBoot.opsnow_springboot.model.ApiCallHistory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ApiCallHistoryRepository {
    private final JdbcTemplate jdbcTemplate;

    public ApiCallHistoryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(ApiCallHistory log) {
        String sql = "INSERT INTO api_call_history (timestamp, endpoint, http_method, user_identifier, response_status, duration_ms, ip_address) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                log.getTimestamp(),
                log.getEndpoint(),
                log.getHttpMethod(),
                log.getUserIdentifier(),
                log.getResponseStatus(),
                log.getDurationMs(),
                log.getIpAddress()
        );
    }
}
