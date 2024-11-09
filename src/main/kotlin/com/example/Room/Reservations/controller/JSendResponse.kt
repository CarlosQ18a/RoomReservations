package com.example.sistema.response

data class JSendResponse(
    val status: String,
    val message: String? = null,
    val data: Any? = null,
    val code: Int? = null
) {
    companion object {
        fun success(data: Any?, message: String? = null): JSendResponse {
            return JSendResponse(status = "success", message = message, data = data)
        }

        fun fail(data: Any?, message: String? = null): JSendResponse {
            return JSendResponse(status = "fail", message = message, data = data)
        }

        fun error(message: String, code: Int? = null): JSendResponse {
            return JSendResponse(status = "error", message = message, data = null, code = code)
        }
    }
}
