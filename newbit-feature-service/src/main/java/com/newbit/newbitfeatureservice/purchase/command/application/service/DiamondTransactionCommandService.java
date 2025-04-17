package com.newbit.newbitfeatureservice.purchase.command.application.service;

import com.newbit.newbitfeatureservice.purchase.command.domain.aggregate.DiamondHistory;
import com.newbit.newbitfeatureservice.purchase.command.domain.aggregate.DiamondTransactionType;
import com.newbit.newbitfeatureservice.purchase.command.domain.repository.DiamondHistoryRepository;
import com.newbit.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DiamondTransactionCommandService {

    private final DiamondHistoryRepository diamondHistoryRepository;
    private final UserService userService;

    public void saveDiamondHistory(
            Long userId,
            DiamondTransactionType type,
            Integer increaseAmount,
            Integer decreaseAmount,
            Long serviceId,
            Integer balance
    ) {
        DiamondHistory history = DiamondHistory.builder()
                .userId(userId)
                .serviceType(type)
                .serviceId(serviceId)
                .increaseAmount(increaseAmount)
                .decreaseAmount(decreaseAmount)
                .balance(balance)
                .build();
        diamondHistoryRepository.save(history);
    }


    @Transactional
    public void applyDiamondPayment(Long userId, Long paymentId, Integer amount) {
        Integer balance = userService.addDiamond(userId, amount);
        saveDiamondHistory(userId, DiamondTransactionType.CHARGE, amount, null, paymentId, balance);
    }

    @Transactional
    public void applyDiamondRefund(Long userId, Long refundId, Integer amount) {
        Integer balance = userService.useDiamond(userId, amount);
        saveDiamondHistory(userId, DiamondTransactionType.REFUND, null, amount, refundId, balance);
    }

}
