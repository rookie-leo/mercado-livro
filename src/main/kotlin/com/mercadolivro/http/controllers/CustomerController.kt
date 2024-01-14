package com.mercadolivro.http.controllers

import com.mercadolivro.extensions.toCustomerModel
import com.mercadolivro.extensions.toCustomerResponse
import com.mercadolivro.http.controllers.request.CreateCustomerRequest
import com.mercadolivro.http.controllers.request.UpdateCustomerRequest
import com.mercadolivro.http.controllers.responses.CustomerResponse
import com.mercadolivro.service.CustomerService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("mercado-livro/customer")
class CustomerController(
    val customerService: CustomerService
) {
    @GetMapping
    fun getAllCustomer(@RequestParam name: String?): List<CustomerResponse> {
        return customerService.getAllCustomer(name).map { it.toCustomerResponse() }
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: Int): CustomerResponse {
        return customerService.getCustomerById(id).toCustomerResponse()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody @Valid customerRequest: CreateCustomerRequest) {
        customerService.createCustomer(customerRequest.toCustomerModel())
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomer(@PathVariable id: Int, @Valid @RequestBody customerRequest: UpdateCustomerRequest) {
        val customerSaved = customerService.getCustomerById(id)
        customerService.updateCustomer(customerRequest.toCustomerModel(customerSaved))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable id: Int) {
        customerService.deleteCustomer(id)
    }
}