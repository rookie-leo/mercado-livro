package com.mercadolivro.service

import com.mercadolivro.models.Book
import com.mercadolivro.repositories.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookRepository: BookRepository
) {

    fun create(book: Book) {
        bookRepository.save(book)
    }

}
