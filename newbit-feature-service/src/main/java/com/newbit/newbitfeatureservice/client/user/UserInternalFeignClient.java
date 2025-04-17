package com.newbit.newbitfeatureservice.client.user;

import com.newbit.newbitfeatureservice.common.config.feign.UserFeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

@FeignClient(name = "newbit-user-service", contextId = "userInternalFeignClient", configuration = UserFeignClientConfig.class)
public interface UserInternalFeignClient {

    @PostMapping(value = "/internal/user/{userId}/diamond/use", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    Integer useDiamond(@PathVariable("userId") Long userId, @RequestParam("amount") int amount);

    @PostMapping(value = "/internal/user/{userId}/diamond/add", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    Integer addDiamond(@PathVariable("userId") Long userId, @RequestParam("amount") int amount);

    @PostMapping(value = "/internal/user/{userId}/point/use", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    Integer usePoint(@PathVariable("userId") Long userId, @RequestParam("amount") int amount);

    @PostMapping(value = "/internal/user/{userId}/point/add", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    Integer addPoint(@PathVariable("userId") Long userId, @RequestParam("amount") int amount);
}