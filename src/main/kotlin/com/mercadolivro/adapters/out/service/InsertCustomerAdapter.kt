package com.mercadolivro.adapters.out.service

import com.mercadolivro.adapters.out.repositories.CustomerRepository
import com.mercadolivro.application.core.domain.Customer
import com.mercadolivro.application.core.usecases.extensions.toCustomerEntity
import com.mercadolivro.application.ports.out.SaveCustomerAdapterOutputPort
import org.springframework.stereotype.Service

@Service
class InsertCustomerAdapter(
    val customerRepository: CustomerRepository
) : SaveCustomerAdapterOutputPort{
    override fun saveCustomer(customer: Customer) {
        customerRepository.save(customer.toCustomerEntity())
    }


}