package com.mercadolivro.adapters.out.service

import com.mercadolivro.application.core.exceptions.NotFoundException
import com.mercadolivro.adapters.out.repositories.entities.CustomerEntity
import com.mercadolivro.adapters.out.repositories.entities.enums.CustomerStatus
import com.mercadolivro.adapters.out.repositories.entities.enums.Errors
import com.mercadolivro.adapters.out.repositories.CustomerRepository
import org.springframework.stereotype.Service
import java.lang.Exception

//TODO - alterar nome da classe para CustomerAdapter
@Service
class CustomerService(
    val customerRepository: CustomerRepository,
    val bookService: BookService
) {

    fun getAllCustomer(name: String?): List<CustomerEntity> {
        name?.let {
            return customerRepository.findByNameContaining(it)
        }
        return customerRepository.findAll().toList()
    }

    fun getCustomerById(id: Int): CustomerEntity {
        return customerRepository.findById(id)
            .orElseThrow { NotFoundException(Errors.ME_2001.message.format(id), Errors.ME_2001.code) }
    }

    fun createCustomer(customer: CustomerEntity) {
        customerRepository.save(customer)
    }

    fun updateCustomer(customer: CustomerEntity) {
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

    fun emailAvalialable(email: String): Boolean {
        return !customerRepository.existsByEmail(email)
    }
}