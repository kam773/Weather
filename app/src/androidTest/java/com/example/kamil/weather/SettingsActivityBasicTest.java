package com.example.kamil.weather;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withTagKey;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Kamil on 2018-03-25.
 */
@RunWith(AndroidJUnit4.class)
public class SettingsActivityBasicTest {
    @Rule public ActivityTestRule<SettingsActivity> mActivityTestRule
            = new ActivityTestRule<>(SettingsActivity.class);


    @Test
    public void clickUnitsListPreference_ChangeTemperatureUnits(){


        onView(withText("Temperature Units")).perform(click());

        onView(withId(R.id.high_temperature)).check(matches(withText("\u2103")));
        onView(withId(R.id.high_temperature)).check(matches(withText("\u2109")));
    }


}



