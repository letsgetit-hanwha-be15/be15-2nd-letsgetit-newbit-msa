package com.newbit.newbitfeatureservice.purchase.command.application.controller;

import com.newbit.newbitfeatureservice.common.dto.ApiResponse;
import com.newbit.newbitfeatureservice.purchase.command.application.service.PointTransactionCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/point")
public class PointTransactionCommandController {

    private final PointTransactionCommandService pointTransactionCommandService;

    @PostMapping("/type")
    public ResponseEntity<ApiResponse<Void>> givePointByType(
            @RequestParam Long userId,
            @RequestParam String pointTypeName,
            @RequestParam(required = false) Long serviceId
    ) {
        pointTransactionCommandService.givePointByType(userId, pointTypeName, serviceId);
        return ResponseEntity.ok(ApiResponse.success(null));
    }
}
