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

import android.util.Log;
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
public class CollegeDeanMessageTestByYao {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void collegeDeanMessageTestByYao() {
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
                allOf(withContentDescription("院长寄语"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabLayout_add),
                                        0),
                                4),
                        isDisplayed()));
        tabView2.perform(click());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.edit_text_dean), withText("尊敬的研究生考生：\n欢迎您考虑选择暨南大学作为您深造的学府。作为一所历史悠久、享有盛誉的高等学府，暨大一直以培养卓越人才、追求学术卓越为己任。\n在暨南大学，您将有机会接受世界一流的学术教育，融入充满活力和创新精神的学术氛围。我们的教师团队由一批具有丰富经验和专业知识的学者组成，他们将为您提供悉心指导和学术支持，助您在学术道路上不断前行。\n此外，暨大拥有先进的教学设施和丰富的学术资源，为您提供一个广阔的学术舞台，让您的学术梦想得以实现。我们鼓励学生勇攀学术高峰，培养创新意识和实践能力，助您成为未来的学术领袖和社会栋梁。\n无论您选择攻读哪个领域的研究生课程，暨南大学将竭诚为您提供全方位的支持和帮助，让您在这里获得学术成就的喜悦和人生成长的收获。\n希望您能抓住这个难得的机会，选择暨南大学作为您学术生涯的启航之地。期待您的加入，与我们一同开启知识的征程，共同书写美好的未来！\n院长 谨上"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.FrameLayout")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("123尊敬的研究生考生：\n欢迎您考虑选择暨南大学作为您深造的学府。作为一所历史悠久、享有盛誉的高等学府，暨大一直以培养卓越人才、追求学术卓越为己任。\n在暨南大学，您将有机会接受世界一流的学术教育，融入充满活力和创新精神的学术氛围。我们的教师团队由一批具有丰富经验和专业知识的学者组成，他们将为您提供悉心指导和学术支持，助您在学术道路上不断前行。\n此外，暨大拥有先进的教学设施和丰富的学术资源，为您提供一个广阔的学术舞台，让您的学术梦想得以实现。我们鼓励学生勇攀学术高峰，培养创新意识和实践能力，助您成为未来的学术领袖和社会栋梁。\n无论您选择攻读哪个领域的研究生课程，暨南大学将竭诚为您提供全方位的支持和帮助，让您在这里获得学术成就的喜悦和人生成长的收获。\n希望您能抓住这个难得的机会，选择暨南大学作为您学术生涯的启航之地。期待您的加入，与我们一同开启知识的征程，共同书写美好的未来！\n院长 谨上"));

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.edit_text_dean), withText("123尊敬的研究生考生：\n欢迎您考虑选择暨南大学作为您深造的学府。作为一所历史悠久、享有盛誉的高等学府，暨大一直以培养卓越人才、追求学术卓越为己任。\n在暨南大学，您将有机会接受世界一流的学术教育，融入充满活力和创新精神的学术氛围。我们的教师团队由一批具有丰富经验和专业知识的学者组成，他们将为您提供悉心指导和学术支持，助您在学术道路上不断前行。\n此外，暨大拥有先进的教学设施和丰富的学术资源，为您提供一个广阔的学术舞台，让您的学术梦想得以实现。我们鼓励学生勇攀学术高峰，培养创新意识和实践能力，助您成为未来的学术领袖和社会栋梁。\n无论您选择攻读哪个领域的研究生课程，暨南大学将竭诚为您提供全方位的支持和帮助，让您在这里获得学术成就的喜悦和人生成长的收获。\n希望您能抓住这个难得的机会，选择暨南大学作为您学术生涯的启航之地。期待您的加入，与我们一同开启知识的征程，共同书写美好的未来！\n院长 谨上"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.FrameLayout")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText4.perform(closeSoftKeyboard());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.button_save001), withText("保存"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.FrameLayout")),
                                        0),
                                0),
                        isDisplayed()));
        materialButton2.check(matches(withText("保存")));
        materialButton2.check(matches(isDisplayed()));
        materialButton2.check(matches(withId(R.id.button_save001)));

        Log.e("MyAppTag", "没有错误");
        materialButton2.perform(click());

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
                allOf(withContentDescription("院长寄语"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabLayout),
                                        0),
                                4),
                        isDisplayed()));
        tabView3.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.text_view_dean_message), withText("123尊敬的研究生考生：\n欢迎您考虑选择暨南大学作为您深造的学府。作为一所历史悠久、享有盛誉的高等学府，暨大一直以培养卓越人才、追求学术卓越为己任。\n在暨南大学，您将有机会接受世界一流的学术教育，融入充满活力和创新精神的学术氛围。我们的教师团队由一批具有丰富经验和专业知识的学者组成，他们将为您提供悉心指导和学术支持，助您在学术道路上不断前行。\n此外，暨大拥有先进的教学设施和丰富的学术资源，为您提供一个广阔的学术舞台，让您的学术梦想得以实现。我们鼓励学生勇攀学术高峰，培养创新意识和实践能力，助您成为未来的学术领袖和社会栋梁。\n无论您选择攻读哪个领域的研究生课程，暨南大学将竭诚为您提供全方位的支持和帮助，让您在这里获得学术成就的喜悦和人生成长的收获。\n希望您能抓住这个难得的机会，选择暨南大学作为您学术生涯的启航之地。期待您的加入，与我们一同开启知识的征程，共同书写美好的未来！\n院长 谨上"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class))),
                        isDisplayed()));
        textView.check(matches(withText("123尊敬的研究生考生： 欢迎您考虑选择暨南大学作为您深造的学府。作为一所历史悠久、享有盛誉的高等学府，暨大一直以培养卓越人才、追求学术卓越为己任。 在暨南大学，您将有机会接受世界一流的学术教育，融入充满活力和创新精神的学术氛围。我们的教师团队由一批具有丰富经验和专业知识的学者组成，他们将为您提供悉心指导和学术支持，助您在学术道路上不断前行。 此外，暨大拥有先进的教学设施和丰富的学术资源，为您提供一个广阔的学术舞台，让您的学术梦想得以实现。我们鼓励学生勇攀学术高峰，培养创新意识和实践能力，助您成为未来的学术领袖和社会栋梁。 无论您选择攻读哪个领域的研究生课程，暨南大学将竭诚为您提供全方位的支持和帮助，让您在这里获得学术成就的喜悦和人生成长的收获。 希望您能抓住这个难得的机会，选择暨南大学作为您学术生涯的启航之地。期待您的加入，与我们一同开启知识的征程，共同书写美好的未来！ 院长 谨上")));
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
