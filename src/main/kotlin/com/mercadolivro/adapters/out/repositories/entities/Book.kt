package com.mercadolivro.adapters.out.repositories.entities

import com.mercadolivro.application.core.exceptions.BadRequestException
import com.mercadolivro.adapters.out.repositories.entities.enums.BookStatus
import com.mercadolivro.adapters.out.repositories.entities.enums.Errors
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

    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customer: Customer? = null
) {
    @Column
    @Enumerated(EnumType.STRING)
    var status: BookStatus? = null
        set(value) {
            if (field == BookStatus.CANCELADO || field == BookStatus.DELETADO)
                throw BadRequestException(Errors.ME_1002.message, Errors.ME_1002.code)
            field = value
        }

    constructor(
        id: Int? = null,
        name: String,
        price: BigDecimal,
        customer: Customer? = null,
        status: BookStatus?
    ): this(id, name, price, customer) {
        this.status = status
    }
}