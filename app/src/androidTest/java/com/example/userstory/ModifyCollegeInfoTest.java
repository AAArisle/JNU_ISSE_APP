package com.example.userstory;


import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ModifyCollegeInfoTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void modifyCollegeInfoTest2() {
        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.menu_my), withContentDescription("我的"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.bottom_navi_view),
                                        0),
                                3),
                        isDisplayed()));
        bottomNavigationItemView.perform(click());

        DataInteraction materialTextView = onData(anything())
                .inAdapterView(allOf(withId(R.id.optionsListView),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                7)))
                .atPosition(2);
        materialTextView.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.usernameEditText),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.custom),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("name"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.passwordEditText),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.custom),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("pwd"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(
                allOf(withId(android.R.id.button1), withText("登录"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        materialButton.perform(scrollTo(), click());

        ViewInteraction tabView = onView(
                allOf(withContentDescription("学院信息"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tab_layout),
                                        0),
                                2),
                        isDisplayed()));
        tabView.perform(click());

        ViewInteraction tabView2 = onView(
                allOf(withContentDescription("学院领导"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabLayout_add),
                                        0),
                                1),
                        isDisplayed()));
        tabView2.perform(click());

        ViewInteraction materialTextView2 = onView(
                allOf(withId(R.id.text_view_leader_ship_add), withText("杨光华：院长，负责学院全面工作；分管行政、人事、财务、高水平大学建设等工作；联系物联网与物流工程研究院。\n\n周玉宇：党总支书记，负责学院党总支全面工作；分管党建、思政、意识形态、干部、宣传、监察、安全、保密、统战、工会等工作。\n\n陈韶鹏：党总支副书记，分管学生工作、信息化、竞赛基地、校友等工作。\n\n施政：副院长，分管学科建设、科研、研究生教育、高级研修班、产学研合作平台、国际交流与合作等工作。\n\n闫勉：副院长，分管本科教育、教师教学培训、实验室、实习/实践平台与基地、人工智能产业学院建设等工作。\n\n"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                1)));
        materialTextView2.perform(scrollTo(), click());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.edit_leadership_add), withText("杨光华：院长，负责学院全面工作；分管行政、人事、财务、高水平大学建设等工作；联系物联网与物流工程研究院。\n\n周玉宇：党总支书记，负责学院党总支全面工作；分管党建、思政、意识形态、干部、宣传、监察、安全、保密、统战、工会等工作。\n\n陈韶鹏：党总支副书记，分管学生工作、信息化、竞赛基地、校友等工作。\n\n施政：副院长，分管学科建设、科研、研究生教育、高级研修班、产学研合作平台、国际交流与合作等工作。\n\n闫勉：副院长，分管本科教育、教师教学培训、实验室、实习/实践平台与基地、人工智能产业学院建设等工作。\n\n"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                2)));
        appCompatEditText3.perform(replaceText("111杨光华：院长，负责学院全面工作；分管行政、人事、财务、高水平大学建设等工作；联系物联网与物流工程研究院。\n\n周玉宇：党总支书记，负责学院党总支全面工作；分管党建、思政、意识形态、干部、宣传、监察、安全、保密、统战、工会等工作。\n\n陈韶鹏：党总支副书记，分管学生工作、信息化、竞赛基地、校友等工作。\n\n施政：副院长，分管学科建设、科研、研究生教育、高级研修班、产学研合作平台、国际交流与合作等工作。\n\n闫勉：副院长，分管本科教育、教师教学培训、实验室、实习/实践平台与基地、人工智能产业学院建设等工作。\n\n"));

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.edit_leadership_add), withText("111杨光华：院长，负责学院全面工作；分管行政、人事、财务、高水平大学建设等工作；联系物联网与物流工程研究院。\n\n周玉宇：党总支书记，负责学院党总支全面工作；分管党建、思政、意识形态、干部、宣传、监察、安全、保密、统战、工会等工作。\n\n陈韶鹏：党总支副书记，分管学生工作、信息化、竞赛基地、校友等工作。\n\n施政：副院长，分管学科建设、科研、研究生教育、高级研修班、产学研合作平台、国际交流与合作等工作。\n\n闫勉：副院长，分管本科教育、教师教学培训、实验室、实习/实践平台与基地、人工智能产业学院建设等工作。\n\n"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText4.perform(closeSoftKeyboard());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.button_save2), withText("保存"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                0)));
        materialButton2.perform(scrollTo(), click());

        ViewInteraction materialButton3 = onView(
                allOf(withId(R.id.exit_admin_mode_button), withText("退出管理员模式"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        materialButton3.perform(click());

        ViewInteraction bottomNavigationItemView2 = onView(
                allOf(withId(R.id.menu_college), withContentDescription("学院"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.bottom_navi_view),
                                        0),
                                2),
                        isDisplayed()));
        bottomNavigationItemView2.perform(click());

        ViewInteraction tabView3 = onView(
                allOf(withContentDescription("学院领导"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabLayout),
                                        0),
                                1),
                        isDisplayed()));
        tabView3.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.text_view_leader_ship), withText("111杨光华：院长，负责学院全面工作；分管行政、人事、财务、高水平大学建设等工作；联系物联网与物流工程研究院。\n\n周玉宇：党总支书记，负责学院党总支全面工作；分管党建、思政、意识形态、干部、宣传、监察、安全、保密、统战、工会等工作。\n\n陈韶鹏：党总支副书记，分管学生工作、信息化、竞赛基地、校友等工作。\n\n施政：副院长，分管学科建设、科研、研究生教育、高级研修班、产学研合作平台、国际交流与合作等工作。\n\n闫勉：副院长，分管本科教育、教师教学培训、实验室、实习/实践平台与基地、人工智能产业学院建设等工作。\n\n"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class))),
                        isDisplayed()));
        textView.check(matches(withText("111杨光华：院长，负责学院全面工作；分管行政、人事、财务、高水平大学建设等工作；联系物联网与物流工程研究院。\n\n周玉宇：党总支书记，负责学院党总支全面工作；分管党建、思政、意识形态、干部、宣传、监察、安全、保密、统战、工会等工作。\n\n陈韶鹏：党总支副书记，分管学生工作、信息化、竞赛基地、校友等工作。\n\n施政：副院长，分管学科建设、科研、研究生教育、高级研修班、产学研合作平台、国际交流与合作等工作。\n\n闫勉：副院长，分管本科教育、教师教学培训、实验室、实习/实践平台与基地、人工智能产业学院建设等工作。\n\n")));
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
