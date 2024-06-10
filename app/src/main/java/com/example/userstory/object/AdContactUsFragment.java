package com.example.userstory.object;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.userstory.R;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;

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
        EditText edit_text_x = rootView.findViewById(R.id.EditText_x);
        EditText edit_text_y = rootView.findViewById(R.id.EditText_y);
        com.tencent.tencentmap.mapsdk.maps.MapView mapView = rootView.findViewById(R.id.mapView);
        TencentMap tencentMap = mapView.getMap();
        tencentMap.moveCamera(CameraUpdateFactory.newLatLng(point1));


        Button buttonSave = rootView.findViewById(R.id.button_save);

        List<EditText> allEditTexts = new ArrayList<>();
        allEditTexts.add(rootView.findViewById(R.id.edit_text_address));
        allEditTexts.add(rootView.findViewById(R.id.edit_text_telephone));
        allEditTexts.add(rootView.findViewById(R.id.edit_text_email));
        allEditTexts.add(rootView.findViewById(R.id.EditText_x));
        allEditTexts.add(rootView.findViewById(R.id.EditText_y));


        if(null==contactFunc.getAddress()) {
            contactFunc.setAddress("地址：广东省珠海市香洲区前山路206号暨南大学行政楼6楼");
            contactFunc.setTelephone("电话：0756-8505610");
            contactFunc.setEmail("邮箱：osisse@jnu.edu.cn");

        }
        if (null==point1)
        {
            point1 = new LatLng(22.255925,113.541112);
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
            point1.setLatitude(Double.parseDouble(edit_text_x.getText().toString()));
            point1.setLongitude(Double.parseDouble(edit_text_y.getText().toString()));

            tencentMap.moveCamera(CameraUpdateFactory.newLatLng(point1));

            // 创建一个Marker对象
            MarkerOptions markerOptions = new MarkerOptions(point1)
                    .title("暨南大学");

            // 添加标记到地图上
            Marker marker = tencentMap.addMarker(markerOptions);

            //设置实时路况开启
            tencentMap.setTrafficEnabled(true);
            buttonSave.setVisibility(View.GONE);
            // 获取InputMethodManager
//            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            // 隐藏软键盘
//            imm.hideSoftInputFromWindow(collegeIntroEditText.getWindowToken(), 0);
        });

        return rootView;
    }
}