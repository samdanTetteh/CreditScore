package com.ijikod.domain.entity

data class CreditScore(
    val creditReportInfo: CreditReportInfo,
)

data class CreditReportInfo(
    val score: Int,
    val maxScoreValue: Int
)