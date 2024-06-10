package com.example.userstory.admin;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.userstory.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.userstory.fragment.collegeInnerFragment.DeanMessageFragment.message;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AdDeanMessageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AdDeanMessageFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AdDeanMessageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AdDeanMessageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AdDeanMessageFragment newInstance(String param1, String param2) {
        AdDeanMessageFragment fragment = new AdDeanMessageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.ad_fragment_dean_message, container, false);

        Button buttonSave = rootView.findViewById(R.id.button_save001);

        EditText edit_text_dean = rootView.findViewById(R.id.edit_text_dean);

        if (null == message) {
            message = "尊敬的研究生考生：\n" +
                    "欢迎您考虑选择暨南大学作为您深造的学府。作为一所历史悠久、享有盛誉的高等学府，暨大一直以培养卓越人才、追求学术卓越为己任。\n" +
                    "在暨南大学，您将有机会接受世界一流的学术教育，融入充满活力和创新精神的学术氛围。我们的教师团队由一批具有丰富经验和专业知识的学者组成，他们将为您提供悉心指导和学术支持，助您在学术道路上不断前行。\n" +
                    "此外，暨大拥有先进的教学设施和丰富的学术资源，为您提供一个广阔的学术舞台，让您的学术梦想得以实现。我们鼓励学生勇攀学术高峰，培养创新意识和实践能力，助您成为未来的学术领袖和社会栋梁。\n" +
                    "无论您选择攻读哪个领域的研究生课程，暨南大学将竭诚为您提供全方位的支持和帮助，让您在这里获得学术成就的喜悦和人生成长的收获。\n" +
                    "希望您能抓住这个难得的机会，选择暨南大学作为您学术生涯的启航之地。期待您的加入，与我们一同开启知识的征程，共同书写美好的未来！\n" +
                    "院长 谨上";
        }

        edit_text_dean.setText(message);

        List<EditText> allEditTexts = new ArrayList<>();
        allEditTexts.add(rootView.findViewById(R.id.edit_text_dean));

        // 创建一个OnFocusChangeListener
        View.OnFocusChangeListener showSaveButtonListener = (v, hasFocus) -> {
            if (hasFocus && v instanceof EditText) {
                // 在这里输入你的点击监听处理
                buttonSave.setVisibility(View.VISIBLE);
            }
        };

        // 为所有的EditText设置同一个监听器
        for (EditText editText : allEditTexts) {
//            editText.setText("你好！");
            editText.setOnFocusChangeListener(showSaveButtonListener);
        }

        buttonSave.setOnClickListener(v -> {
            // 为所有的EditText设置同一个监听器
            for (EditText editText : allEditTexts) {
                String editedIntro = editText.getText().toString();
                if (!TextUtils.isEmpty(editedIntro)) {
                    message = editedIntro;
                }
            }
//            buttonSave.setVisibility(View.GONE);
            // 获取InputMethodManager
//            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            // 隐藏软键盘
//            imm.hideSoftInputFromWindow(collegeIntroEditText.getWindowToken(), 0);
        });


        return rootView;
    }
}