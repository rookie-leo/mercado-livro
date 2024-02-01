package com.mercadolivro.adapters.out.repositories.entities

import com.mercadolivro.adapters.out.repositories.entities.enums.CustomerStatus
import jakarta.persistence.*

@Entity(name = "tb_customer")
data class CustomerEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column(name = "customer_name")
    var name: String,

    @Column(name = "customer_email")
    var email: String,

    @Column
    @Enumerated(EnumType.STRING)
    var status: CustomerStatus
)