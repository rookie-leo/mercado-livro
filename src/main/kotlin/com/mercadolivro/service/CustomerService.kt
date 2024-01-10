package com.mercadolivro.service

import com.mercadolivro.models.Customer
import org.springframework.stereotype.Service

@Service
class CustomerService {

    val customers = mutableListOf<Customer>()

    fun getAllCustomer(name: String?): List<Customer> {
        name?.let {
            return customers.filter { it.name.contains(name, true) }
        }
        return customers
    }

    fun getCustomer(id: String): Customer {
        return customers.filter { it.id == id }.first()
    }

    fun createCustomer(customer: Customer) {
        val id = if (customers.isEmpty()) {
            1
        } else {
            customers.last().id!!.toInt() + 1
        }.toString()

        customer.id = id

        customers.add(customer)
    }

    fun updateCustomer(customer: Customer) {
        customers.first { it.id == customer.id }.let {
            it.name = customer.name
            it.email = customer.email
        }
    }

    fun deleteCustomer(id: String) {
        customers.removeIf { it.id == id}
    }
}