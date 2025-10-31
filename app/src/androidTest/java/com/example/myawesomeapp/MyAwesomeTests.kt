package com.example.myawesomeapp

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeDown
import androidx.test.espresso.action.ViewActions.swipeRight
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isChecked
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.core.AllOf.allOf
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import android.view.View
import com.example.myawesomeapp.element.mainScreenElements
import com.example.myawesomeapp.element.mainScreenGallery
import com.example.myawesomeapp.step.openMenu
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import com.example.myawesomeapp.step.openHome
import com.example.myawesomeapp.step.openGallery
import com.example.myawesomeapp.step.checkMenu
import com.example.myawesomeapp.element.menuElements

@RunWith(AndroidJUnit4::class)
class MyAwesomeTests {
    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setup() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    fun withIndex(matcher: Matcher<View>, index: Int): Matcher<View> {
        var currentIndex = 0
        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("with index $index: ")
                matcher.describeTo(description)
            }

            override fun matchesSafely(view: View): Boolean {
                if (matcher.matches(view)) {
                    if (currentIndex == index) {
                        currentIndex++
                        return true
                    }
                    currentIndex++
                }
                return false
            }
        }
    }



    @Test
    fun checkMainScreen() {
        mainScreenElements().mainScreenText().check(matches(isDisplayed()))
    }

    @Test
    fun checkSlideshowScreen() {
        openMenu()
        onView(withId(R.id.nav_slideshow)).perform(click())
        mainScreenElements().mainSlideshowText().check(matches(isDisplayed()))
        onView(withText("This is slideshow Fragment")).check(matches(isDisplayed()))
    }

    @Test
    fun checkMenuScreen() {
        checkMenu()
        mainScreenElements().mainToolbarText().check(matches(isDisplayed()))
        onView(withContentDescription("More options")).check(matches(isDisplayed()))
        openMenu()
        onView(withId(R.id.imageView)).check(matches(isDisplayed()))
        onView(withText("android.studio@android.com")).check(matches(isDisplayed()))
        onView(withId(R.id.textView)).check(matches(isDisplayed()))
        menuElements().menuNavHome().check(matches(isDisplayed()))
        onView(withText("Gallery")).check(matches(isDisplayed()))
        onView(withText("Slideshow")).check(matches(isDisplayed()))
        openHome()
        onView(withText("This is home Fragment")).check(matches(isDisplayed()))
    }

    @Test
    fun checkFab() {
        onView(withId(R.id.fab)).check(matches(isDisplayed()))
        onView(withId(R.id.fab)).perform(click())
        onView(withId(com.google.android.material.R.id.snackbar_text)).check(matches(isDisplayed()))
        onView(withId(com.google.android.material.R.id.snackbar_text)).perform(swipeRight())
        Thread.sleep(1000)
        onView(withId(com.google.android.material.R.id.snackbar_text)).check(doesNotExist())
    }

    @Test
    fun checkGalleryScreen() {
        openMenu()
        openGallery()
        mainScreenGallery().mainGallery().check(matches(isChecked()))
        Thread.sleep(1000)
        mainScreenGallery().mainGalleryToolbar().check(matches(isDisplayed()))
        onView(withId(R.id.recycle_view)).check(matches(isDisplayed()))
        onView(withIndex(withId(R.id.item_title), 0)).perform(click())
        onView(withId(com.google.android.material.R.id.snackbar_text)).check(matches(isDisplayed()))
        onView(withId(R.id.recycle_view)).perform(swipeDown())
        onView(withIndex(withId(R.id.item_title), 6)).perform(click())
        onView(withId(com.google.android.material.R.id.snackbar_text)).check(matches(isDisplayed()))
    }

        @After
    fun tearDown() {
        scenario.close()
    }
}