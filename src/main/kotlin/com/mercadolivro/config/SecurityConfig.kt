package com.mercadolivro.config

import com.mercadolivro.security.AuthenticatonFilter
import com.mercadolivro.service.CustomerService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val customerService: CustomerService,
    private val configuration: AuthenticationConfiguration
) {

    private val URL_POST_MATCHERS = "/mercado-livro/customer"

    @Bean
    fun configure(http: HttpSecurity): SecurityFilterChain {
        return http
            .csrf { it.disable() }
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
            .authorizeHttpRequests {
                it.requestMatchers(HttpMethod.POST, URL_POST_MATCHERS)
                    .permitAll()
                    .anyRequest()
                    .authenticated()
            }
            .addFilter(AuthenticatonFilter(configuration.authenticationManager, customerService))
            .build()
    }

    @Bean
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

}