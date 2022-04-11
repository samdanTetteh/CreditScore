package com.ijikod.domain.repository

import com.ijikod.domain.entity.CreditScore
import io.reactivex.Observable
import io.reactivex.Single


interface GetCreditScoreRepository {

    fun getCreditScore(): Observable<CreditScore>

}