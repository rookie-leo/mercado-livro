package com.mercadolivro.config

import com.mercadolivro.adapters.out.service.ReadCustomerAdapter
import com.mercadolivro.application.core.usecases.ReadCustomerUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FindCustomerConfig {

    @Bean
    fun readCustomerUseCase(readCustomerAdapter: ReadCustomerAdapter): ReadCustomerUseCase {
        return ReadCustomerUseCase(readCustomerAdapter)
    }
    
}