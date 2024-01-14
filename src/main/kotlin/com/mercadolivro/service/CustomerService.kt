package com.mercadolivro.service

import com.mercadolivro.extensions.NotFoundException
import com.mercadolivro.models.Customer
import com.mercadolivro.models.enums.CustomerStatus
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
            .orElseThrow { NotFoundException("Customer com id: $id não encontrado", "0002") }
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