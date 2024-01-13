package com.mercadolivro.repositories

import com.mercadolivro.models.Book
import com.mercadolivro.models.Customer
import com.mercadolivro.models.enums.BookStatus
import org.springframework.data.repository.CrudRepository

interface BookRepository: CrudRepository<Book, Int> {
    fun findByStatus(ativo: BookStatus): List<Book>
    fun findByCustomer(customer: Customer): List<Book>
}