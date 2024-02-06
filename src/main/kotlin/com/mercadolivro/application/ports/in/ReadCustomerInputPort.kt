package com.mercadolivro.application.ports.`in`

import com.mercadolivro.application.core.domain.Customer

interface ReadCustomerInputPort {
    fun read(name: String?): List<Customer>
    fun getCustomerById(id: Int): Customer
}
