package com.mercadolivro.application.core.exceptions

import java.lang.Exception

class BadRequestException(
    override val message: String?,
    val errorCode: String
): Exception()