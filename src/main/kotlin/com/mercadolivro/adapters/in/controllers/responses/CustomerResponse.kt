package com.mercadolivro.adapters.`in`.controllers.responses

import com.mercadolivro.adapters.out.repositories.entities.enums.CustomerStatus

data class CustomerResponse(
    var name: String,
    var email: String,
    var status: CustomerStatus
)
