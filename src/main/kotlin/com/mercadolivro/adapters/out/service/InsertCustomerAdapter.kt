package com.mercadolivro.adapters.out.service

import com.mercadolivro.adapters.out.repositories.CustomerRepository
import com.mercadolivro.application.core.domain.Customer
import com.mercadolivro.application.core.usecases.extensions.toCustomerEntity
import com.mercadolivro.application.ports.out.SaveCustomerOutputPort
import org.springframework.stereotype.Service

@Service
class InsertCustomerAdapter(
    private val customerRepository: CustomerRepository
) : SaveCustomerOutputPort{
    override fun saveCustomer(customer: Customer) {
        customerRepository.save(customer.toCustomerEntity())
    }


}