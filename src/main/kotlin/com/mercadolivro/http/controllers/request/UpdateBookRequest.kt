package com.mercadolivro.http.controllers.request

import java.math.BigDecimal

data class UpdateBookRequest(
    var name: String?,
    var price: BigDecimal?
)
