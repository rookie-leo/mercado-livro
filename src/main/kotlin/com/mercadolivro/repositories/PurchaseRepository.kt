package com.mercadolivro.repositories

import com.mercadolivro.models.Purchase
import org.springframework.data.repository.CrudRepository

interface PurchaseRepository : CrudRepository<Purchase, Int> {

}