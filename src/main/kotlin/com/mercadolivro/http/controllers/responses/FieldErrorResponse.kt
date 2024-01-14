package com.mercadolivro.http.controllers.responses

data class FieldErrorResponse(
    var message: String,
    var field: String
)
