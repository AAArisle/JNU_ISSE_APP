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

import static com.example.userstory.fragment.collegeInnerFragment.AcademicCommitteeFragment.notice;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AdAcademicCommitteeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AdAcademicCommitteeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AdAcademicCommitteeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AdAcademicCommitteeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AdAcademicCommitteeFragment newInstance(String param1, String param2) {
        AdAcademicCommitteeFragment fragment = new AdAcademicCommitteeFragment();
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
        View rootView = inflater.inflate(R.layout.ad_fragment_academic_committee, container, false);

        Button buttonSave = rootView.findViewById(R.id.button_save);

        EditText edit_text_title = rootView.findViewById(R.id.edit_text_title);
        EditText edit_text_body = rootView.findViewById(R.id.edit_text_body);
        EditText edit_text_time = rootView.findViewById(R.id.edit_text_time);
        if(null==notice.getTitle()) {
            notice.setTitle("关于成立智能科学与工程学院学术委员会的通知");
            notice.setBody("学院各单位：\n" +
                    "　　根据《暨南大学关于推进学术委员会建设工作的指导意见》《暨南大学学术委员会章程》等文件，学院完成智能科学与工程学院学术委员会的组建工作，现将委员会名单公布如下：\n" +
                    "主　　　任：黄国全\n" +
                    "常务副主任：屈　挺\n" +
                    "副　主　任：孔　锐\n" +
                    "委　　　员：（按姓氏笔画顺序）\n" +
                    "吕广庆　刘晓翔　杨光华　徐素秀\n" +
                    "秘　　　书：刘煜琼　王晓红");
            notice.setTime("\n" +
                    "\n" +
                    "智能科学与工程学院\n" +
                    "\n" +
                    "2019年7月11日");

        }
        edit_text_title.setText(notice.getTitle());
        edit_text_body.setText(notice.getBody());
        edit_text_time.setText(notice.getTime());

        List<EditText> allEditTexts = new ArrayList<>();
        allEditTexts.add(rootView.findViewById(R.id.edit_text_title));
        allEditTexts.add(rootView.findViewById(R.id.edit_text_body));
        allEditTexts.add(rootView.findViewById(R.id.edit_text_time));

        // 创建一个OnFocusChangeListener
        View.OnFocusChangeListener showSaveButtonListener = (v, hasFocus) -> {
            if (hasFocus && v instanceof EditText) {
                // 在这里输入你的点击监听处理
                buttonSave.setVisibility(View.VISIBLE);
            }
        };

        // 为所有的EditText设置同一个监听器
        for (EditText editText : allEditTexts) {
            editText.setOnFocusChangeListener(showSaveButtonListener);
        }

        buttonSave.setOnClickListener(v -> {
            // 为所有的EditText设置同一个监听器
//            for (EditText editText : allEditTexts) {
//                String editedIntro = editText.getText().toString();
//                if (!TextUtils.isEmpty(editedIntro)) {
//                }
//            }
            notice.setTitle(edit_text_title.getText().toString());
            notice.setBody(edit_text_body.getText().toString());
            notice.setTime(edit_text_time.getText().toString());
            buttonSave.setVisibility(View.GONE);
            // 获取InputMethodManager
//            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            // 隐藏软键盘
//            imm.hideSoftInputFromWindow(collegeIntroEditText.getWindowToken(), 0);
        });

        return rootView;
    }
}