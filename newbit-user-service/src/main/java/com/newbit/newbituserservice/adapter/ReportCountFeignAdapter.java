package com.newbit.newbituserservice.adapter;

import com.newbit.newbituserservice.client.ReportServiceClient;
import com.newbit.newbituserservice.port.ReportCountPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReportCountFeignAdapter implements ReportCountPort {

    private final ReportServiceClient reportServiceClient;

    @Override
    public int getTotalReportCountByUserId(Long userId) {
        return reportServiceClient.getTotalReportCountByUserId(userId);
    }
}
