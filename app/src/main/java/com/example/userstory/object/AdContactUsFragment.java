package com.example.userstory.object;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.userstory.R;

import static com.example.userstory.fragment.collegeInnerFragment.ContactUsFragment.contactFunc;
import static com.example.userstory.fragment.collegeInnerFragment.ContactUsFragment.point1;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AdContactUsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AdContactUsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AdContactUsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AdContactUsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AdContactUsFragment newInstance(String param1, String param2) {
        AdContactUsFragment fragment = new AdContactUsFragment();
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
        View rootView = inflater.inflate(R.layout.ad_fragment_contact_us, container, false);
        EditText edit_text_address = rootView.findViewById(R.id.edit_text_address);
        EditText edit_text_telephone = rootView.findViewById(R.id.edit_text_telephone);
        EditText edit_text_email = rootView.findViewById(R.id.edit_text_email);

        Button buttonSave = rootView.findViewById(R.id.button_save);

        List<EditText> allEditTexts = new ArrayList<>();
        allEditTexts.add(rootView.findViewById(R.id.edit_text_address));
        allEditTexts.add(rootView.findViewById(R.id.edit_text_telephone));
        allEditTexts.add(rootView.findViewById(R.id.edit_text_email));

        if(null==contactFunc.getAddress()) {
            contactFunc.setAddress("地址：广东省珠海市香洲区前山路206号暨南大学行政楼6楼");
            contactFunc.setTelephone("电话：0756-8505610");
            contactFunc.setEmail("邮箱：osisse@jnu.edu.cn");

        }

        edit_text_address.setText(contactFunc.getAddress());
        edit_text_telephone.setText(contactFunc.getTelephone());
        edit_text_email.setText(contactFunc.getEmail());
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
            contactFunc.setAddress(edit_text_address.getText().toString());
            contactFunc.setTelephone(edit_text_telephone.getText().toString());
            contactFunc.setEmail(edit_text_email.getText().toString());
            buttonSave.setVisibility(View.GONE);
            // 获取InputMethodManager
//            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            // 隐藏软键盘
//            imm.hideSoftInputFromWindow(collegeIntroEditText.getWindowToken(), 0);
        });

        return rootView;
    }
}