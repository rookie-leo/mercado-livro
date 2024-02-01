package com.mercadolivro.adapters.`in`.controllers.request

import com.mercadolivro.validations.EmailAvailable
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class CreateCustomerRequest(
    @field:NotEmpty(message = "O nome deve ser informado")
    var name: String,

    @EmailAvailable
    @field:Email(message = "Email deve ester em formato valido!")
    var email: String
)