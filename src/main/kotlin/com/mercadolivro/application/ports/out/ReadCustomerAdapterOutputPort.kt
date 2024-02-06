package com.mercadolivro.application.ports.out

import com.mercadolivro.application.core.domain.Customer

interface ReadCustomerAdapterOutputPort {
    fun read(): List<Customer>
}
