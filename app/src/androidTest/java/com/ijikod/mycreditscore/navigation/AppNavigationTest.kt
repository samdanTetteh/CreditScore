package com.ijikod.mycreditscore.navigation

import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.ijikod.mycreditscore.R
import com.ijikod.mycreditscore.creditScore.ui.CreditScoreFragment
import com.ijikod.mycreditscore.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
@HiltAndroidTest
class AppNavigationTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun init() {
        // Populate @Inject fields in test class
        hiltRule.inject()
    }


    private val navController = TestNavHostController(getApplicationContext())


    @Test
    fun givenApplicationIsLunchedNavigationIsCorrect() {
        // Launch fragment
        launchCreditScoreFragment()

        // Get current navigation
        val destination = navController.currentDestination

        assertEquals(destination?.id, R.id.creditScore)
    }



    private fun launchCreditScoreFragment() {
        launchFragmentInHiltContainer<CreditScoreFragment> {
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