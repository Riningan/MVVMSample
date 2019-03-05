package com.riningan.mvvmsample

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.riningan.mvvmsample.data.network.PokeClient
import com.riningan.mvvmsample.presentation.MainActivity
import com.riningan.mvvmsample.presentation.list.PokemonsAdapter
import okhttp3.mockwebserver.MockWebServer
import org.awaitility.Awaitility.await
import org.hamcrest.CoreMatchers.`is`
import org.junit.After
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.TimeUnit


@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get: Rule
    val mActivityTestRule = ActivityTestRule(MainActivity::class.java, true, true)

    private lateinit var mWebServer: MockWebServer


    @Before
    fun setUp() {
        mWebServer = MockWebServer()
        mWebServer.start(8080)
        mWebServer.setDispatcher(RequestDispatcher())
    }

    @After
    fun tearDown() {
        mWebServer.shutdown()
    }


    @Test
    fun test() {
        await().atMost(15, TimeUnit.SECONDS)
                .ignoreExceptions()
                .untilAsserted {
                    onView(withId(R.id.rvList)).check(matches(isDisplayed()))
                }
        await().atMost(20, TimeUnit.SECONDS)
                .ignoreExceptions()
                .untilAsserted {
                    onView(withId(R.id.rvList)).check(recyclerViewItemCountAssertion(20))
                }
        onView(withId(R.id.rvList))
                .perform(scrollToPosition<PokemonsAdapter.ViewHolder>(15))
        await().atMost(20, TimeUnit.SECONDS)
                .ignoreExceptions()
                .untilAsserted {
                    onView(withId(R.id.rvList)).check(recyclerViewItemCountAssertion(30))
                }
        onView(withId(R.id.rvList))
                .perform(actionOnItemAtPosition<PokemonsAdapter.ViewHolder>(0, click()))
        await().atMost(15, TimeUnit.SECONDS)
                .ignoreExceptions()
                .untilAsserted {
                    onView(withId(R.id.llDetails)).check(matches(isDisplayed()))
                }
        onView(withContentDescription(R.string.item_back)).perform(click())
        await().atMost(15, TimeUnit.SECONDS)
                .ignoreExceptions()
                .untilAsserted {
                    onView(withId(R.id.rvList)).check(matches(isDisplayed()))
                }
    }


    private fun recyclerViewItemCountAssertion(expectedCount: Int) =
            ViewAssertion { view, noViewFoundException ->
                if (noViewFoundException != null) {
                    throw noViewFoundException
                }
                val recyclerView = view as RecyclerView
                val adapter = recyclerView.adapter
                assertThat(adapter!!.itemCount, `is`(expectedCount))
            }


    companion object {
        init {
            PokeClient.URL = "http://localhost:8080"
        }
    }
}
