package com.mercadolivro.service

import com.mercadolivro.models.Book
import com.mercadolivro.models.Customer
import com.mercadolivro.models.enums.BookStatus
import com.mercadolivro.repositories.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookRepository: BookRepository
) {

    fun create(book: Book) {
        bookRepository.save(book)
    }

    fun findAllBooks(): List<Book> {
        return bookRepository.findAll().toList()
    }

    fun findAllBooksStatusActive(): List<Book> {
        return bookRepository.findByStatus(BookStatus.ATIVO);
    }

    fun findBookById(id: Int): Book {
        return bookRepository.findById(id).orElseThrow()
    }

    fun updateBook(book: Book) {
        bookRepository.save(book)
    }

    fun deleteBookById(id: Int): Unit {
        val book = findBookById(id)

        book.status = BookStatus.CANCELADO

        updateBook(book)
    }

    fun deleteBookByCustomer(customer: Customer) {
        val books = bookRepository.findByCustomer(customer)
        for (book in books) {
            book.status = BookStatus.DELETADO
        }

        bookRepository.saveAll(books)
    }
}
