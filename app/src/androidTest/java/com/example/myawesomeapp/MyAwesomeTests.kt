package com.example.myawesomeapp

import android.view.View
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isChecked
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myawesomeapp.element.mainScreenElements
import com.example.myawesomeapp.element.mainScreenGallery
import com.example.myawesomeapp.element.mainScreenSlideshow
import com.example.myawesomeapp.element.menuElements
import com.example.myawesomeapp.step.checkFabMain
import com.example.myawesomeapp.step.checkMenu
import com.example.myawesomeapp.step.checkRecycle
import com.example.myawesomeapp.step.checkSnackbar
import com.example.myawesomeapp.step.checkSnackbarText
import com.example.myawesomeapp.step.clickFabMain
import com.example.myawesomeapp.step.menuElementCheck
import com.example.myawesomeapp.step.openGallery
import com.example.myawesomeapp.step.openHome
import com.example.myawesomeapp.step.openMenu
import com.example.myawesomeapp.step.swipe
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


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
        menuElements().menuNavSlideshow().perform(click())
        mainScreenElements().mainSlideshowText().check(matches(isDisplayed()))
        mainScreenSlideshow().mainSlideshow().check(matches(isDisplayed()))
    }

    @Test
    fun checkMenuScreen() {
        checkMenu()
        mainScreenElements().mainToolbarText().check(matches(isDisplayed()))
        mainScreenElements().mainScreenOptions().check(matches(isDisplayed()))
        openMenu()
        menuElementCheck()
        openHome()
        mainScreenElements().mainScreenText().check(matches(isDisplayed()))
    }

    @Test
    fun checkFab() {
        checkFabMain()
        clickFabMain()
        checkSnackbar()
    }

    @Test
    fun checkGalleryScreen() {
        openMenu()
        openGallery()
        mainScreenGallery().mainGallery().check(matches(isChecked()))
        Thread.sleep(1000)
        mainScreenGallery().mainGalleryToolbar().check(matches(isDisplayed()))
        checkRecycle()
        mainScreenGallery().mainGalleryItem().perform(click())
        checkSnackbarText()
        swipe()
        mainScreenGallery().mainGalleryItemSix().perform(click())
        checkSnackbarText()
    }

        @After
    fun tearDown() {
        scenario.close()
    }
}