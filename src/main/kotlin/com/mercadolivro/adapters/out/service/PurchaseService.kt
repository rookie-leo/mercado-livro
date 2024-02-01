package com.mercadolivro.adapters.out.service

import com.mercadolivro.adapters.`in`.consumer.events.PurchaseEvent
import com.mercadolivro.adapters.out.repositories.entities.Purchase
import com.mercadolivro.adapters.out.repositories.PurchaseRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

//TODO - alterar nome da classe para PurchaseAapter
@Service
class PurchaseService(
    private val purchaseRepository: PurchaseRepository,
    private val applicationEventPublisher: ApplicationEventPublisher
) {
    @Transactional
    fun create(purchase: Purchase) {
        purchaseRepository.save(purchase)
        applicationEventPublisher.publishEvent(PurchaseEvent(this, purchase))
    }

    fun update(purchase: Purchase) {
        purchaseRepository.save(purchase)
    }
}
