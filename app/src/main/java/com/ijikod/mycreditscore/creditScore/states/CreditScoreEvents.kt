package com.ijikod.mycreditscore.creditScore.states

sealed class CreditScoreEvents {
    object Loading: CreditScoreEvents()
    data class ShowCreditScore(val state: CreditScoreStates): CreditScoreEvents()
    data class Error (val error: Throwable): CreditScoreEvents()
}