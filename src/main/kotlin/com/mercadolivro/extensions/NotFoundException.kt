package com.mercadolivro.extensions

import java.lang.Exception

class NotFoundException(
    override val message: String?,
    val errorCode: String
): Exception()