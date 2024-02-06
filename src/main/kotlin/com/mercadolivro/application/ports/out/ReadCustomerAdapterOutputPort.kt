package com.mercadolivro.application.ports.out

import com.mercadolivro.adapters.out.repositories.entities.CustomerEntity

interface ReadCustomerAdapterOutputPort {
    fun read(name: String?): List<CustomerEntity>
    fun readById(id: Int): CustomerEntity
}
