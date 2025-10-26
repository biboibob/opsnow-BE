package opsNowSpringBoot.opsnow_springboot.config;

import opsNowSpringBoot.opsnow_springboot.interceptor.ApiCallInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private ApiCallInterceptor apiCallInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiCallInterceptor)
                .addPathPatterns("/**") // intercept all API calls
                .excludePathPatterns("/health", "/error"); // optional exclusions
    }
}
