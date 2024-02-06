package com.mercadolivro.adapters.out.service

import com.mercadolivro.adapters.out.repositories.CustomerRepository
import com.mercadolivro.application.core.domain.Customer
import com.mercadolivro.application.core.usecases.extensions.toCustomer
import com.mercadolivro.application.ports.out.ReadCustomerAdapterOutputPort
import org.springframework.stereotype.Service

@Service
class ReadCustomerAdapter(
    val customerRepository: CustomerRepository
) : ReadCustomerAdapterOutputPort {
    override fun read(): MutableList<Customer> {
        return customerRepository.findAll()
            .map { it.toCustomer() }.toMutableList()
    }

}
