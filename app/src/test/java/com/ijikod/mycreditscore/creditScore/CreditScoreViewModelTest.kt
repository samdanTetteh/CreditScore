package com.ijikod.mycreditscore.creditScore

import com.ijikod.domain.useCases.GetCreditScoreUseCase
import com.ijikod.mycreditscore.FakeRepository
import com.ijikod.mycreditscore.Fakes
import com.ijikod.mycreditscore.common.RxJavaTestRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CreditScoreViewModelTest{

    @get:Rule
    val rxRule = RxJavaTestRule()

    private lateinit var viewModel: CreditScoreViewModel


    @Before
    fun setUp() {
        viewModel = CreditScoreViewModel(GetCreditScoreUseCase(FakeRepository()))
    }


    @Test
    fun `initial states values are null`() {
        val testObserver = viewModel.states().test()
        testObserver.assertValue { state -> state.creditScore == null }
        testObserver.assertValue { state -> state.getCreditScore == null }
    }

    @Test
    fun `when init is called data for creditScore is loaded`() {
        viewModel.getMyCreditScore()

        val testObserver = viewModel.states().test()
        testObserver.assertValue { state -> state.getCreditScore == Fakes.getFakeCreditScore().creditReportInfo}
    }

}