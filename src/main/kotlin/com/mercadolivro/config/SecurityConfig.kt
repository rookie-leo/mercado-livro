package com.mercadolivro.config

import com.mercadolivro.repositories.CustomerRepository
import com.mercadolivro.security.AuthenticatonFilter
import com.mercadolivro.service.CustomerService
import com.mercadolivro.service.UserDetailsCustomService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val customerRepository: CustomerRepository,
    private val configuration: AuthenticationConfiguration,
    private val userDetailsCustomService: UserDetailsCustomService
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
            .addFilter(AuthenticatonFilter(configuration.authenticationManager, customerRepository))
            .build()
    }

    fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetailsCustomService).passwordEncoder(bCryptPasswordEncoder())
    }

    @Bean
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

}