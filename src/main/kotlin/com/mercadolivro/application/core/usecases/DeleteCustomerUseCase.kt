package com.mercadolivro.application.core.usecases

import com.mercadolivro.adapters.out.service.DeleteCustomerAdapter
import com.mercadolivro.application.ports.`in`.DeleteCustomerInputPort

class DeleteCustomerUseCase(
    private val deleteCustomerAdapter: DeleteCustomerAdapter
) : DeleteCustomerInputPort {
    override fun deleteById(id: Int) {
        deleteCustomerAdapter.deleteById(id)
    }
}
