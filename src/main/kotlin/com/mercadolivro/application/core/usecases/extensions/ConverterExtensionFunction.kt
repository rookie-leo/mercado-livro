package com.mercadolivro.application.core.usecases.extensions

import com.mercadolivro.adapters.`in`.controllers.request.CreateBookRequest
import com.mercadolivro.adapters.`in`.controllers.request.CreateCustomerRequest
import com.mercadolivro.adapters.`in`.controllers.request.UpdateBookRequest
import com.mercadolivro.adapters.`in`.controllers.request.UpdateCustomerRequest
import com.mercadolivro.adapters.`in`.controllers.responses.BookResponse
import com.mercadolivro.adapters.`in`.controllers.responses.CustomerResponse
import com.mercadolivro.adapters.out.repositories.entities.Book
import com.mercadolivro.adapters.out.repositories.entities.CustomerEntity
import com.mercadolivro.adapters.out.repositories.entities.enums.BookStatus
import com.mercadolivro.adapters.out.repositories.entities.enums.CustomerStatus
import com.mercadolivro.application.core.domain.Customer

fun CreateCustomerRequest.toCustomer(): Customer {
    return Customer(name = this.name, email = this.email, status = CustomerStatus.ATIVO)
}

fun Customer.toCustomerEntity(): CustomerEntity {
    return CustomerEntity(name = this.name, email = this.email, status = this.status)
}

fun Customer.toCustomerResponse(): CustomerResponse {
    return CustomerResponse(name = this.name, email = this.email, status = this.status)
}

fun CustomerEntity.toCustomer(): Customer {
    return Customer(name = this.name, email = this.email, status = this.status)
}

fun UpdateCustomerRequest.toCustomerModel(previousValue: CustomerEntity): CustomerEntity {
    return CustomerEntity(id = previousValue.id, name = this.name, email = this.email, status = previousValue.status)
}

fun CreateBookRequest.toBookModel(customer: CustomerEntity): Book {
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

fun CustomerEntity.toCustomerResponse(): CustomerResponse {
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