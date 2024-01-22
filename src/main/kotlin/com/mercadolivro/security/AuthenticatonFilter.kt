package com.mercadolivro.security

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.mercadolivro.exceptions.AuthenticationException
import com.mercadolivro.http.controllers.request.LoginRequest
import com.mercadolivro.service.CustomerService
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import java.lang.Exception

class AuthenticatonFilter(
    authenticationManager: AuthenticationManager,
    private val customerService: CustomerService
) : UsernamePasswordAuthenticationFilter(authenticationManager) {

    override fun attemptAuthentication(request: HttpServletRequest, response: HttpServletResponse): Authentication {
        try {
            val loginRequest = jacksonObjectMapper().readValue(request.inputStream, LoginRequest::class.java)
            val id = customerService.findByEmail(loginRequest.email)?.id
            val authenticationToken = UsernamePasswordAuthenticationToken(id, loginRequest.password)
            return authenticationManager.authenticate(authenticationToken)
        } catch (ex: Exception) {
            throw AuthenticationException("Falha na autenticação!", "9999")
        }
    }
}