package opsNowSpringBoot.opsnow_springboot.util;

import opsNowSpringBoot.opsnow_springboot.dto.APIResponse;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {
    public static <T> ResponseEntity<APIResponse<T>> success(T data) {
        return ResponseEntity.ok(new APIResponse<>(true, "Success", data));
    }

    public static ResponseEntity<APIResponse<String>> success() {
        return ResponseEntity.ok(new APIResponse<>(true, "Success", null));
    }

    public static ResponseEntity<APIResponse<String>> error(String message) {
        return ResponseEntity.badRequest().body(new APIResponse<>(false, message, null));
    }
}