package com.newbit.newbitfeatureservice.coffeechat.command.infrastructure.repository;


import com.newbit.newbitfeatureservice.coffeechat.command.domain.aggregate.Coffeechat;
import com.newbit.newbitfeatureservice.coffeechat.command.domain.repository.CoffeechatRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCoffeechatRepository extends CoffeechatRepository, JpaRepository<Coffeechat, Long> {
}
