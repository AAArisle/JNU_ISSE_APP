package com.example.userstory.admin;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.userstory.R;
import com.example.userstory.fragment.collegeInnerFragment.CollegeIntroFragment;

public class AdCollegeIntroInfoFragment extends Fragment {
    private EditText collegeIntroEditText; // EditText for editing intro
    private Button saveButton; // Button to save edited intro

    public AdCollegeIntroInfoFragment() {
        // Required empty public constructor
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String init_intro = "    暨南大学是中国第一所由政府创办的华侨学府。学校前身是1906年清政府创立于南京的暨南学堂。1996年6月，暨南大学成为全国面向21世纪重点建设的大学。2011年4月，国务院侨办、教育部、广东省政府签署共建暨南大学协议。2015年6月，学校入选广东省高水平大学重点建设高校。2017年9月，学校入选国家“双一流”建设高校。智能科学与工程学院是学校高水平大学建设重点发展的学院之一，位于暨南大学珠海校区，毗邻港澳，交通便利。学院前身电气信息学院是我校8个入选ESI前百分之一学科“工程学”的主要支撑学院之一。借高水平和“双一流”大学建设契机，学院以学科建设为龙头、人才队伍建设为基石、科学研究和人才培养为两翼，在高层次人才引进和人才工程、高水平科研成果、标志性项目获取等方面取得了飞速发展。\n\n" +
                "    学院围绕智能传感、智能计算和智能应用三个主要的智能技术领域，建立了电子信息与物联网、计算机技术、工业工程3个专业教研室和数学1个公共课教研室。现有教职员工58人（含港澳3人），其中专任教师38人（有海外学历背景者16人），包括正高6人、副高17人；博士生导师5人、硕士生导师21人。学院拥有国家杰出青年基金获得者1人、国家科技部国际杰青1人、教育部霍英东教育金会青年教师奖获得者1人、广东省科技合作奖获得者1人、“广东特支计划”本土创新创业团队1个、“广东特支计划”青年拔尖人才1人、广东珠江人才计划入选者1人、广州市创新领军团队1个，其他省级人才工程和奖励入选者十余人。\n\n" +
                "    学院现设有物联网工程、人工智能、工业工程3个本科专业，其中物联网工程为广东省特色专业，目前学院在读全日制本科学生1200余人。在学科与研究生培养方面，人工智能是学院的重点发展学科，目前拥有“人工智能”二级学科博士、硕士科学学位授权点和 “电子信息”（人工智能方向）专业硕士授权点；已形成本硕博一体化、科学学位与专业学位并重的人才培养体系。增设物流工程与管理专业学位授权点，实现工程管理专业硕士未来在广州校区和珠海校区的错位发展。\n\n" +
                "    学院教师近年来获批各类项目71项，其中，国家级12项，省部级16项，横向28项，涵盖国家重点研发计划项目、国家自然科学基金、广东省“特支计划”本土创新创业团队、广州市创新领军团队等重大项目，获批经费高达5207万左右。近几年，学院教师论文年均发表数量屡创新高，2018年底，学院在全校“ESI工程学”学科发文量排名第3。近五年来，学院教师以第一作者或通讯作者发表论文192篇（含已收录待刊论文），其中，SCI论文140余篇。学院在积极开展科学研究的同时，潜心抓教学、精心育成果，不断提升教学质量，完成各类质量工程的申报、建设与验收工作，共获得国家级教改项目1项、省级教改项目10余项。\n\n" +
                "    学院积极开展第二课堂教育活动，注重培养学生的实践能力和创新能力，建立了信息安全基地、电子设计基地和程序设计基地3个课外实践教学基地，为学生提供丰富多彩的课外实践机会。在学院教师的悉心指导下，学生踊跃通过各基地参加各项比赛，在广东省大学生程序设计竞赛中获奖10项；在全国大学生电子设计竞赛中获奖9项，其中省一等奖1项；在“挑战杯”大学生课外学术科技作品竞赛中，获奖5项；在信息安全铁人三项赛中获奖4项，其中国家二等奖1项，华南赛区一等奖1项，华南赛区二等奖2项；在“蓝盾杯”网络空间安全竞赛中获奖1项；在全国大学生网络安全邀请赛暨第三届上海市大学生网络安全大赛中获奖1项；在广东省“强网杯”网络安全挑战赛中，获一等奖2项；在“世安杯”广东省大学生网络安全大赛中获奖4项，其中一等奖2项；在红帽杯网络安全攻防大赛中获奖1项。此外，在大学生创新创业训练计划项目中，24个项目获得国家级立项，34个项目获得省级立项。为提高本科生创业就业竞争能力，我院还与珠海市人力资源中心联合启动了大学生职业能力提升计划。本科生就业率高，超出学校平均水平。\n\n" +
                "    智能科学与工程学院现处于飞速发展阶段，在未来日子里，学院将抓住机遇、迎接挑战，为实现更高目标而不断奋斗。";

        View rootView = inflater.inflate(R.layout.ad_fragment_college_intro, container, false);

        TextView collegeIntro = rootView.findViewById(R.id.text_view_college_intro_add);
        EditText collegeIntroEditText = rootView.findViewById(R.id.edit_text_college_intro_add);
        Button buttonSave = rootView.findViewById(R.id.button_save);

        if(CollegeIntroFragment.intro==null)
        {collegeIntro.setText(init_intro);}
        else
            collegeIntro.setText(CollegeIntroFragment.intro);

        collegeIntro.setOnClickListener(v -> {
            collegeIntro.setVisibility(View.GONE);
            collegeIntroEditText.setVisibility(View.VISIBLE);
            buttonSave.setVisibility(View.VISIBLE);
            collegeIntroEditText.setText(collegeIntro.getText().toString());
            collegeIntroEditText.setEnabled(true);
            collegeIntroEditText.requestFocus();
        });

        buttonSave.setOnClickListener(v -> {
            String editedIntro = collegeIntroEditText.getText().toString();
            if (!TextUtils.isEmpty(editedIntro)) {
                String intro = editedIntro;
                collegeIntro.setText(intro);
                CollegeIntroFragment.intro = intro;
            }
            collegeIntroEditText.setVisibility(View.GONE);
            buttonSave.setVisibility(View.GONE);
            collegeIntro.setVisibility(View.VISIBLE);

            // 获取InputMethodManager
//            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            // 隐藏软键盘
//            imm.hideSoftInputFromWindow(collegeIntroEditText.getWindowToken(), 0);
        });

        return rootView;
    }
}

