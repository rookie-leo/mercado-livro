package com.mercadolivro.application.ports.out

import com.mercadolivro.application.core.domain.Customer

interface GetCustomerByIdAdapterOutputPort {
    fun getCustomerById(id: Int): Customer
}