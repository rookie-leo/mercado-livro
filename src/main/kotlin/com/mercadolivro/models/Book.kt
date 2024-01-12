package com.mercadolivro.models

import com.mercadolivro.models.enums.BookStatus
import jakarta.persistence.*
import java.math.BigDecimal

@Entity(name = "tb_book")
data class Book(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var name: String,

    @Column
    var price: BigDecimal,

    @Column
    @Enumerated(EnumType.STRING)
    var status: BookStatus? = null,

    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customer: Customer? = null
)