package com.mercadolivro.models.enums

enum class Errors(
    val code: String,
    val message: String
) {
    ME_1001("ME-1001", "Livro com o id %s não encontrado"),
    ME_2001("ME-2001", "Customer com id: %s não encontrado", )
}