package com.mercadolivro.config

import com.mercadolivro.adapters.out.service.DeleteCustomerAdapter
import com.mercadolivro.application.core.usecases.DeleteCustomerUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DeleteCustomerConfig {

    @Bean
    fun deleteCustomerUseCase(
        deleteCustomerAdapter: DeleteCustomerAdapter
    ): DeleteCustomerUseCase {
        return DeleteCustomerUseCase(deleteCustomerAdapter)
    }

}