package com.mercadolivro.http.controllers

import com.mercadolivro.extensions.toCustomerModel
import com.mercadolivro.http.controllers.request.CreateCustomerRequest
import com.mercadolivro.http.controllers.request.UpdateCustomerRequest
import com.mercadolivro.models.Customer
import com.mercadolivro.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("mercado-livro/customer")
class CustomerController(
    val customerService: CustomerService
) {
    @GetMapping
    fun getAllCustomer(@RequestParam name: String?): List<Customer> {
        return customerService.getAllCustomer(name)
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: Int): Customer {
        return customerService.getCustomerById(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody customerRequest: CreateCustomerRequest) {
        customerService.createCustomer(customerRequest.toCustomerModel())
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomer(@PathVariable id: Int, @RequestBody customerRequest: UpdateCustomerRequest) {
        val customerSaved = customerService.getCustomerById(id)
        customerService.updateCustomer(customerRequest.toCustomerModel(customerSaved))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable id: Int) {
        customerService.deleteCustomer(id)
    }
}