package com.mercadolivro.http.controllers.mapper

import com.mercadolivro.http.controllers.request.CreatePurchaseRequest
import com.mercadolivro.models.Purchase
import com.mercadolivro.service.BookService
import com.mercadolivro.service.CustomerService
import org.springframework.stereotype.Component

@Component
class PurchaseMapper(
    val bookService: BookService,
    val customerService: CustomerService
) {
    fun toModel(request: CreatePurchaseRequest): Purchase {
        val customer = customerService.getCustomerById(request.customerId)
        val books = bookService.findAllByIds(request.booksId)
        return Purchase(
            customer = customer,
            books = books,
            purchaseTotalValue = books.sumOf { it.price }
        )
    }
}