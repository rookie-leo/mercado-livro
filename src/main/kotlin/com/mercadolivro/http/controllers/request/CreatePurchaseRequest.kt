package com.mercadolivro.http.controllers.request

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive

data class CreatePurchaseRequest(

    @field:NotNull
    @field:Positive
    val customerId: Int,

    @field:NotNull
    val booksId: Set<Int>
)
