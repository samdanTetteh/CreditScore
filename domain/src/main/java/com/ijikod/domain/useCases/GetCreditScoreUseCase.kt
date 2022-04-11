package com.ijikod.domain.useCases

import com.ijikod.domain.entity.CreditScore
import com.ijikod.domain.repository.GetCreditScoreRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetCreditScoreUseCase @Inject constructor(private val repository: GetCreditScoreRepository) {

    operator fun invoke(): Observable<CreditScore> {
        return repository.getCreditScore()
    }

}