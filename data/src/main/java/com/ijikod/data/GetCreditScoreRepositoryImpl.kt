package com.ijikod.data

import com.ijikod.data.api.CreditScoreApi
import com.ijikod.data.extentions.toDomain
import com.ijikod.domain.entity.CreditScore
import com.ijikod.domain.repository.GetCreditScoreRepository
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class GetCreditScoreRepositoryImpl @Inject constructor(
            private val remote: CreditScoreApi
): GetCreditScoreRepository {

    override fun getCreditScore(): Observable<CreditScore> {
        return remote.getCreditScore().toObservable().map { it.toDomain() }
    }

}