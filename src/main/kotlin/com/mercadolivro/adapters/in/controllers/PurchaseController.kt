package com.mercadolivro.adapters.`in`.controllers

import com.mercadolivro.adapters.`in`.controllers.mapper.PurchaseMapper
import com.mercadolivro.adapters.`in`.controllers.request.CreatePurchaseRequest
import com.mercadolivro.adapters.out.service.PurchaseService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("mercado-livro/purchases")
class PurchaseController(
    private val purchaseService: PurchaseService,
    private val purchaseMapper: PurchaseMapper
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun purchase(@RequestBody request: CreatePurchaseRequest) {
        purchaseService.create(purchaseMapper.toModel(request))
    }

}