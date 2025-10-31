package com.example.myawesomeapp.element

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.myawesomeapp.R
import org.hamcrest.core.AllOf.allOf

class mainScreenElements {
    fun mainSlideshowText(): ViewInteraction {
        return onView(
            allOf(
                withText("Slideshow"),
                withParent(withId(R.id.toolbar))
            )
        )
    }
    fun mainScreenText(): ViewInteraction {
        return onView(
            allOf(
                withId(R.id.text_home),
                withText("This is home Fragment")
            )
        )
    }
    fun mainToolbarText(): ViewInteraction {
        return onView(
        allOf(
            withText("Home"),
            withParent(withId(R.id.toolbar))
            )
        )
    }
}