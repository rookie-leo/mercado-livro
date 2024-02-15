package com.mercadolivro.adapters.out.service

import com.mercadolivro.adapters.out.repositories.CustomerRepository
import com.mercadolivro.adapters.out.repositories.entities.CustomerEntity
import com.mercadolivro.adapters.out.repositories.entities.enums.CustomerStatus
import com.mercadolivro.application.core.exceptions.NotFoundException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.Mockito.*
import java.util.*

class DeleteCustomerAdapterTest {

    val customerRepository = mock(CustomerRepository::class.java)
    val bookService = mock(BookService::class.java)


    @Test
    fun `test delete existing customer by id`() {
        // Given
        val customerEntity = CustomerEntity(1, "John Doe", "john@example.com", CustomerStatus.ATIVO)
        `when`(customerRepository.findById(1)).thenReturn(Optional.of(customerEntity))

        // When
        val deleteCustomerAdapter = DeleteCustomerAdapter(customerRepository, bookService)
        deleteCustomerAdapter.deleteById(1)

        // Then
        verify(bookService).deleteBookByCustomer(customerEntity)
        verify(customerRepository).save(customerEntity.apply { status = CustomerStatus.INATIVO })
    }

    @Test
    fun `test delete non-existent customer by id`() {
        // Given
        val errorMessage = "Customer com id: 1 não encontrado"
        val errorCode = "ME-2001"
        `when`(customerRepository.findById(anyInt())).thenReturn(Optional.empty())

        // When
        val deleteCustomerAdapter = DeleteCustomerAdapter(customerRepository, bookService)
        val exception = assertThrows<NotFoundException> {
            deleteCustomerAdapter.deleteById(1)
        }

        // Then
        assert(exception.message == errorMessage)
        assert(exception.errorCode == errorCode)
    }

    @Test
    fun `test delete already inactive customer by id`() {
        // Given
        val errorMessage = "Não é possivel alterar o status de um customer INATIVO"
        val errorCode = "ME-2002"
        val customerEntity = CustomerEntity(1, "John Doe", "john@example.com", CustomerStatus.INATIVO)
        `when`(customerRepository.findById(1)).thenReturn(Optional.of(customerEntity))

        // When
        val deleteCustomerAdapter = DeleteCustomerAdapter(customerRepository, bookService)
        val exception = assertThrows<NotFoundException> {
            deleteCustomerAdapter.deleteById(1)
        }

        // Then
        assertEquals(exception.message, errorMessage)
        assertEquals(exception.errorCode, errorCode)
    }
}