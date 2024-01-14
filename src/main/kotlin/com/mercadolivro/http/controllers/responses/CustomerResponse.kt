package com.mercadolivro.http.controllers.responses

import com.mercadolivro.models.enums.CustomerStatus

data class CustomerResponse(
    var name: String,
    var email: String,
    var status: CustomerStatus
)
