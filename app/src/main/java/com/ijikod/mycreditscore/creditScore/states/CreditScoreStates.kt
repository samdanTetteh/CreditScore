package com.ijikod.mycreditscore.creditScore.states

import com.ijikod.domain.entity.CreditReportInfo
import com.ijikod.domain.entity.CreditScore
import com.ijikod.mycreditscore.common.AsyncResult

data class CreditScoreStates(
    val creditScore: AsyncResult<CreditScore>? = null
) {

    val getCreditScore: CreditReportInfo?
        get() = if(creditScore is AsyncResult.Success && creditScore.data != null) {
            creditScore.data.creditReportInfo
        } else null
}