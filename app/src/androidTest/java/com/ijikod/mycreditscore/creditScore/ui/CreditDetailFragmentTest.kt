package com.ijikod.mycreditscore.creditScore.ui

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.ijikod.mycreditscore.R
import com.ijikod.mycreditscore.common.CLIENT_REF
import com.ijikod.mycreditscore.common.CREDIT_SCORE
import com.ijikod.mycreditscore.common.DEFAULTED_STATUS
import com.ijikod.mycreditscore.common.USED_CREDIT_PERCENTAGE
import com.ijikod.mycreditscore.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
@HiltAndroidTest
class CreditDetailFragmentTest {

    lateinit var fragmentArgs: Bundle

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun init() {
        // Populate @Inject fields in test class
        hiltRule.inject()

         fragmentArgs = bundleOf(CLIENT_REF to "1234", DEFAULTED_STATUS to false,
            USED_CREDIT_PERCENTAGE to "55", CREDIT_SCORE to "300/700")

        launchAllCreditScoreDetailFragment(fragmentArgs)
    }

    private val navController = TestNavHostController(ApplicationProvider.getApplicationContext())


    @Test
    fun givenArgumentsArePassedToDetailsFragmentCreditClientRefIsShown() {
        Espresso.onView(withId(R.id.client_ref_txt))
            .check(
                ViewAssertions.matches(
                    Matchers.allOf(
                        ViewMatchers.isDisplayed(),
                        ViewMatchers.withText("Client Ref: 1234")
                    )
                )
            )
    }


    @Test
    fun givenArgumentsArePassedToDetailsFragmentHasEverDefaultedIsShown(){
        Espresso.onView(withId(R.id.defaulted_txt))
            .check(
                ViewAssertions.matches(
                    Matchers.allOf(
                        ViewMatchers.isDisplayed(),
                        ViewMatchers.withText("Ever Defaulted: false")
                    )
                )
            )
    }

    @Test
    fun givenArgumentsArePassedToDetailsFragmentCreditScoreIsShown() {
        Espresso.onView(withId(R.id.detail_score_txt))
            .check(
                ViewAssertions.matches(
                    Matchers.allOf(
                        ViewMatchers.isDisplayed(),
                        ViewMatchers.withText("Credit Score: 300/700")
                    )
                )
            )
    }


    @Test
    fun givenArgumentsArePassedToDetailsFragmentPercentageUsedCreditIsShown() {
        Espresso.onView(withId(R.id.credit_used_txt))
            .check(
                ViewAssertions.matches(
                    Matchers.allOf(
                        ViewMatchers.isDisplayed(),
                        ViewMatchers.withText("Percentage Credit Used: 55")
                    )
                )
            )
    }



    private fun launchAllCreditScoreDetailFragment(args: Bundle) {
        launchFragmentInHiltContainer<CreditDetailFragment>(args) {
            navController.setGraph(R.navigation.nav_graph)
            navController.setCurrentDestination(R.id.creditDetailFragment)
            this.viewLifecycleOwnerLiveData.observeForever { viewLifecycleOwner ->
                if (viewLifecycleOwner != null) {
                    // The fragment’s view has just been created
                    Navigation.setViewNavController(this.requireView(), navController)
                }
            }
        }
    }
}