package com.example.myawesomeapp.step

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeDown
import androidx.test.espresso.action.ViewActions.swipeRight
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.example.myawesomeapp.R

class MainScreenSteps {
    private val mainElement = MainScreenSteps()
}

fun openMenu() {
    onView(withContentDescription("Open navigation drawer")).perform(click())
}

fun checkMenu() {
    onView(withContentDescription("Open navigation drawer")).check(matches(isDisplayed()))
}

fun checkFabMain() {
    onView(withId(R.id.fab)).check(matches(isDisplayed()))
}

fun clickFabMain() {
    onView(withId(R.id.fab)).perform(click())
}

fun checkSnackbar() {
    onView(withId(com.google.android.material.R.id.snackbar_text)).check(matches(isDisplayed()))
    onView(withId(com.google.android.material.R.id.snackbar_text)).perform(swipeRight())
    Thread.sleep(1000)
    onView(withId(com.google.android.material.R.id.snackbar_text)).check(doesNotExist())
}

fun checkRecycle() {
    onView(withId(R.id.recycle_view)).check(matches(isDisplayed()))
}

fun selectItem() {
    onView(withId(R.id.recycle_view)).check(matches(isDisplayed()))
}

fun checkSnackbarText() {
    onView(withId(com.google.android.material.R.id.snackbar_text)).check(matches(isDisplayed()))
}

fun swipe() {
    onView(withId(R.id.recycle_view)).perform(swipeDown())
}