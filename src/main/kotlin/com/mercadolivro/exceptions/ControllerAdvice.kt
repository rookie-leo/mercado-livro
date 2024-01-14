package com.mercadolivro.exceptions

import com.mercadolivro.http.controllers.responses.ErrorResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import java.lang.Exception

@ControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(Exception::class)
    fun handleException(ex: Exception, request: WebRequest): ResponseEntity<ErrorResponse> {
        val erro = ErrorResponse(
            400,
            "Teste de exception",
            "0000",
            null
        )

        return ResponseEntity.badRequest().body(erro)
    }
}