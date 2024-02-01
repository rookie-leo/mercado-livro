package com.mercadolivro.adapters.out.repositories

import com.mercadolivro.adapters.out.repositories.entities.Customer
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : CrudRepository<Customer, Int> {

    fun findByNameContaining(name: String): List<Customer>
    fun existsByEmail(email: String): Boolean

}