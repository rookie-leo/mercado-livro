package com.mercadolivro.adapters.`in`.controllers.request

import com.fasterxml.jackson.annotation.JsonAlias
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class CreateBookRequest (
    @field:NotEmpty(message = "O titulo do livro deve ser informado")
    var name: String,

    @field:NotEmpty(message = "O valor do livro deve ser informado")
    var price: BigDecimal,

    @field:NotNull(message = "O id do Customer deve ser informado")
    @JsonAlias("customer_id")
    var customerId: Int
)