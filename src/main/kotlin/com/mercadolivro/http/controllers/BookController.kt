package com.mercadolivro.http.controllers

import com.mercadolivro.extensions.toBookModel
import com.mercadolivro.http.controllers.request.CreateBookRequest
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

}