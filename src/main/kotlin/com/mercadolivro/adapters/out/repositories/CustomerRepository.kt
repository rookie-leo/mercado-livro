package com.mercadolivro.adapters.out.repositories

import com.mercadolivro.adapters.out.repositories.entities.CustomerEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : CrudRepository<CustomerEntity, Int> {

    fun findByNameContaining(name: String): List<CustomerEntity>
    fun existsByEmail(email: String): Boolean

}