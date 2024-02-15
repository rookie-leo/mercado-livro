package com.mercadolivro.adapters.out.service

import com.mercadolivro.adapters.out.repositories.CustomerRepository
import com.mercadolivro.adapters.out.repositories.entities.CustomerEntity
import com.mercadolivro.adapters.out.repositories.entities.enums.CustomerStatus
import com.mercadolivro.application.core.exceptions.NotFoundException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import java.util.*

class ReadCustomerAdapterTest {

    val customerRepository = mock(CustomerRepository::class.java)
    val customer = CustomerEntity(1, "John Doe", "john@example.com", CustomerStatus.ATIVO)

    @Test
    fun `test read customers without name`() {
        val customers = listOf(customer)

        `when`(customerRepository.findAll()).thenReturn(customers)

        val readCustomerAdapter = ReadCustomerAdapter(customerRepository)
        val result = readCustomerAdapter.read(null)

        verify(customerRepository).findAll()

        assert(result == customers)
    }

    @Test
    fun `test read customers with name`() {
        val customers = listOf(customer)

        `when`(customerRepository.findByNameContaining("John")).thenReturn(customers)

        val readCustomerAdapter = ReadCustomerAdapter(customerRepository)
        val result = readCustomerAdapter.read("John")

        verify(customerRepository).findByNameContaining("John")

        assert(result == customers)
    }

    @Test
    fun `test read customer by id`() {
        `when`(customerRepository.findById(1)).thenReturn(Optional.of(customer))

        val readCustomerAdapter = ReadCustomerAdapter(customerRepository)
        val result = readCustomerAdapter.readById(1)

        verify(customerRepository).findById(1)

        assert(result == customer)
    }

    @Test
    fun `test read non-existent customer by id`() {
        val errorMessage = "Customer com id: 1 não encontrado"
        val errorCode = "ME-2001"

        `when`(customerRepository.findById(1)).thenReturn(Optional.empty())

        val readCustomerAdapter = ReadCustomerAdapter(customerRepository)
        val exception = org.junit.jupiter.api.assertThrows<NotFoundException> {
            readCustomerAdapter.readById(1)
        }

        assertEquals(errorMessage, exception.message)
        assertEquals(errorCode, exception.errorCode)
    }
}