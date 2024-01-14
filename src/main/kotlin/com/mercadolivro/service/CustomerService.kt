package com.mercadolivro.service

import com.mercadolivro.exceptions.NotFoundException
import com.mercadolivro.models.Customer
import com.mercadolivro.models.enums.CustomerStatus
import com.mercadolivro.models.enums.Errors
import com.mercadolivro.repositories.CustomerRepository
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class CustomerService(
    val customerRepository: CustomerRepository,
    val bookService: BookService
) {

    fun getAllCustomer(name: String?): List<Customer> {
        name?.let {
            return customerRepository.findByNameContaining(it)
        }
        return customerRepository.findAll().toList()
    }

    fun getCustomerById(id: Int): Customer {
        return customerRepository.findById(id)
            .orElseThrow { NotFoundException(Errors.ME_2001.message.format(id), Errors.ME_2001.code) }
    }

    fun createCustomer(customer: Customer) {
        customerRepository.save(customer)
    }

    fun updateCustomer(customer: Customer) {
        if (!customerRepository.existsById(customer.id!!)) {
            throw Exception()
        }

        customerRepository.save(customer)
    }

    fun deleteCustomer(id: Int) {
        val customer = getCustomerById(id)
        bookService.deleteBookByCustomer(customer)
        customer.status = CustomerStatus.INATIVO
        updateCustomer(customer)
    }
}