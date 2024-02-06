package com.mercadolivro.application.ports.`in`

import com.mercadolivro.application.core.domain.Customer

interface UpdateCustomerInputPort {
    fun update(customer: Customer)
}
