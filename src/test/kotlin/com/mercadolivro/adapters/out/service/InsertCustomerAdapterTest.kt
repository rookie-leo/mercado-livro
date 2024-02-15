package com.mercadolivro.adapters.out.service

import com.mercadolivro.adapters.out.repositories.CustomerRepository
import com.mercadolivro.adapters.out.repositories.entities.enums.CustomerStatus
import com.mercadolivro.application.core.domain.Customer
import com.mercadolivro.application.core.usecases.extensions.toCustomerEntity
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.*

class InsertCustomerAdapterTest {

    @Test
    fun `test save customer`() {
        val customerRepository = mock(CustomerRepository::class.java)
        val insertCustomerAdapter = InsertCustomerAdapter(customerRepository)
        val customer = Customer(1, "John Doe", "john@example.com", CustomerStatus.ATIVO)

        `when`(customerRepository.save(any())).thenReturn(customer.toCustomerEntity())

        insertCustomerAdapter.saveCustomer(customer)

        verify(customerRepository).save(customer.toCustomerEntity())
    }
}