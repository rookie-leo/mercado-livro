package com.mercadolivro.application.ports.out

import com.mercadolivro.application.core.domain.Customer

interface SaveCustomerAdapterOutputPort {
    fun saveCustomer(customer: Customer)
}