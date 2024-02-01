package com.mercadolivro.adapters.`in`.controllers

import com.mercadolivro.application.core.usecases.extensions.toBookModel
import com.mercadolivro.application.core.usecases.extensions.toBookResponse
import com.mercadolivro.adapters.`in`.controllers.request.CreateBookRequest
import com.mercadolivro.adapters.`in`.controllers.request.UpdateBookRequest
import com.mercadolivro.adapters.`in`.controllers.responses.BookResponse
import com.mercadolivro.adapters.out.service.BookService
import com.mercadolivro.adapters.out.service.CustomerService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
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
    fun findAllBooks(@PageableDefault(page = 0, size = 5) pageable: Pageable): Page<BookResponse> {
        return bookService.findAllBooks(pageable).map { it.toBookResponse() }
    }

    @GetMapping("/actives")
    @ResponseStatus(HttpStatus.OK)
    fun findAllBooksStatusActive(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<BookResponse> =
        bookService.findAllBooksStatusActive(pageable).map { it.toBookResponse() }

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