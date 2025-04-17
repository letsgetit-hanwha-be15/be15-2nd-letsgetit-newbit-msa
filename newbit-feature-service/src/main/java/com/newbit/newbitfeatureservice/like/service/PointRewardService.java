package com.newbit.newbitfeatureservice.like.service;

import com.newbit.newbitfeatureservice.purchase.command.domain.PointTypeConstants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newbit.newbitfeatureservice.common.exception.BusinessException;
import com.newbit.newbitfeatureservice.like.repository.LikeRepository;
import com.newbit.newbitfeatureservice.purchase.command.application.service.PointTransactionCommandService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PointRewardService {
    
    private final LikeRepository likeRepository;
    private final PointTransactionCommandService pointTransactionCommandService;

    @Transactional
    public void givePointIfFirstLike(Long postId, Long userId, Long authorId) {
        if (isFirstLike(postId, userId)) {
            givePointToAuthor(authorId, postId);
        }
    }
    
    private boolean isFirstLike(Long postId, Long userId) {
        return likeRepository.countByPostIdAndUserId(postId, userId) == 1;
    }
    
    private void givePointToAuthor(Long authorId, Long postId) {
        try {
            pointTransactionCommandService.givePointByType(authorId, PointTypeConstants.LIKES, postId);
        } catch (BusinessException e) {
            // 비즈니스 예외 처리
        } catch (Exception e) {
            // 예기치 않은 오류 처리
        }
    }
} 