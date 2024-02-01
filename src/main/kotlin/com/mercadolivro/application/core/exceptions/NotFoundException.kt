package com.mercadolivro.application.core.exceptions

import java.lang.Exception

class NotFoundException(
    override val message: String?,
    val errorCode: String
): Exception()