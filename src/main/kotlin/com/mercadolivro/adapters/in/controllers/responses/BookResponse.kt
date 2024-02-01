package com.mercadolivro.adapters.`in`.controllers.responses

import com.mercadolivro.adapters.out.repositories.entities.Customer
import com.mercadolivro.adapters.out.repositories.entities.enums.BookStatus
import java.math.BigDecimal

data class BookResponse(
    var id: Int? = null,
    var name: String,
    var price: BigDecimal,
    var customer: Customer? = null,
    var status: BookStatus? = null
)