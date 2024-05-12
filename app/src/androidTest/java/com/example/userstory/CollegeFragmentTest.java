package com.example.userstory;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.junit.Assert.assertNotNull;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

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
public class CollegeFragmentTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void collegeFragmentTest() {
        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.menu_college), withContentDescription("学院"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.bottom_navi_view),
                                        0),
                                2),
                        isDisplayed()));
        bottomNavigationItemView.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.text_view_college_intro), withText("    暨南大学是中国第一所由政府创办的华侨学府。学校前身是1906年清政府创立于南京的暨南学堂。1996年6月，暨南大学成为全国面向21世纪重点建设的大学。2011年4月，国务院侨办、教育部、广东省政府签署共建暨南大学协议。2015年6月，学校入选广东省高水平大学重点建设高校。2017年9月，学校入选国家“双一流”建设高校。智能科学与工程学院是学校高水平大学建设重点发展的学院之一，位于暨南大学珠海校区，毗邻港澳，交通便利。学院前身电气信息学院是我校8个入选ESI前百分之一学科“工程学”的主要支撑学院之一。借高水平和“双一流”大学建设契机，学院以学科建设为龙头、人才队伍建设为基石、科学研究和人才培养为两翼，在高层次人才引进和人才工程、高水平科研成果、标志性项目获取等方面取得了飞速发展。\n\n    学院围绕智能传感、智能计算和智能应用三个主要的智能技术领域，建立了电子信息与物联网、计算机技术、工业工程3个专业教研室和数学1个公共课教研室。现有教职员工58人（含港澳3人），其中专任教师38人（有海外学历背景者16人），包括正高6人、副高17人；博士生导师5人、硕士生导师21人。学院拥有国家杰出青年基金获得者1人、国家科技部国际杰青1人、教育部霍英东教育金会青年教师奖获得者1人、广东省科技合作奖获得者1人、“广东特支计划”本土创新创业团队1个、“广东特支计划”青年拔尖人才1人、广东珠江人才计划入选者1人、广州市创新领军团队1个，其他省级人才工程和奖励入选者十余人。\n\n    学院现设有物联网工程、人工智能、工业工程3个本科专业，其中物联网工程为广东省特色专业，目前学院在读全日制本科学生1200余人。在学科与研究生培养方面，人工智能是学院的重点发展学科，目前拥有“人工智能”二级学科博士、硕士科学学位授权点和 “电子信息”（人工智能方向）专业硕士授权点；已形成本硕博一体化、科学学位与专业学位并重的人才培养体系。增设物流工程与管理专业学位授权点，实现工程管理专业硕士未来在广州校区和珠海校区的错位发展。\n\n    学院教师近年来获批各类项目71项，其中，国家级12项，省部级16项，横向28项，涵盖国家重点研发计划项目、国家自然科学基金、广东省“特支计划”本土创新创业团队、广州市创新领军团队等重大项目，获批经费高达5207万左右。近几年，学院教师论文年均发表数量屡创新高，2018年底，学院在全校“ESI工程学”学科发文量排名第3。近五年来，学院教师以第一作者或通讯作者发表论文192篇（含已收录待刊论文），其中，SCI论文140余篇。学院在积极开展科学研究的同时，潜心抓教学、精心育成果，不断提升教学质量，完成各类质量工程的申报、建设与验收工作，共获得国家级教改项目1项、省级教改项目10余项。\n\n    学院积极开展第二课堂教育活动，注重培养学生的实践能力和创新能力，建立了信息安全基地、电子设计基地和程序设计基地3个课外实践教学基地，为学生提供丰富多彩的课外实践机会。在学院教师的悉心指导下，学生踊跃通过各基地参加各项比赛，在广东省大学生程序设计竞赛中获奖10项；在全国大学生电子设计竞赛中获奖9项，其中省一等奖1项；在“挑战杯”大学生课外学术科技作品竞赛中，获奖5项；在信息安全铁人三项赛中获奖4项，其中国家二等奖1项，华南赛区一等奖1项，华南赛区二等奖2项；在“蓝盾杯”网络空间安全竞赛中获奖1项；在全国大学生网络安全邀请赛暨第三届上海市大学生网络安全大赛中获奖1项；在广东省“强网杯”网络安全挑战赛中，获一等奖2项；在“世安杯”广东省大学生网络安全大赛中获奖4项，其中一等奖2项；在红帽杯网络安全攻防大赛中获奖1项。此外，在大学生创新创业训练计划项目中，24个项目获得国家级立项，34个项目获得省级立项。为提高本科生创业就业竞争能力，我院还与珠海市人力资源中心联合启动了大学生职业能力提升计划。本科生就业率高，超出学校平均水平。\n\n    智能科学与工程学院现处于飞速发展阶段，在未来日子里，学院将抓住机遇、迎接挑战，为实现更高目标而不断奋斗。"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class))),
                        isDisplayed()));
        textView.check(matches(withText("    暨南大学是中国第一所由政府创办的华侨学府。学校前身是1906年清政府创立于南京的暨南学堂。1996年6月，暨南大学成为全国面向21世纪重点建设的大学。2011年4月，国务院侨办、教育部、广东省政府签署共建暨南大学协议。2015年6月，学校入选广东省高水平大学重点建设高校。2017年9月，学校入选国家“双一流”建设高校。智能科学与工程学院是学校高水平大学建设重点发展的学院之一，位于暨南大学珠海校区，毗邻港澳，交通便利。学院前身电气信息学院是我校8个入选ESI前百分之一学科“工程学”的主要支撑学院之一。借高水平和“双一流”大学建设契机，学院以学科建设为龙头、人才队伍建设为基石、科学研究和人才培养为两翼，在高层次人才引进和人才工程、高水平科研成果、标志性项目获取等方面取得了飞速发展。\n\n    学院围绕智能传感、智能计算和智能应用三个主要的智能技术领域，建立了电子信息与物联网、计算机技术、工业工程3个专业教研室和数学1个公共课教研室。现有教职员工58人（含港澳3人），其中专任教师38人（有海外学历背景者16人），包括正高6人、副高17人；博士生导师5人、硕士生导师21人。学院拥有国家杰出青年基金获得者1人、国家科技部国际杰青1人、教育部霍英东教育金会青年教师奖获得者1人、广东省科技合作奖获得者1人、“广东特支计划”本土创新创业团队1个、“广东特支计划”青年拔尖人才1人、广东珠江人才计划入选者1人、广州市创新领军团队1个，其他省级人才工程和奖励入选者十余人。\n\n    学院现设有物联网工程、人工智能、工业工程3个本科专业，其中物联网工程为广东省特色专业，目前学院在读全日制本科学生1200余人。在学科与研究生培养方面，人工智能是学院的重点发展学科，目前拥有“人工智能”二级学科博士、硕士科学学位授权点和 “电子信息”（人工智能方向）专业硕士授权点；已形成本硕博一体化、科学学位与专业学位并重的人才培养体系。增设物流工程与管理专业学位授权点，实现工程管理专业硕士未来在广州校区和珠海校区的错位发展。\n\n    学院教师近年来获批各类项目71项，其中，国家级12项，省部级16项，横向28项，涵盖国家重点研发计划项目、国家自然科学基金、广东省“特支计划”本土创新创业团队、广州市创新领军团队等重大项目，获批经费高达5207万左右。近几年，学院教师论文年均发表数量屡创新高，2018年底，学院在全校“ESI工程学”学科发文量排名第3。近五年来，学院教师以第一作者或通讯作者发表论文192篇（含已收录待刊论文），其中，SCI论文140余篇。学院在积极开展科学研究的同时，潜心抓教学、精心育成果，不断提升教学质量，完成各类质量工程的申报、建设与验收工作，共获得国家级教改项目1项、省级教改项目10余项。\n\n    学院积极开展第二课堂教育活动，注重培养学生的实践能力和创新能力，建立了信息安全基地、电子设计基地和程序设计基地3个课外实践教学基地，为学生提供丰富多彩的课外实践机会。在学院教师的悉心指导下，学生踊跃通过各基地参加各项比赛，在广东省大学生程序设计竞赛中获奖10项；在全国大学生电子设计竞赛中获奖9项，其中省一等奖1项；在“挑战杯”大学生课外学术科技作品竞赛中，获奖5项；在信息安全铁人三项赛中获奖4项，其中国家二等奖1项，华南赛区一等奖1项，华南赛区二等奖2项；在“蓝盾杯”网络空间安全竞赛中获奖1项；在全国大学生网络安全邀请赛暨第三届上海市大学生网络安全大赛中获奖1项；在广东省“强网杯”网络安全挑战赛中，获一等奖2项；在“世安杯”广东省大学生网络安全大赛中获奖4项，其中一等奖2项；在红帽杯网络安全攻防大赛中获奖1项。此外，在大学生创新创业训练计划项目中，24个项目获得国家级立项，34个项目获得省级立项。为提高本科生创业就业竞争能力，我院还与珠海市人力资源中心联合启动了大学生职业能力提升计划。本科生就业率高，超出学校平均水平。\n\n    智能科学与工程学院现处于飞速发展阶段，在未来日子里，学院将抓住机遇、迎接挑战，为实现更高目标而不断奋斗。")));

        ViewInteraction tabView = onView(
                allOf(withContentDescription("学院领导"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabLayout),
                                        0),
                                1),
                        isDisplayed()));
        tabView.perform(click());

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.text_view_leader_ship), withText("\n\n杨光华：院长，负责学院全面工作；分管行政、人事、财务、高水平大学建设等工作；联系物联网与物流工程研究院。\n\n周玉宇：党总支书记，负责学院党总支全面工作；分管党建、思政、意识形态、干部、宣传、监察、安全、保密、统战、工会等工作。\n\n陈韶鹏：党总支副书记，分管学生工作、信息化、竞赛基地、校友等工作。\n\n施政：副院长，分管学科建设、科研、研究生教育、高级研修班、产学研合作平台、国际交流与合作等工作。\n\n闫勉：副院长，分管本科教育、教师教学培训、实验室、实习/实践平台与基地、人工智能产业学院建设等工作。"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class))),
                        isDisplayed()));
        textView2.check(matches(withText("\n\n杨光华：院长，负责学院全面工作；分管行政、人事、财务、高水平大学建设等工作；联系物联网与物流工程研究院。\n\n周玉宇：党总支书记，负责学院党总支全面工作；分管党建、思政、意识形态、干部、宣传、监察、安全、保密、统战、工会等工作。\n\n陈韶鹏：党总支副书记，分管学生工作、信息化、竞赛基地、校友等工作。\n\n施政：副院长，分管学科建设、科研、研究生教育、高级研修班、产学研合作平台、国际交流与合作等工作。\n\n闫勉：副院长，分管本科教育、教师教学培训、实验室、实习/实践平台与基地、人工智能产业学院建设等工作。")));

        ViewInteraction tabView2 = onView(
                allOf(withContentDescription("组织结构"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabLayout),
                                        0),
                                2),
                        isDisplayed()));
        tabView2.perform(click());

        ViewInteraction tableLayout = onView(
                allOf(withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class))),
                        isDisplayed()));
        assertNotNull(tableLayout);

        ViewInteraction tabView3 = onView(
                allOf(withContentDescription("学术委员会"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabLayout),
                                        0),
                                3),
                        isDisplayed()));
        tabView3.perform(click());

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.text_view_title), withText("关于成立智能科学与工程学院学术委员会的通知"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class))),
                        isDisplayed()));
        textView3.check(matches(withText("关于成立智能科学与工程学院学术委员会的通知")));

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.text_view_body), withText("学院各单位：\n　　根据《暨南大学关于推进学术委员会建设工作的指导意见》《暨南大学学术委员会章程》等文件，学院完成智能科学与工程学院学术委员会的组建工作，现将委员会名单公布如下：\n主　　　任：黄国全\n常务副主任：屈　挺\n副　主　任：孔　锐\n委　　　员：（按姓氏笔画顺序）\n吕广庆　刘晓翔　杨光华　徐素秀\n秘　　　书：刘煜琼　王晓红"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class))),
                        isDisplayed()));
        textView4.check(matches(withText("学院各单位：\n　　根据《暨南大学关于推进学术委员会建设工作的指导意见》《暨南大学学术委员会章程》等文件，学院完成智能科学与工程学院学术委员会的组建工作，现将委员会名单公布如下：\n主　　　任：黄国全\n常务副主任：屈　挺\n副　主　任：孔　锐\n委　　　员：（按姓氏笔画顺序）\n吕广庆　刘晓翔　杨光华　徐素秀\n秘　　　书：刘煜琼　王晓红")));

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.text_view_time), withText("\n\n智能科学与工程学院\n\n2019年7月11日"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class))),
                        isDisplayed()));
        textView5.check(matches(withText("\n\n智能科学与工程学院\n\n2019年7月11日")));

        ViewInteraction tabView5 = onView(
                allOf(withContentDescription("院长寄语"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabLayout),
                                        0),
                                4),
                        isDisplayed()));
        tabView5.perform(click());

        ViewInteraction textView6 = onView(
                allOf(withId(R.id.text_view_dean_message), withText("尊敬的研究生考生：\n欢迎您考虑选择暨南大学作为您深造的学府。作为一所历史悠久、享有盛誉的高等学府，暨大一直以培养卓越人才、追求学术卓越为己任。\n在暨南大学，您将有机会接受世界一流的学术教育，融入充满活力和创新精神的学术氛围。我们的教师团队由一批具有丰富经验和专业知识的学者组成，他们将为您提供悉心指导和学术支持，助您在学术道路上不断前行。\n此外，暨大拥有先进的教学设施和丰富的学术资源，为您提供一个广阔的学术舞台，让您的学术梦想得以实现。我们鼓励学生勇攀学术高峰，培养创新意识和实践能力，助您成为未来的学术领袖和社会栋梁。\n无论您选择攻读哪个领域的研究生课程，暨南大学将竭诚为您提供全方位的支持和帮助，让您在这里获得学术成就的喜悦和人生成长的收获。\n希望您能抓住这个难得的机会，选择暨南大学作为您学术生涯的启航之地。期待您的加入，与我们一同开启知识的征程，共同书写美好的未来！\n院长 谨上"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class))),
                        isDisplayed()));
        textView6.check(matches(withText("尊敬的研究生考生：\n欢迎您考虑选择暨南大学作为您深造的学府。作为一所历史悠久、享有盛誉的高等学府，暨大一直以培养卓越人才、追求学术卓越为己任。\n在暨南大学，您将有机会接受世界一流的学术教育，融入充满活力和创新精神的学术氛围。我们的教师团队由一批具有丰富经验和专业知识的学者组成，他们将为您提供悉心指导和学术支持，助您在学术道路上不断前行。\n此外，暨大拥有先进的教学设施和丰富的学术资源，为您提供一个广阔的学术舞台，让您的学术梦想得以实现。我们鼓励学生勇攀学术高峰，培养创新意识和实践能力，助您成为未来的学术领袖和社会栋梁。\n无论您选择攻读哪个领域的研究生课程，暨南大学将竭诚为您提供全方位的支持和帮助，让您在这里获得学术成就的喜悦和人生成长的收获。\n希望您能抓住这个难得的机会，选择暨南大学作为您学术生涯的启航之地。期待您的加入，与我们一同开启知识的征程，共同书写美好的未来！\n院长 谨上")));

        ViewInteraction tabView6 = onView(
                allOf(withContentDescription("联系我们"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabLayout),
                                        0),
                                5),
                        isDisplayed()));
        tabView6.perform(click());

        ViewInteraction textView7 = onView(
                allOf(withId(R.id.text_view_address), withText("地址：广东省珠海市香洲区前山路206号暨南大学行政楼6楼"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class))),
                        isDisplayed()));
        textView7.check(matches(withText("地址：广东省珠海市香洲区前山路206号暨南大学行政楼6楼")));

        ViewInteraction textView8 = onView(
                allOf(withId(R.id.text_view_telephone), withText("电话：0756-8505610"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class))),
                        isDisplayed()));
        textView8.check(matches(withText("电话：0756-8505610")));

        ViewInteraction textView9 = onView(
                allOf(withId(R.id.text_view_email), withText("邮箱：osisse@jnu.edu.cn"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class))),
                        isDisplayed()));
        textView9.check(matches(withText("邮箱：osisse@jnu.edu.cn")));
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
