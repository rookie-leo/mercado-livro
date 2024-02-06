package com.mercadolivro.adapters.out.service

import com.mercadolivro.adapters.out.repositories.CustomerRepository
import com.mercadolivro.adapters.out.repositories.entities.CustomerEntity
import com.mercadolivro.adapters.out.repositories.entities.enums.Errors
import com.mercadolivro.application.core.domain.Customer
import com.mercadolivro.application.core.exceptions.NotFoundException
import com.mercadolivro.application.core.usecases.extensions.toCustomer
import com.mercadolivro.application.ports.out.ReadCustomerAdapterOutputPort
import org.springframework.stereotype.Service

@Service
class ReadCustomerAdapter(
    val customerRepository: CustomerRepository
) : ReadCustomerAdapterOutputPort {
    override fun read(): MutableList<CustomerEntity> {
        return customerRepository.findAll().toMutableList()
    }

    override fun readById(id: Int): CustomerEntity {
        return customerRepository.findById(id)
            .orElseThrow{ NotFoundException(Errors.ME_2001.message.format(id), Errors.ME_2001.code) }
    }

}
