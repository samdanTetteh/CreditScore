package com.ijikod.mycreditscore

import com.ijikod.domain.entity.CreditScore
import com.ijikod.domain.repository.GetCreditScoreRepository
import io.reactivex.Observable
import javax.inject.Inject

class FakeRepository @Inject constructor(): GetCreditScoreRepository {

    override fun getCreditScore(): Observable<CreditScore> = Observable.just(Fakes.getFakeCreditScore())

}