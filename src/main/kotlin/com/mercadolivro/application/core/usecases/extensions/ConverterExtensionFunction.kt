package com.mercadolivro.application.core.usecases.extensions

import com.mercadolivro.adapters.`in`.controllers.request.CreateBookRequest
import com.mercadolivro.adapters.`in`.controllers.request.CreateCustomerRequest
import com.mercadolivro.adapters.`in`.controllers.request.UpdateBookRequest
import com.mercadolivro.adapters.`in`.controllers.request.UpdateCustomerRequest
import com.mercadolivro.adapters.`in`.controllers.responses.BookResponse
import com.mercadolivro.adapters.`in`.controllers.responses.CustomerResponse
import com.mercadolivro.adapters.out.repositories.entities.Book
import com.mercadolivro.adapters.out.repositories.entities.Customer
import com.mercadolivro.adapters.out.repositories.entities.enums.BookStatus
import com.mercadolivro.adapters.out.repositories.entities.enums.CustomerStatus

fun CreateCustomerRequest.toCustomerModel(): Customer {
    return Customer(name = this.name, email = this.email, status = CustomerStatus.ATIVO)
}

fun UpdateCustomerRequest.toCustomerModel(previousValue: Customer): Customer {
    return Customer(id = previousValue.id, name = this.name, email = this.email, status = previousValue.status)
}

fun CreateBookRequest.toBookModel(customer: Customer): Book {
    return Book(name = this.name, price = this.price, status = BookStatus.ATIVO, customer = customer)
}

fun UpdateBookRequest.toBookModel(previousValue: Book): Book {
    return Book(
        id = previousValue.id,
        name = this.name ?: previousValue.name,
        price = this.price ?: previousValue.price,
        status = previousValue.status,
        customer = previousValue.customer
    )
}

fun Customer.toCustomerResponse(): CustomerResponse {
    return CustomerResponse(name = this.name, email = this.email, status = this.status)
}

fun Book.toBookResponse(): BookResponse {
    return BookResponse(
        id = this.id,
        name = this.name,
        price = this.price,
        status = this.status,
        customer = this.customer
    )
}