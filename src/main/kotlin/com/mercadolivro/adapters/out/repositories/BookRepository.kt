package com.mercadolivro.adapters.out.repositories

import com.mercadolivro.adapters.out.repositories.entities.Book
import com.mercadolivro.adapters.out.repositories.entities.Customer
import com.mercadolivro.adapters.out.repositories.entities.enums.BookStatus
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository: JpaRepository<Book, Int> {
    fun findByStatus(ativo: BookStatus, pageable: Pageable): Page<Book>
    fun findByCustomer(customer: Customer): List<Book>
}