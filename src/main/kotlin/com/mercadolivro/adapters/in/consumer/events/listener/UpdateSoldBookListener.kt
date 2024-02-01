package com.mercadolivro.adapters.`in`.consumer.events.listener

import com.mercadolivro.adapters.`in`.consumer.events.PurchaseEvent
import com.mercadolivro.adapters.out.service.BookService
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component

@Component
class UpdateSoldBookListener(
    private val bookService: BookService
) {
    @Async
    @EventListener
    fun listener(purchaseEvent: PurchaseEvent) {
        bookService.purchase(purchaseEvent.purchase.books)
    }
}