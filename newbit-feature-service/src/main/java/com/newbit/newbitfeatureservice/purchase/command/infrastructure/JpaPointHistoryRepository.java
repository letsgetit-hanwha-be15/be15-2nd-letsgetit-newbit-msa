package com.newbit.newbitfeatureservice.purchase.command.infrastructure;

import com.newbit.purchase.command.domain.aggregate.PointHistory;
import com.newbit.purchase.command.domain.repository.PointHistoryRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPointHistoryRepository extends PointHistoryRepository, JpaRepository<PointHistory, Long> {
}
