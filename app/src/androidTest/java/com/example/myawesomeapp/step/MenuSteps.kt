package com.example.myawesomeapp.step

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.myawesomeapp.R
import com.example.myawesomeapp.element.mainScreenGallery
import com.example.myawesomeapp.element.menuElements
import org.hamcrest.core.AllOf.allOf

class MenuSteps {
    private val menuElement = MainScreenSteps()
}

fun openHome() {
    onView(
        allOf(
            withText("Home"),
            isDescendantOfA(withId(R.id.nav_view))
        )
    ).perform(click())
}

fun openGallery() {
    onView(
        allOf(
            withText("Gallery"),
            isDescendantOfA(withId(R.id.nav_gallery))
        )
    ).perform(click())
}

fun menuElementCheck() {
    menuElements().menuNavImage().check(matches(isDisplayed()))
    menuElements().menuNavMail().check(matches(isDisplayed()))
    menuElements().menuNavName().check(matches(isDisplayed()))
    menuElements().menuNavHome().check(matches(isDisplayed()))
    mainScreenGallery().mainGallery().check(matches(isDisplayed()))
    menuElements().menuNavSlideshow().check(matches(isDisplayed()))
}