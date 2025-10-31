package com.example.myawesomeapp.step

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription

class MainScreenSteps {
    private val mainElement = MainScreenSteps()
}

fun openMenu() {
    onView(withContentDescription("Open navigation drawer")).perform(click())
}

fun checkMenu() {
    onView(withContentDescription("Open navigation drawer")).check(matches(isDisplayed()))
}