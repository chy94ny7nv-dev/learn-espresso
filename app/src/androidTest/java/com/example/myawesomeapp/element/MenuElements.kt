package com.example.myawesomeapp.element

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.myawesomeapp.R
import org.hamcrest.core.AllOf.allOf

class menuElements {
    fun menuNavHome(): ViewInteraction {
        return onView(
            allOf(
                withText("Home"),
                isDescendantOfA(withId(R.id.nav_view))
            )
        )
    }
    fun menuNavSlideshow(): ViewInteraction {
        return onView(withId(R.id.nav_slideshow)
            )
    }
    fun menuNavImage(): ViewInteraction {
        return onView(withId(R.id.imageView)
        )
    }
    fun menuNavMail(): ViewInteraction {
        return onView(withText("android.studio@android.com")
        )
    }
    fun menuNavName(): ViewInteraction {
        return onView(withId(R.id.textView)
        )
    }
}