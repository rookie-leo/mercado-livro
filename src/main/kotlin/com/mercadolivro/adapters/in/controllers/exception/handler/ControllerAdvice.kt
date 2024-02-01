package com.mercadolivro.adapters.`in`.controllers.exception.handler

import com.mercadolivro.adapters.`in`.controllers.responses.ErrorResponse
import com.mercadolivro.adapters.`in`.controllers.responses.FieldErrorResponse
import com.mercadolivro.application.core.exceptions.BadRequestException
import com.mercadolivro.application.core.exceptions.NotFoundException
import com.mercadolivro.adapters.out.repositories.entities.enums.Errors
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(ex: NotFoundException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val erro = ErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            ex.message!!,
            ex.errorCode,
            null
        )
        return ResponseEntity(erro, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(BadRequestException::class)
    fun handleBadRequestException(ex: BadRequestException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val erro = ErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            ex.message!!,
            ex.errorCode,
            null
        )
        return ResponseEntity(erro, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(ex: MethodArgumentNotValidException, request: WebRequest):
            ResponseEntity<ErrorResponse> {
        val erro = ErrorResponse(
            HttpStatus.UNPROCESSABLE_ENTITY.value(),
            Errors.MER_0001.message,
            Errors.MER_0001.code,
            ex.bindingResult.fieldErrors.map {
                FieldErrorResponse(it.defaultMessage ?: "Invalido", it.field)
            }
        )

        return ResponseEntity(erro, HttpStatus.UNPROCESSABLE_ENTITY)
    }
}