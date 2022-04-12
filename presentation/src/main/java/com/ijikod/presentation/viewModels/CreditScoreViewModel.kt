package com.ijikod.presentation.viewModels

import CreditScoreStates
import com.ijikod.domain.useCases.GetCreditScoreUseCase
import com.ijikod.presentation.common.AsyncResult
import com.ijikod.presentation.common.Reducer
import com.ijikod.presentation.common.RxViewModelStore
import com.ijikod.presentation.common.mapToAsyncResult
import com.ijikod.presentation.states.CreditScoreEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.schedulers.Schedulers

@HiltViewModel
data class CreditScoreViewModel(
    val getCreditScoreUseCase: GetCreditScoreUseCase
): RxViewModelStore<CreditScoreStates, CreditScoreEvents>(CreditScoreStates()) {


    init {
        getCreditScoreUseCase()
            .mapToAsyncResult()
            .subscribeOn(Schedulers.io())
            .subscribe { result ->
                if (result is AsyncResult.Error) {
                    publish(CreditScoreEvents.Error(result.error))
                } else {
                    applyState(Reducer { currentState().copy(creditScore = result) })
                    publish(CreditScoreEvents.ShowCreditScore(currentState()))
                }
            }.addDisposable()
    }



}