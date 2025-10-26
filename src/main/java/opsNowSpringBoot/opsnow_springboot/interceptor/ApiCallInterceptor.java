package opsNowSpringBoot.opsnow_springboot.interceptor;

import opsNowSpringBoot.opsnow_springboot.model.ApiCallHistory;
import opsNowSpringBoot.opsnow_springboot.repository.ApiCallHistoryRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDateTime;

@Component
public class ApiCallInterceptor implements HandlerInterceptor {

    private final ApiCallHistoryRepository historyRepo;

    public ApiCallInterceptor(ApiCallHistoryRepository historyRepo) {
        this.historyRepo = historyRepo;
    }

    private static final ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        startTime.set(System.currentTimeMillis());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        long duration = System.currentTimeMillis() - startTime.get();

        ApiCallHistory log = new ApiCallHistory();
        log.setTimestamp(LocalDateTime.now());
        log.setEndpoint(request.getRequestURI());
        log.setHttpMethod(request.getMethod());
        log.setResponseStatus(response.getStatus());
        log.setUserIdentifier(request.getRemoteUser() != null ? request.getRemoteUser() : "anonymous");
        log.setDurationMs(duration);
        log.setIpAddress(request.getRemoteAddr());

        new Thread(() -> historyRepo.save(log)).start();
    }
}
