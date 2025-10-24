package com.example.androiduitesting;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

@RunWith(AndroidJUnit4.class)
public class ShowActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    // ✅ Test 1 — Check whether the activity correctly switched
    @Test
    public void testActivitySwitch() {
        onView(withText("Edmonton")).perform(click());
        onView(withId(R.id.city_text)).check(matches(isDisplayed()));
    }

    // ✅ Test 2 — Check whether the city name is consistent
    @Test
    public void testCityNameConsistency() {
        onView(withText("Vancouver")).perform(click());
        onView(withId(R.id.city_text)).check(matches(withText("Vancouver")));
    }

    // ✅ Test 3 — Check whether the back button works
    @Test
    public void testBackButton() {
        onView(withText("Toronto")).perform(click());
        onView(withId(R.id.back_button)).perform(click());
        onView(withId(R.id.city_list)).check(matches(isDisplayed()));
    }
}
