package com.mercadolivro.adapters.out.service

import com.mercadolivro.adapters.out.repositories.CustomerRepository
import com.mercadolivro.adapters.out.repositories.entities.enums.CustomerStatus
import com.mercadolivro.adapters.out.repositories.entities.enums.Errors
import com.mercadolivro.application.core.exceptions.NotFoundException
import com.mercadolivro.application.ports.out.DeleteCustomerOutputPort
import org.springframework.stereotype.Service

@Service
class DeleteCustomerAdapter(
    private val customerRepository: CustomerRepository,
    private val bookService: BookService
) : DeleteCustomerOutputPort {
    override fun deleteById(id: Int) {
        val customer = customerRepository.findById(id)
            .orElseThrow{
                NotFoundException(Errors.ME_2001.message.format(id),
                    Errors.ME_2001.code)
            }
        bookService.deleteBookByCustomer(customer)
        customer.status = CustomerStatus.INATIVO
        customerRepository.save(customer)
    }

}
