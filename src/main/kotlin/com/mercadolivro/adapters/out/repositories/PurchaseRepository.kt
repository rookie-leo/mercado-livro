package com.mercadolivro.adapters.out.repositories

import com.mercadolivro.adapters.out.repositories.entities.Purchase
import org.springframework.data.repository.CrudRepository

interface PurchaseRepository : CrudRepository<Purchase, Int> {

}