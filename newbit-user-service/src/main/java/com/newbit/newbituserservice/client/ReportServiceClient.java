package com.newbit.newbituserservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "report-service", url = "${service.report.url}")
public interface ReportServiceClient {

    @GetMapping("/internal/reports/report-count/{userId}")
    int getTotalReportCountByUserId(@PathVariable("userId") Long userId);
}