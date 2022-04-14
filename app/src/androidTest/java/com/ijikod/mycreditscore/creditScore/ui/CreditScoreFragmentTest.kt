package com.ijikod.mycreditscore.creditScore.ui

import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.ijikod.mycreditscore.R
import com.ijikod.mycreditscore.first
import com.ijikod.mycreditscore.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
@HiltAndroidTest
class CreditScoreFragmentTest{

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun init() {
        // Populate @Inject fields in test class
        hiltRule.inject()
    }

    private val navController = TestNavHostController(ApplicationProvider.getApplicationContext())


    @Test
    fun givenCreditScoreFragmentIsDisplayedIsProgressBarVisible() {
        launchCreditScoreFragment()
        Espresso.onView(first(withId(R.id.loading_progress))).check(ViewAssertions.matches(isDisplayed()))
    }



    private fun launchCreditScoreFragment() {
        launchFragmentInHiltContainer<CreditScoreFragment>() {
            navController.setGraph(R.navigation.nav_graph)
            navController.setCurrentDestination(R.id.creditScore)
            this.viewLifecycleOwnerLiveData.observeForever { viewLifecycleOwner ->
                if (viewLifecycleOwner != null) {
                    // The fragment’s view has just been created
                    Navigation.setViewNavController(this.requireView(), navController)
                }
            }
        }
    }


}