package com.mercadolivro.application.ports.out

import com.mercadolivro.application.core.domain.Customer

interface UpdateCustomerOutputPort {
    fun updateCustomer(customer: Customer)
}
