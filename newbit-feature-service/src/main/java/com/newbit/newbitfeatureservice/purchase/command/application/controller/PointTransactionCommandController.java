package com.newbit.newbitfeatureservice.purchase.command.application.controller;


import com.newbit.newbitfeatureservice.common.dto.ApiResponse;
import com.newbit.newbitfeatureservice.common.jwt.model.CustomUser;
import com.newbit.newbitfeatureservice.purchase.command.application.dto.ColumnPurchaseRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/purchase")
@Tag(name = "구매관련 API", description = "포인트 지급 API")
public class PointTransactionCommandController {

    @PostMapping("/column")
    public ResponseEntity<ApiResponse<Void>> purchaseColumn(
            @AuthenticationPrincipal CustomUser customUser,
            @Valid @RequestBody ColumnPurchaseRequest request
    ) {
        purchaseCommandService.purchaseColumn(customUser.getUserId(), request);
        return ResponseEntity.ok(ApiResponse.success(null));
    }

    @PostMapping("/column")
    public ResponseEntity<ApiResponse<Void>> purchaseColumn()
}
