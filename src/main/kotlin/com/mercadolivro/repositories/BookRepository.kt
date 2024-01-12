package com.mercadolivro.repositories

import com.mercadolivro.models.Book
import org.springframework.data.repository.CrudRepository

interface BookRepository: CrudRepository<Book, Int> {
}