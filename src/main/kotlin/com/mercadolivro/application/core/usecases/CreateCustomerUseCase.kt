package com.mercadolivro.application.core.usecases

import com.mercadolivro.adapters.out.service.InsertCustomerAdapter
import com.mercadolivro.application.core.domain.Customer
import com.mercadolivro.application.ports.`in`.CreateCustomerInputPort

class CreateCustomerUseCase(
    private val saveCustomerAdapter: InsertCustomerAdapter
) : CreateCustomerInputPort {
    override fun create(customer: Customer) {
        saveCustomerAdapter.saveCustomer(customer)
    }
}