package com.mercadolivro.adapters.out.service

import com.mercadolivro.adapters.out.repositories.CustomerRepository
import com.mercadolivro.adapters.out.repositories.entities.enums.CustomerStatus
import com.mercadolivro.application.core.domain.Customer
import com.mercadolivro.application.core.usecases.extensions.toCustomerEntity
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.*

class UpdateCustomerAdapterTest {
    @Test
    fun `test update customer`() {
        val customerRepository = mock(CustomerRepository::class.java)
        val updatedCustomer = Customer(1, "Jane Doe", "jane@example.com", CustomerStatus.ATIVO)

        `when`(customerRepository.save(any())).thenReturn(updatedCustomer.toCustomerEntity())

        val updateCustomerAdapter = UpdateCustomerAdapter(customerRepository)

        updateCustomerAdapter.updateCustomer(updatedCustomer)

        verify(customerRepository).save(updatedCustomer.toCustomerEntity())
    }
}