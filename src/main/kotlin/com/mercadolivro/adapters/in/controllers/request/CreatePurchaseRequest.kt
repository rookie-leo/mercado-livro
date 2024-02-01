package com.mercadolivro.adapters.`in`.controllers.request

import com.fasterxml.jackson.annotation.JsonAlias
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive

data class CreatePurchaseRequest(

    @field:NotNull
    @field:Positive
    @JsonAlias("customer_id")
    val customerId: Int,

    @field:NotNull
    @JsonAlias("books_id")
    val booksId: Set<Int>
)
