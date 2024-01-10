package com.mercadolivro.extensions

import com.mercadolivro.http.controllers.request.CreateCustomerRequest
import com.mercadolivro.http.controllers.request.UpdateCustomerRequest
import com.mercadolivro.models.Customer

fun CreateCustomerRequest.toCustomerModel(): Customer {
    return Customer(name = this.name, email = this.email)
}

fun UpdateCustomerRequest.toCustomerModel(id: String): Customer {
    return Customer(id = id, name = this.name, email = this.email)
}