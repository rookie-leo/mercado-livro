package com.mercadolivro.application.ports.`in`

import com.mercadolivro.application.core.domain.Customer

interface ReadCustomerInputPort {
    fun read(): List<Customer>
    fun getCustomerById(id: Int): Customer
}
