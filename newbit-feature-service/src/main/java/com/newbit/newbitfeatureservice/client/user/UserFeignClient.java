package com.newbit.newbitfeatureservice.client.user;

import com.newbit.newbitfeatureservice.client.user.dto.UserDTO;
import com.newbit.newbitfeatureservice.common.dto.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "newbit-user-service", url = "http://user-service:8081", path = "/api/v1/users")
public interface UserFeignClient {

    @GetMapping("/{userId}")
    ApiResponse<UserDTO> getUserByUserId(@PathVariable("userId") Long userId);
}