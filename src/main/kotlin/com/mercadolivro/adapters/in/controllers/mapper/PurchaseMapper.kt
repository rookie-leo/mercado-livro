package com.mercadolivro.adapters.`in`.controllers.mapper

import com.mercadolivro.adapters.`in`.controllers.request.CreatePurchaseRequest
import com.mercadolivro.adapters.out.repositories.entities.Purchase
import com.mercadolivro.adapters.out.service.BookService
import com.mercadolivro.adapters.out.service.CustomerService
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
            books = books.toMutableList(),
            purchaseTotalValue = books.sumOf { it.price }
        )
    }
}