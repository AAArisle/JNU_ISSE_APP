package com.example.userstory.admin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.userstory.R;
import com.example.userstory.admin.AdCollegeInfoFragment;
import com.example.userstory.object.AdPagerAdapter;
import com.example.userstory.object.PagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class AdCollegeInfoFragment extends Fragment {
    static ViewPager2 viewPager;

    public AdCollegeInfoFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.ad_fragment_college, container, false);
        viewPager = rootView.findViewById(R.id.viewPager_add);
        TabLayout tabLayout = rootView.findViewById(R.id.tabLayout_add);

        AdPagerAdapter pagerAdapter = new AdPagerAdapter(requireActivity().getSupportFragmentManager(), getLifecycle());
        viewPager.setAdapter(pagerAdapter);
        // 设置预加载的页面数量为 Fragment 的总数
        viewPager.setOffscreenPageLimit(pagerAdapter.getItemCount());
        // 刷新菜单
        viewPager.setCurrentItem(1);
        viewPager.setCurrentItem(0);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText("历史沿革");
                            break;
                        case 1:
                            tab.setText("学院领导");
                            break;
                        case 2:
                            tab.setText("组织结构");
                            break;
                        case 3:
                            tab.setText("学术委员会");
                            break;
                        case 4:
                            tab.setText("院长寄语");
                            break;
                        case 5:
                            tab.setText("联系我们");
                            break;
                    }
                }).attach();

        return rootView;
    }
}

