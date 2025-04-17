package com.newbit.newbituserservice.user.service;


import com.newbit.newbituserservice.port.ReportCountPort;
import com.newbit.newbituserservice.user.entity.User;
import com.newbit.newbituserservice.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SuspensionService {
    private final UserRepository userRepository;
    private final ReportCountPort reportCountPort;

    public void checkAndSuspendUser(Long userId) {
        int totalReports = reportCountPort.getTotalReportCountByUserId(userId);

        if (totalReports >= 50 && totalReports % 50 == 0) {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다."));
            if (!user.getIsSuspended()) {
                user.setIsSuspended(true);
                user.setUpdatedAt(LocalDateTime.now());
                userRepository.save(user);
            }
        }
    }
}
