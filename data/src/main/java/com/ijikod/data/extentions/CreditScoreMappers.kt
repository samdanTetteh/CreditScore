package com.ijikod.data.extentions

import com.ijikod.data.responses.CreditScoreContract
import com.ijikod.domain.entity.CreditReportInfo
import com.ijikod.domain.entity.CreditScore

fun CreditScoreContract.CreditScoreResponse.toDomain(): CreditScore {
    return CreditScore(
        creditReportInfo = this.creditReportInfo.toDomain()
    )
}

fun CreditScoreContract.CreditReportInfoResponse.toDomain(): CreditReportInfo {
    return CreditReportInfo(
        score = this.score.toInt(),
        maxScoreValue = this.maxScoreValue.toInt()
    )
}