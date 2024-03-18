package com.rbb.network.retrofit

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("x-api-key", "live_pBrXc3QCFqFWUaizOSUmPu9jyUsN1rDkOh4J2kMatuiwNG6TxSj2ISA8QDNItm4I")
            .build()
        return chain.proceed(request)
    }
}
