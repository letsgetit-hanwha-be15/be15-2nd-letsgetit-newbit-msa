package com.newbit.newbitfeatureservice.client.user;

import com.newbit.newbitfeatureservice.client.user.dto.UserDTO;
import com.newbit.newbitfeatureservice.common.config.FeignClientConfig;
import com.newbit.newbitfeatureservice.common.dto.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "newbit-user-service", configuration = FeignClientConfig.class)
public interface UserFeignClient {

    @GetMapping("/user/{userId}")
    ApiResponse<UserDTO> getUserByUserId(@PathVariable("userId") Long userId);
}