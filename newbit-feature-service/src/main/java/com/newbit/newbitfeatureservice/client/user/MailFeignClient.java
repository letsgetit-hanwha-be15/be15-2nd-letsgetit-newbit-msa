package com.newbit.newbitfeatureservice.client.user;

import com.newbit.newbitfeatureservice.common.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "newbit-user-service", configuration = FeignClientConfig.class)
public interface MailFeignClient {

}
