package com.example.userstory;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.action.ViewActions.swipeDown;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class SupervisorListTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void supervisorListTest() {
        // 添加一些等待时间，以确保页面加载完成
        try {
            Thread.sleep(2000); // 2秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(allOf(withId(R.id.recycler_view),
                childAtPosition(
                        withClassName(is("android.widget.LinearLayout")),
                        1))).perform(swipeUp());

        // 添加一些等待时间，以确保页面滑动完成
        try {
            Thread.sleep(1000); // 2秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 模拟向下滑动页面
        onView(allOf(withId(R.id.recycler_view),
                childAtPosition(
                        withClassName(is("android.widget.LinearLayout")),
                        1))).perform(swipeDown());

        // 添加一些等待时间，以确保页面滑动完成
        try {
            Thread.sleep(1000); // 2秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
