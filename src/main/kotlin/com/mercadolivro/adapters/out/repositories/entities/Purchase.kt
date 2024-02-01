package com.mercadolivro.adapters.out.repositories.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity(name = "tb_purchase")
data class Purchase(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @ManyToOne
    @JoinColumn
    val customer: Customer,

    @ManyToMany
    @JoinTable(
        name = "tb_puchase_book",
        joinColumns = [JoinColumn(name = "purchase_id")],
        inverseJoinColumns = [JoinColumn(name = "book_id")]
    )
    val books: MutableList<Book>,

    @Column
    val nfe: String? = null,

    @Column(name = "purchase_total_value")
    val purchaseTotalValue: BigDecimal,

    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now()
)