package com.newbit.newbitfeatureservice.column.repository;

import com.newbit.column.domain.Series;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeriesRepository extends JpaRepository<Series, Long> {
    List<Series> findAllByMentor_MentorIdOrderByCreatedAtDesc(Long mentorId);
}
