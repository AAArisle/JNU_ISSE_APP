// 【学院】院长寄语
package com.example.userstory.fragment.collegeInnerFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.userstory.R;

public class DeanMessageFragment extends Fragment {
    static public String message = null;

    public DeanMessageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dean_message, container, false);

        if (null == message) {
            message = "尊敬的研究生考生：\n" +
                    "欢迎您考虑选择暨南大学作为您深造的学府。作为一所历史悠久、享有盛誉的高等学府，暨大一直以培养卓越人才、追求学术卓越为己任。\n" +
                    "在暨南大学，您将有机会接受世界一流的学术教育，融入充满活力和创新精神的学术氛围。我们的教师团队由一批具有丰富经验和专业知识的学者组成，他们将为您提供悉心指导和学术支持，助您在学术道路上不断前行。\n" +
                    "此外，暨大拥有先进的教学设施和丰富的学术资源，为您提供一个广阔的学术舞台，让您的学术梦想得以实现。我们鼓励学生勇攀学术高峰，培养创新意识和实践能力，助您成为未来的学术领袖和社会栋梁。\n" +
                    "无论您选择攻读哪个领域的研究生课程，暨南大学将竭诚为您提供全方位的支持和帮助，让您在这里获得学术成就的喜悦和人生成长的收获。\n" +
                    "希望您能抓住这个难得的机会，选择暨南大学作为您学术生涯的启航之地。期待您的加入，与我们一同开启知识的征程，共同书写美好的未来！\n" +
                    "院长 谨上";
        }

        TextView textView = rootView.findViewById(R.id.text_view_dean_message);
        textView.setText(message);

        return rootView;
    }
}
