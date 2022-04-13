package com.ijikod.mycreditscore.creditScore.states

import com.ijikod.domain.entity.CreditScore
import com.ijikod.mycreditscore.common.AsyncResult

data class CreditScoreStates(
    val creditScore: AsyncResult<CreditScore>? = null
) {

    val isLoading: Boolean
        get() = creditScore is AsyncResult.Loading

    val getCreditScore: CreditScore?
        get() = if(creditScore is AsyncResult.Success && creditScore.data != null) {
            creditScore.data
        } else null
}