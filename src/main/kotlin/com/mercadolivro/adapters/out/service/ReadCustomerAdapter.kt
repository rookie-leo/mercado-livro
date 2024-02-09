package com.mercadolivro.adapters.out.service

import com.mercadolivro.adapters.out.repositories.CustomerRepository
import com.mercadolivro.adapters.out.repositories.entities.CustomerEntity
import com.mercadolivro.adapters.out.repositories.entities.enums.Errors
import com.mercadolivro.application.core.exceptions.NotFoundException
import com.mercadolivro.application.ports.out.ReadCustomerOutputPort
import org.springframework.stereotype.Service

@Service
class ReadCustomerAdapter(
    private val customerRepository: CustomerRepository
) : ReadCustomerOutputPort {
    override fun read(name: String?): MutableList<CustomerEntity> {
        if (name != null) return customerRepository.findByNameContaining(name).toMutableList()
        return customerRepository.findAll().toMutableList()
    }

    override fun readById(id: Int): CustomerEntity {
        return customerRepository.findById(id)
            .orElseThrow{ NotFoundException(Errors.ME_2001.message.format(id), Errors.ME_2001.code) }
    }

}
