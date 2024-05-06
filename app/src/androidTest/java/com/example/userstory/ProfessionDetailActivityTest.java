package com.example.userstory;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Context;
import android.content.Intent;

import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.userstory.activity.ProfessionDetailActivity;

import org.junit.Test;
import org.junit.runner.RunWith;




@RunWith(AndroidJUnit4.class)
public class ProfessionDetailActivityTest {

    @Test
    public void testProfessionDetailsDisplayed() {
        Context context = ApplicationProvider.getApplicationContext();
        Intent intent = new Intent(context, ProfessionDetailActivity.class);
        intent.putExtra("professionName", "Computer Science");
        intent.putExtra("imageResId", R.drawable.avatar);  // Make sure R.drawable.avatar is a valid resource in your project

        try (ActivityScenario<ProfessionDetailActivity> scenario = ActivityScenario.launch(intent)) {
            onView(withId(R.id.imageView)).check(matches(isDisplayed()));
            onView(withId(R.id.textView)).check(matches(withText("Computer Science")));
        }
    }



    @Test
    public void testAdditionalTextDisplays() {
        Context context = ApplicationProvider.getApplicationContext();
        Intent intent = new Intent(context, ProfessionDetailActivity.class);
        try (ActivityScenario<ProfessionDetailActivity> scenario = ActivityScenario.launch(intent)) {
            onView(withId(R.id.textView2)).check(matches(withText("专业介绍")));
            onView(withId(R.id.textView3)).check(matches(withText("专业课程")));
            onView(withId(R.id.textView5)).check(matches(withText("申请条件")));
        }
    }

    @Test
    public void testImageLoading() {
        Context context = ApplicationProvider.getApplicationContext();
        Intent intent = new Intent(context, ProfessionDetailActivity.class);
        intent.putExtra("imageResId", R.drawable.avatar);
        try (ActivityScenario<ProfessionDetailActivity> scenario = ActivityScenario.launch(intent)) {
            onView(withId(R.id.imageView)).check(matches(isDisplayed()));
        }
    }
}
