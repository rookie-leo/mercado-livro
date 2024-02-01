package com.mercadolivro.config

import com.mercadolivro.adapters.out.service.InsertCustomerAdapter
import com.mercadolivro.application.core.usecases.CreateCustomerUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InsertCustomerConfig {

    @Bean
    fun insertCustomerUseCase(insertCustomerAdapter: InsertCustomerAdapter): CreateCustomerUseCase {
        return CreateCustomerUseCase(insertCustomerAdapter)
    }

}