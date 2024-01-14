package com.mercadolivro.models.enums

enum class Errors(
    val code: String,
    val message: String
) {
    MER_0001("MER-0001", "Parametro de requisição invalido!"),
    ME_1001("ME-1001", "Livro com o id %s não encontrado"),
    ME_1002("ME-1002", "Não é possivel alterar o status de um livro DELETADO"),
    ME_2001("ME-2001", "Customer com id: %s não encontrado")
}