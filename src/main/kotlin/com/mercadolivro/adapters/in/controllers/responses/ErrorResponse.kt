package com.mercadolivro.adapters.`in`.controllers.responses

data class ErrorResponse(
    var httpCode: Int,
    var message: String,
    var internalCode: String,
    var errors: List<FieldErrorResponse>?
)