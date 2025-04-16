package com.newbit.newbitfeatureservice.purchase.query.service;

import com.newbit.common.dto.Pagination;
import com.newbit.purchase.command.domain.repository.ColumnPurchaseHistoryRepository;
import com.newbit.purchase.query.dto.request.HistoryRequest;
import com.newbit.purchase.query.dto.response.ColumnPurchaseHistoryDto;
import com.newbit.purchase.query.dto.response.ColumnPurchaseHistoryListResponse;
import com.newbit.purchase.query.repository.ColumnPurchaseHistoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ColumnPurchaseHistoryQueryService {

    private final ColumnPurchaseHistoryMapper columnPurchaseHistoryMapper;
    private final ColumnPurchaseHistoryRepository columnPurchaseHistoryRepository;

    @Transactional(readOnly = true)
    public ColumnPurchaseHistoryListResponse getColumnPurchaseHistories(HistoryRequest request)
    {
        List<ColumnPurchaseHistoryDto> purchases = columnPurchaseHistoryMapper.findColumnPurchases(request);
        long totalItems = columnPurchaseHistoryMapper.countColumnPurchases(request);

        return ColumnPurchaseHistoryListResponse.builder()
                .columnPurchases(purchases)
                .pagination(Pagination.builder()
                        .currentPage(request.getPage())
                        .totalPage((int) Math.ceil((double) totalItems / request.getSize()))
                        .totalItems(totalItems)
                        .build()
                ).build();
    }

    public boolean hasUserPurchasedColumn(Long userId, Long columnId) {
        return columnPurchaseHistoryRepository.existsByUserIdAndColumnId(userId, columnId);
    }


}