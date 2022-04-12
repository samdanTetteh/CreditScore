package com.ijikod.presentation.states

import CreditScoreStates

sealed class CreditScoreEvents {
    object Loading: CreditScoreEvents()
    data class ShowCreditScore(val state: CreditScoreStates): CreditScoreEvents()
    data class Error (val error: Throwable): CreditScoreEvents()
}