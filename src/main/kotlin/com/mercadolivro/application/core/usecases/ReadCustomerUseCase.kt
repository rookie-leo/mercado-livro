package com.mercadolivro.application.core.usecases

import com.mercadolivro.adapters.out.service.ReadCustomerAdapter
import com.mercadolivro.application.core.domain.Customer
import com.mercadolivro.application.ports.`in`.ReadCustomerInputPort

class ReadCustomerUseCase(
    private val readCustomerAdapter: ReadCustomerAdapter
) : ReadCustomerInputPort {
    override fun read(): List<Customer> {
        return readCustomerAdapter.read()
    }

}
