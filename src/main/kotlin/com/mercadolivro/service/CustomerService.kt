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

    fun getCustomer(id: Int): Customer {
        return customers.filter { it.id == id }.first()
    }

    fun createCustomer(customer: Customer) {
        val id = if (customers.isEmpty()) {
            1
        } else {
            customers.last().id!! + 1
        }

        customer.id = id

        customers.add(customer)
    }

    fun updateCustomer(customer: Customer) {
        customers.first { it.id == customer.id }.let {
            it.name = customer.name
            it.email = customer.email
        }
    }

    fun deleteCustomer(id: Int) {
        customers.removeIf { it.id == id}
    }
}