package com.mercadolivro.application.ports.`in`

import com.mercadolivro.application.core.domain.Customer

interface CreateCustomerUseCaseInputPort {
    fun create(customer: Customer)
}