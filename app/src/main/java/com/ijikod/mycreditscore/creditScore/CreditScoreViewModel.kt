package com.ijikod.mycreditscore.creditScore

import com.ijikod.mycreditscore.creditScore.states.CreditScoreStates
import com.ijikod.domain.useCases.GetCreditScoreUseCase
import com.ijikod.mycreditscore.common.AsyncResult
import com.ijikod.mycreditscore.common.Reducer
import com.ijikod.mycreditscore.common.RxViewModelStore
import com.ijikod.mycreditscore.common.mapToAsyncResult
import com.ijikod.mycreditscore.creditScore.states.CreditScoreEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class CreditScoreViewModel @Inject constructor(
    private val getCreditScoreUseCase: GetCreditScoreUseCase
): RxViewModelStore<CreditScoreStates, CreditScoreEvents>(CreditScoreStates()) {

    fun getMyCreditScore() {
        getCreditScoreUseCase()
            .mapToAsyncResult()
            .subscribeOn(Schedulers.io())
            .subscribe { result ->
                when (result) {
                    is AsyncResult.Loading -> {
                        publish(CreditScoreEvents.Loading)
                    }

                    is AsyncResult.Error -> {
                        publish(CreditScoreEvents.Error(result.error))
                    }

                    is AsyncResult.Success -> {
                        applyState(Reducer { currentState().copy(creditScore = result) })
                        publish(CreditScoreEvents.ShowCreditScore(currentState()))
                    }
                }
            }.addDisposable()
    }



}