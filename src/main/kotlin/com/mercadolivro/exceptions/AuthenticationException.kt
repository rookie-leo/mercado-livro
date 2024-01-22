package com.mercadolivro.exceptions

import java.lang.Exception

class AuthenticationException(
    override val message: String?,
    val errorCode: String
): Exception()