package com.mercadolivro.application.core.domain

import com.mercadolivro.adapters.out.repositories.entities.enums.CustomerStatus

data class Customer(
    var id: Int? = null,
    var name: String,
    var email: String,
    var status: CustomerStatus
)