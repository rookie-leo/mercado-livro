package com.mercadolivro.extensions

import com.mercadolivro.http.controllers.request.CreateBookRequest
import com.mercadolivro.http.controllers.request.CreateCustomerRequest
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