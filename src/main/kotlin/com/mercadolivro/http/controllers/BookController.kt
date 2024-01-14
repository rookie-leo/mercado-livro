package com.mercadolivro.http.controllers

import com.mercadolivro.extensions.toBookModel
import com.mercadolivro.extensions.toBookResponse
import com.mercadolivro.http.controllers.request.CreateBookRequest
import com.mercadolivro.http.controllers.request.UpdateBookRequest
import com.mercadolivro.http.controllers.responses.BookResponse
import com.mercadolivro.models.Book
import com.mercadolivro.service.BookService
import com.mercadolivro.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("mercado-livro/book")
class BookController(
    val bookService: BookService,
    val customerService: CustomerService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createBook(@RequestBody bookRequest: CreateBookRequest) {
        val customer = customerService.getCustomerById(bookRequest.customerId)
        bookService.create(bookRequest.toBookModel(customer))
    }
    @GetMapping
    fun findAllBooks(): List<BookResponse> {
        return bookService.findAllBooks().map { it.toBookResponse() }
    }

    @GetMapping("/actives")
    @ResponseStatus(HttpStatus.OK)
    fun findAllBooksStatusActive(): List<BookResponse> =
        bookService.findAllBooksStatusActive().map { it.toBookResponse() }

    @GetMapping("/{id}")
    fun findBookById(@PathVariable id: Int): BookResponse =
        bookService.findBookById(id).toBookResponse()

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateBookById(@PathVariable id: Int, @RequestBody updateBookRequest: UpdateBookRequest) {
        val bookSaved = bookService.findBookById(id)
        bookService.updateBook(updateBookRequest.toBookModel(bookSaved))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBookById(@PathVariable id: Int) = bookService.deleteBookById(id)
}