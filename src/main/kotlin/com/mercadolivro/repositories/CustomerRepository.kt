package com.mercadolivro.repositories

import com.mercadolivro.models.Customer
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : CrudRepository<Customer, Int> {

    fun findByNameContaining(name: String): List<Customer>
    fun existsByEmail(email: String): Boolean

}