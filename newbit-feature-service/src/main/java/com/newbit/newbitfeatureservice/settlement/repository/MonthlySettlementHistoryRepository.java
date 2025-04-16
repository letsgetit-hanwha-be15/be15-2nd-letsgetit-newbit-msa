package com.newbit.newbitfeatureservice.settlement.repository;

import com.newbit.settlement.entity.MonthlySettlementHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonthlySettlementHistoryRepository extends JpaRepository<MonthlySettlementHistory, Long> {
    Page<MonthlySettlementHistory> findAllByMentor_MentorId(Long mentorId, Pageable pageable);
}
