package com.ijikod.data.responses

import com.google.gson.annotations.SerializedName


interface CreditScoreContract {

    data class CreditScoreResponse(
        @SerializedName("accountIDVStatus") val accountIDVStatus: String,
        @SerializedName("creditReportInfo") val creditReportInfo: CreditReportInfoResponse,
        @SerializedName("dashboardStatus") val dashboardStatus: String,
        @SerializedName("personaType") val personaType: String,
        @SerializedName("coachingSummary") val coachingSummary: CoachingSummaryResponse,
        @SerializedName("augmentedCreditScore") val augmentedCreditScore: Any? = null
    )

    data class CoachingSummaryResponse(
        @SerializedName("activeTodo") val activeTodo: Boolean,
        @SerializedName("activeChat") val activeChat: Boolean,
        @SerializedName("numberOfTodoItems") val numberOfTodoItems: Long,
        @SerializedName("numberOfCompletedTodoItems") val numberOfCompletedTodoItems: Long,
        @SerializedName("selected") val selected: Boolean
    )

    data class CreditReportInfoResponse(
        @SerializedName("score") val score: Long,
        @SerializedName("scoreBand") val scoreBand: Long,
        @SerializedName("clientRef") val clientRef: String,
        @SerializedName("status") val status: String,
        @SerializedName("maxScoreValue") val maxScoreValue: Long,
        @SerializedName("minScoreValue") val minScoreValue: Long,
        @SerializedName("monthsSinceLastDefaulted") val monthsSinceLastDefaulted: Long,
        @SerializedName("hasEverDefaulted") val hasEverDefaulted: Boolean,
        @SerializedName("monthsSinceLastDelinquent") val monthsSinceLastDelinquent: Long,
        @SerializedName("hasEverBeenDelinquent") val hasEverBeenDelinquent: Boolean,
        @SerializedName("percentageCreditUsed") val percentageCreditUsed: Long,
        @SerializedName("percentageCreditUsedDirectionFlag") val percentageCreditUsedDirectionFlag: Long,
        @SerializedName("changedScore") val changedScore: Long,
        @SerializedName("currentShortTermDebt") val currentShortTermDebt: Long,
        @SerializedName("currentShortTermNonPromotionalDebt") val currentShortTermNonPromotionalDebt: Long,
        @SerializedName("currentShortTermCreditLimit") val currentShortTermCreditLimit: Long,
        @SerializedName("currentShortTermCreditUtilisation") val currentShortTermCreditUtilisation: Long,
        @SerializedName("changeInShortTermDebt") val changeInShortTermDebt: Long,
        @SerializedName("currentLongTermDebt") val currentLongTermDebt: Long,
        @SerializedName("currentLongTermNonPromotionalDebt") val currentLongTermNonPromotionalDebt: Long,
        @SerializedName("currentLongTermCreditLimit") val currentLongTermCreditLimit: Any? = null,
        @SerializedName("currentLongTermCreditUtilisation") val currentLongTermCreditUtilisation: Any? = null,
        @SerializedName("changeInLongTermDebt") val changeInLongTermDebt: Long,
        @SerializedName("numPositiveScoreFactors") val numPositiveScoreFactors: Long,
        @SerializedName("numNegativeScoreFactors") val numNegativeScoreFactors: Long,
        @SerializedName("equifaxScoreBand") val equifaxScoreBand: Long,
        @SerializedName("equifaxScoreBandDescription") val equifaxScoreBandDescription: String,
        @SerializedName("daysUntilNextReport")  val daysUntilNextReport: Int
    )

}