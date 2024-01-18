package com.mercadolivro.models

import com.mercadolivro.models.enums.CustomerStatus
import com.mercadolivro.models.enums.Profile
import jakarta.persistence.*

@Entity(name = "tb_customer")
data class Customer(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column(name = "customer_name")
    var name: String,

    @Column(name = "customer_email")
    var email: String,

    @Column
    @Enumerated(EnumType.STRING)
    var status: CustomerStatus,

    @Column
    val password: String,

    @Column(name= "role")
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Profile::class, fetch = FetchType.EAGER)
    @CollectionTable(name = "tb_customer_role", joinColumns = [JoinColumn(name= "customer_id")])
    var roles: Set<Profile> = setOf()
)