package com.mercadolivro.extensions

import com.mercadolivro.http.controllers.request.CreateBookRequest
import com.mercadolivro.http.controllers.request.CreateCustomerRequest
import com.mercadolivro.http.controllers.request.UpdateBookRequest
import com.mercadolivro.http.controllers.request.UpdateCustomerRequest
import com.mercadolivro.models.Book
import com.mercadolivro.models.Customer
import com.mercadolivro.models.enums.BookStatus

fun CreateCustomerRequest.toCustomerModel(): Customer {
    return Customer(name = this.name, email = this.email)
}

fun UpdateCustomerRequest.toCustomerModel(id: Int): Customer {
    return Customer(id = id, name = this.name, email = this.email)
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