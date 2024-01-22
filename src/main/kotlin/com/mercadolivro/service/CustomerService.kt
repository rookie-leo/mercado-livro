package com.mercadolivro.service

import com.mercadolivro.exceptions.NotFoundException
import com.mercadolivro.models.Customer
import com.mercadolivro.models.enums.CustomerStatus
import com.mercadolivro.models.enums.Errors
import com.mercadolivro.models.enums.Profile
import com.mercadolivro.repositories.CustomerRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class CustomerService(
    private val bookService: BookService,
    private val customerRepository: CustomerRepository,
    private val bCrypt: BCryptPasswordEncoder
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
        val customerCopy = customer.copy(
            roles = setOf(Profile.CUSTOMER),
            password = bCrypt.encode(customer.password)
        )
        customerRepository.save(customerCopy)
    }

    fun updateCustomer(customer: Customer) {
        if (!customerRepository.existsById(customer.id!!)) {
            throw Exception()
        }
        val customerCopy = customer.copy(
            roles = setOf(Profile.CUSTOMER)
        )

        customerRepository.save(customerCopy)
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