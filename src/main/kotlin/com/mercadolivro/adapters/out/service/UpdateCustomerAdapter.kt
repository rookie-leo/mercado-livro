package com.mercadolivro.adapters.out.service

import com.mercadolivro.adapters.out.repositories.CustomerRepository
import com.mercadolivro.application.core.domain.Customer
import com.mercadolivro.application.core.usecases.extensions.toCustomerEntity
import com.mercadolivro.application.ports.out.UpdateCustomerOutputPort
import org.springframework.stereotype.Service

@Service
class UpdateCustomerAdapter(
    val customerRepository: CustomerRepository
) : UpdateCustomerOutputPort {
    override fun updateCustomer(customer: Customer) {
        customerRepository.save(customer.toCustomerEntity())
    }
}
