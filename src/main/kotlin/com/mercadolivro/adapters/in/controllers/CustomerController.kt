package com.mercadolivro.adapters.`in`.controllers

import com.mercadolivro.adapters.`in`.controllers.request.CreateCustomerRequest
import com.mercadolivro.adapters.`in`.controllers.request.UpdateCustomerRequest
import com.mercadolivro.adapters.`in`.controllers.responses.CustomerResponse
import com.mercadolivro.application.core.usecases.CreateCustomerUseCase
import com.mercadolivro.application.core.usecases.ReadCustomerUseCase
import com.mercadolivro.application.core.usecases.UpdateCustomerUseCase
import com.mercadolivro.application.core.usecases.extensions.toCustomer
import com.mercadolivro.application.core.usecases.extensions.toCustomerResponse
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("mercado-livro/customer")
class CustomerController(
//    val customerService: CustomerService
    val createCustomerUseCase: CreateCustomerUseCase,
    val readCustomerUseCase: ReadCustomerUseCase,
    val updateCustomerUseCase: UpdateCustomerUseCase
) {
    @GetMapping
    fun getAllCustomer(@RequestParam name: String?): List<CustomerResponse> {
        return readCustomerUseCase.read(name).map { it.toCustomerResponse() }
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: Int): CustomerResponse {
        return readCustomerUseCase.getCustomerById(id).toCustomerResponse()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody @Valid customerRequest: CreateCustomerRequest) {
        createCustomerUseCase.create(customerRequest.toCustomer())
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomer(@PathVariable id: Int, @Valid @RequestBody customerRequest: UpdateCustomerRequest) {
        val customerSaved = readCustomerUseCase.getCustomerById(id)
        updateCustomerUseCase.update(customerRequest.toCustomer(id, customerSaved))
    }

//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    fun deleteCustomer(@PathVariable id: Int) {
//        customerService.deleteCustomer(id)
//    }
}