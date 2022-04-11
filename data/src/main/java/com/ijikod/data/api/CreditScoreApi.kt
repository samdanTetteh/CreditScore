package com.ijikod.data.api

import com.ijikod.data.responses.CreditScoreContract
import retrofit2.http.GET
import io.reactivex.Single

interface CreditScoreApi {

    @GET("endpoint.json")
    fun getCreditScore(): Single<CreditScoreContract.CreditScoreResponse>
}