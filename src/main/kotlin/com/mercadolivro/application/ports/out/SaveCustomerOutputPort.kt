package com.mercadolivro.application.ports.out

import com.mercadolivro.application.core.domain.Customer

interface SaveCustomerOutputPort {
    fun saveCustomer(customer: Customer)
}