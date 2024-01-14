package com.mercadolivro.exceptions

import java.lang.Exception

class NotFoundException(
    override val message: String?,
    val errorCode: String
): Exception()