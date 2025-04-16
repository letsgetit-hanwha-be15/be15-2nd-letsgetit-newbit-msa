package com.newbit.newbituserservice.user.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class PointTransactionClient {

    @GetMapping("/api/v1/main/{mentorId}/user-id")
    Long getUserIdByMentorId(@PathVariable("mentorId") Long mentorId);

}
