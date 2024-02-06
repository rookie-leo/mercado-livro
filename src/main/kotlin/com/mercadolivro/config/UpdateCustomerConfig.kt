package com.mercadolivro.config

import com.mercadolivro.adapters.out.service.UpdateCustomerAdapter
import com.mercadolivro.application.core.usecases.UpdateCustomerUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UpdateCustomerConfig {

    @Bean
    fun updateCustomerUseCase(updateCustomerAdapter: UpdateCustomerAdapter): UpdateCustomerUseCase {
        return UpdateCustomerUseCase(updateCustomerAdapter)
    }

}