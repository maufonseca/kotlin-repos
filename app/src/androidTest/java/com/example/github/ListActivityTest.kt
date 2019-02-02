package com.example.github

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.swipeDown
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.github.presentation.ListActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class ListActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(ListActivity::class.java)

    @Test
    fun listActivityTest() {

        val recycler = onView(withId(R.id.rvRepositories))
        Thread.sleep(5000)
        recycler.perform(swipeUp())
        Thread.sleep(2000)
        recycler.perform(swipeDown())
        Thread.sleep(2000)
        recycler.check(matches(isDisplayed()))
    }
}
