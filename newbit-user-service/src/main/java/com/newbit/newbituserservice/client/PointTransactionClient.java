package com.newbit.newbituserservice.client;

import com.newbit.newbituserservice.common.config.FeignClientConfig;
import com.newbit.newbituserservice.common.dto.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "newbit-feature-service", contextId = "PointTransactionClient", configuration = FeignClientConfig.class)
public interface PointTransactionClient {
    @PostMapping("/type")
    ApiResponse<Void> givePointByType(
            @PathVariable Long userId,
            @PathVariable String pointTypeName,
            @PathVariable(required = false) Long serviceId
    );
}
