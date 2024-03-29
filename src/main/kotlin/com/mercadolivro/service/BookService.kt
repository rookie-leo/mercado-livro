package com.mercadolivro.service

import com.mercadolivro.exceptions.BadRequestException
import com.mercadolivro.exceptions.NotFoundException
import com.mercadolivro.models.Book
import com.mercadolivro.models.Customer
import com.mercadolivro.models.enums.BookStatus
import com.mercadolivro.models.enums.Errors
import com.mercadolivro.repositories.BookRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookRepository: BookRepository
) {

    fun create(book: Book) {
        bookRepository.save(book)
    }

    fun findAllBooks(pageable: Pageable): Page<Book> {
        return bookRepository.findAll(pageable)
    }

    fun findAllBooksStatusActive(pageable: Pageable): Page<Book> {
        return bookRepository.findByStatus(BookStatus.ATIVO, pageable);
    }

    fun findBookById(id: Int): Book {
        return bookRepository.findById(id)
            .orElseThrow{ NotFoundException(Errors.ME_1001.message.format(id), Errors.ME_1001.code) }
    }

    fun updateBook(book: Book) {
        validStatusBook(book.status!!)
        bookRepository.save(book)
    }

    fun validStatusBook(statusBook: BookStatus) {
        if (statusBook == BookStatus.DELETADO) throw BadRequestException(Errors.ME_1002.message, Errors.ME_1002.code)
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

    fun findAllByIds(booksId: Set<Int>): List<Book> {
        return bookRepository.findAllById(booksId)
    }

    fun purchase(books: MutableList<Book>) {
        books.map {
            it.status = BookStatus.VENDIDO
        }
        bookRepository.saveAll(books)
    }
}
