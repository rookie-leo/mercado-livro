package com.mercadolivro.adapters.`in`.consumer.events

import com.mercadolivro.adapters.out.repositories.entities.Purchase
import org.springframework.context.ApplicationEvent

class PurchaseEvent(
    source: Any,
    val purchase: Purchase
): ApplicationEvent(source)