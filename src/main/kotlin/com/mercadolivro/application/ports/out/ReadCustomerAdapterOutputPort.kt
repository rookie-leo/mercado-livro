package com.mercadolivro.application.ports.out

import com.mercadolivro.adapters.out.repositories.entities.CustomerEntity
import com.mercadolivro.application.core.domain.Customer

interface ReadCustomerAdapterOutputPort {
    fun read(): List<CustomerEntity>
    fun readById(id: Int): CustomerEntity
}
