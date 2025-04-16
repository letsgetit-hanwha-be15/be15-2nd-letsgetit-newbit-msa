package com.newbit.newbitfeatureservice.client.user;

import com.newbit.newbitfeatureservice.client.user.dto.MentorDTO;
import com.newbit.newbitfeatureservice.common.dto.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "user-service", url = "http://user-service:8081", path = "/api/v1/mentors")
public interface MentorFeignClient {

    @GetMapping("/{mentorId}")
    ApiResponse<MentorDTO> getMentorInfo(@PathVariable("mentorId") Long mentorId);

    @PostMapping("/{userId}")
    ApiResponse<Void> createMentor(@PathVariable("userId") Long userId);

    @GetMapping("/{mentorId}/user-id")
    ApiResponse<Long> getUserIdByMentorId(@PathVariable("mentorId") Long mentorId);
}