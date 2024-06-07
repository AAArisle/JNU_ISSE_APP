package com.example.userstory.fragment.collegeInnerFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.userstory.R;
import com.example.userstory.object.ContactFunc;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;

public class ContactUsFragment extends Fragment {
    private static String address = "广东省珠海市香洲区前山路206号暨南大学行政楼6楼";
    private static String telephone = "0756-8505610";
    private static String email = "osisse@jnu.edu.cn";

    static public ContactFunc contactFunc = new ContactFunc(address, telephone, email);
    static public LatLng point1 = new LatLng(22.255925,113.541112);

    private com.tencent.tencentmap.mapsdk.maps.MapView mapView = null;
    public ContactUsFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_contact_us, container, false);

        TextView text_address = rootView.findViewById(R.id.text_view_address);
        TextView text_telephone = rootView.findViewById(R.id.text_view_telephone);
        TextView text_email = rootView.findViewById(R.id.text_view_email);
        mapView = rootView.findViewById(R.id.mapView);

        text_address.setText(text_address.getText()+contactFunc.getAddress());
        text_telephone.setText(text_telephone.getText()+contactFunc.getTelephone());
        text_email.setText(text_email.getText()+contactFunc.getEmail());

        TencentMap tencentMap = mapView.getMap();

        tencentMap.moveCamera(CameraUpdateFactory.newLatLng(point1));

        // 创建一个Marker对象
        MarkerOptions markerOptions = new MarkerOptions(point1)
                .title("暨南大学");

        // 添加标记到地图上
        Marker marker = tencentMap.addMarker(markerOptions);

        //设置实时路况开启
        tencentMap.setTrafficEnabled(true);

        return rootView;
    }

    @Override
    public void onStart() {
        mapView.onStart();
        super.onStart();
    }
    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }
    @Override
    public void onStop() {
        mapView.onStop();
        super.onStop();
    }
    @Override
    public void onPause() {
        mapView.onPause();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }
}