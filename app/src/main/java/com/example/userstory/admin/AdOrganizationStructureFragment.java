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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AdOrganizationStructureFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AdOrganizationStructureFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AdOrganizationStructureFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AdOrganizationStructureFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AdOrganizationStructureFragment newInstance(String param1, String param2) {
        AdOrganizationStructureFragment fragment = new AdOrganizationStructureFragment();
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
        View rootView = inflater.inflate(R.layout.ad_fragmen_organization_structure, container, false);

        Button buttonSave = rootView.findViewById(R.id.button_save);
        List<EditText> allEditTexts = new ArrayList<>();

        // 将View转型为ViewGroup
        if (rootView instanceof ViewGroup) {
            // 将View转型为ViewGroup
            ViewGroup viewGroup = (ViewGroup) rootView;
            findAllEditTexts(viewGroup, allEditTexts);

            // 创建一个OnFocusChangeListener
            View.OnFocusChangeListener showSaveButtonListener = new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus && v instanceof EditText) {
                        buttonSave.setVisibility(View.VISIBLE);
                    }
                }
            };

            // 为所有的EditText设置同一个监听器
            for (EditText editText : allEditTexts) {
                editText.setOnFocusChangeListener(showSaveButtonListener);
            }

        } else {
            // rootView不是ViewGroup的实例，处理错误情况
        }

        buttonSave.setOnClickListener(v -> {
            // 为所有的EditText设置同一个监听器
            for (EditText editText : allEditTexts) {
                String editedIntro = editText.getText().toString();
                if (!TextUtils.isEmpty(editedIntro)) {
                }
            }
            buttonSave.setVisibility(View.GONE);
            // 获取InputMethodManager
//            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            // 隐藏软键盘
//            imm.hideSoftInputFromWindow(collegeIntroEditText.getWindowToken(), 0);
        });

        return rootView;
    }

    // 递归函数来查找所有的EditText控件
    private void findAllEditTexts(ViewGroup parentView, List<EditText> allEditTexts) {
        for (int i = 0; i < parentView.getChildCount(); i++) {
            View child = parentView.getChildAt(i);
            if (child instanceof EditText) {
                allEditTexts.add((EditText) child);
            } else if (child instanceof ViewGroup) {
                // 如果子视图是一个容器，继续递归搜索
                findAllEditTexts((ViewGroup) child, allEditTexts);
            }
        }
    }


}