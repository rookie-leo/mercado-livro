package com.mercadolivro.adapters.`in`.controllers.request

import java.math.BigDecimal

data class UpdateBookRequest(
    var name: String?,
    var price: BigDecimal?
)
