package com.mercadolivro.application.ports.`in`

import com.mercadolivro.application.core.domain.Customer

interface CreateCustomerInputPort {
    fun create(customer: Customer)
}