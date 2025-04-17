package com.newbit.newbitfeatureservice.client.user;

import com.newbit.newbitfeatureservice.client.user.dto.UserDTO;
import com.newbit.newbitfeatureservice.common.config.feign.UserFeignClientConfig;
import com.newbit.newbitfeatureservice.common.dto.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "newbit-user-service", contextId = "userFeignClient", configuration = UserFeignClientConfig.class)
public interface UserFeignClient {

    @GetMapping("/user/{userId}")
    ApiResponse<UserDTO> getUserByUserId(@PathVariable("userId") Long userId);

    @GetMapping("/{userId}/email")
    ApiResponse<String> getEmailByUserId(@PathVariable("userId") Long userId);

    @GetMapping("/{userId}/nickname")
    ApiResponse<String> getNicknameByUserId(@PathVariable("userId") Long userId);
//
//    @PostMapping(value = "/internal/user/{userId}/diamond/use", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//    Integer useDiamond(@PathVariable("userId") Long userId, @RequestParam("amount") int amount);
//
//    @PostMapping(value = "/internal/user/{userId}/diamond/add", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//    Integer addDiamond(@PathVariable("userId") Long userId, @RequestParam("amount") int amount);
//
//    @PostMapping(value = "/internal/user/{userId}/point/use", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//    Integer usePoint(@PathVariable("userId") Long userId, @RequestParam("amount") int amount);
//
//    @PostMapping(value = "/internal/user/{userId}/point/add", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//    Integer addPoint(@PathVariable("userId") Long userId, @RequestParam("amount") int amount);
//
//    @GetMapping("/mentor/{mentorId}")
//    ApiResponse<MentorDTO> getMentorInfo(@PathVariable("mentorId") Long mentorId);
//
//    @PostMapping("/mentor/{userId}")
//    ApiResponse<Void> createMentor(@PathVariable("userId") Long userId);
//
//    @GetMapping("/mentor/{mentorId}/user-id")
//    ApiResponse<Long> getUserIdByMentorId(@PathVariable("mentorId") Long mentorId);
//
//    @GetMapping("/mentor/user/{userId}/mentor-id")
//    ApiResponse<Long> getMentorIdByUserId(@PathVariable("userId") Long userId);
//
//    @PostMapping("/send")
//    ApiResponse<Void> sendMail(
//            @RequestParam("to") String to,
//            @RequestParam("subject") String subject,
//            @RequestParam("content") String content
//    );
}