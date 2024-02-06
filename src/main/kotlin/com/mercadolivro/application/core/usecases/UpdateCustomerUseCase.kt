package com.mercadolivro.application.core.usecases

import com.mercadolivro.adapters.`in`.controllers.request.UpdateCustomerRequest
import com.mercadolivro.adapters.out.service.UpdateCustomerAdapter
import com.mercadolivro.application.core.domain.Customer
import com.mercadolivro.application.ports.`in`.UpdateCustomerInputPort

class UpdateCustomerUseCase(
    private val updateCustomerAdapter: UpdateCustomerAdapter
) : UpdateCustomerInputPort {
    override fun update(customer: Customer) {
        updateCustomerAdapter.updateCustomer(customer)
    }

}
