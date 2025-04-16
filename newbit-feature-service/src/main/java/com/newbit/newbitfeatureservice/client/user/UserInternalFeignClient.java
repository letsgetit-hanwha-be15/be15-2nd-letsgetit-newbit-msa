package com.newbit.newbitfeatureservice.client.user;

import com.newbit.newbitfeatureservice.common.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

@FeignClient(name = "newbit-user-service", configuration = FeignClientConfig.class, path = "/api/v1/internal/user")
public interface UserInternalFeignClient {

    @PostMapping(value = "/{userId}/diamond/use", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    Integer useDiamond(@PathVariable("userId") Long userId, @RequestParam("amount") int amount);

    @PostMapping(value = "/{userId}/diamond/add", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    Integer addDiamond(@PathVariable("userId") Long userId, @RequestParam("amount") int amount);

    @PostMapping(value = "/{userId}/point/use", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    Integer usePoint(@PathVariable("userId") Long userId, @RequestParam("amount") int amount);

    @PostMapping(value = "/{userId}/point/add", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    Integer addPoint(@PathVariable("userId") Long userId, @RequestParam("amount") int amount);
}