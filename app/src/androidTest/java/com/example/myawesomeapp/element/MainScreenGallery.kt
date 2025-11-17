package com.example.myawesomeapp.element

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.myawesomeapp.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.AllOf.allOf

class mainScreenGallery {
    fun mainGallery(): ViewInteraction {
        return onView(
            allOf(
                withText("Gallery"),
                isDescendantOfA(withId(R.id.nav_gallery))
            )
        )
    }
    fun mainGalleryToolbar(): ViewInteraction {
        return onView(
            allOf(
                withText("Gallery"),
                withParent(withId(R.id.toolbar))
            )
        )
    }
    fun mainGalleryItem(): ViewInteraction {
        return onView(withIndex(withId(R.id.item_title), 0)
        )
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
    fun mainGalleryItemSix(): ViewInteraction {
        return onView(withIndex(withId(R.id.item_title), 6)
        )
    }
}