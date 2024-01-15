package com.mercadolivro.events

import com.mercadolivro.models.Purchase
import org.springframework.context.ApplicationEvent

class PurchaseEvent(
    source: Any,
    val purchase: Purchase
): ApplicationEvent(source)