package com.mercadolivro.adapters.out.service

import com.mercadolivro.adapters.out.repositories.CustomerRepository
import com.mercadolivro.adapters.out.repositories.entities.enums.Errors
import com.mercadolivro.application.core.exceptions.NotFoundException
import com.mercadolivro.application.ports.out.DeleteCustomerOutputPort
import org.springframework.stereotype.Service

@Service
class DeleteCustomerAdapter(
    val customerRepository: CustomerRepository
) : DeleteCustomerOutputPort {
    override fun deleteById(id: Int) {
        val customer = customerRepository.findById(id)
            .orElseThrow{
                NotFoundException(Errors.ME_2001.message.format(id),
                    Errors.ME_2001.code)
            }
        customer.id?.let { customerRepository.deleteById(id) }
    }

}
