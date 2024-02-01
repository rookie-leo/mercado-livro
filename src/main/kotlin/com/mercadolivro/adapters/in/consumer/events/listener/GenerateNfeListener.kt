package com.mercadolivro.adapters.`in`.consumer.events.listener

import com.mercadolivro.adapters.`in`.consumer.events.PurchaseEvent
import com.mercadolivro.adapters.out.service.PurchaseService
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.util.*

@Component
class GenerateNfeListener(
    private val purchaseService: PurchaseService
) {
    @Async
    @EventListener
    fun listener(purchaseEvent: PurchaseEvent) {
        val nfe = UUID.randomUUID().toString()
        val purchase = purchaseEvent.purchase.copy(nfe = nfe)
        purchaseService.update(purchase)
    }
}