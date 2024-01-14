package com.mercadolivro.repositories

import com.mercadolivro.models.Book
import com.mercadolivro.models.Customer
import com.mercadolivro.models.enums.BookStatus
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository: JpaRepository<Book, Int> {
    fun findByStatus(ativo: BookStatus, pageable: Pageable): Page<Book>
    fun findByCustomer(customer: Customer): List<Book>
}