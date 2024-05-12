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
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.userstory.activity.ProfessionDetailActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;




@RunWith(AndroidJUnit4.class)
public class ProfessionDetailActivityTest {

    @Test
    public void testProfessionDetails() {
        // 构建Intent并启动Activity
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Intent intent = new Intent(context, ProfessionDetailActivity.class);
        intent.putExtra("professionName", "Biology");
        intent.putExtra("imageResId", R.drawable.avatar);
        intent.putExtra("professionIntro", "Biology is about life.");
        intent.putExtra("professionCourses", "Courses cover genetics, etc.");
        intent.putExtra("professionRequirements", "Requirements include...");

        try (ActivityScenario<ProfessionDetailActivity> scenario = ActivityScenario.launch(intent)) {
            // 验证UI显示是否正确
            onView(withId(R.id.textView)).check(matches(withText("Biology")));
            onView(withId(R.id.intro_detail)).check(matches(withText("Biology is about life.")));
            onView(withId(R.id.course_detail)).check(matches(withText("Courses cover genetics, etc.")));
            onView(withId(R.id.requirements_detail)).check(matches(withText("Requirements include...")));
        }
    }
}