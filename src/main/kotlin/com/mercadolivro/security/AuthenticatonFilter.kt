package com.mercadolivro.security

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.mercadolivro.exceptions.AuthenticationException
import com.mercadolivro.http.controllers.request.LoginRequest
import com.mercadolivro.repositories.CustomerRepository
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class AuthenticatonFilter(
    authenticationManager: AuthenticationManager,
    private val customerRepository: CustomerRepository
) : UsernamePasswordAuthenticationFilter(authenticationManager) {

    override fun attemptAuthentication(request: HttpServletRequest, response: HttpServletResponse): Authentication {
        try {
            val loginRequest = jacksonObjectMapper().readValue(request.inputStream, LoginRequest::class.java)
            val id = customerRepository.findByEmail(loginRequest.email)?.id
            val authenticationToken = UsernamePasswordAuthenticationToken(id, loginRequest.password)
            return authenticationManager.authenticate(authenticationToken)
        } catch (ex: Exception) {
            throw AuthenticationException("Falha na autenticação!", "9999")
        }
    }

    override fun successfulAuthentication(
        request: HttpServletRequest,
        response: HttpServletResponse,
        chain: FilterChain,
        authResult: Authentication
    ) {
        val id = (authResult.principal as UserCustomDetails).id

        response.addHeader("Authorization", "123456")
    }
}