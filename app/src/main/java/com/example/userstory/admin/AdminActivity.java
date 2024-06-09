package com.example.userstory.admin;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.userstory.R;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.example.userstory.fragment.MyFragment;

public class AdminActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private Button exitAdminModeButton; // 添加退出管理员模式的按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);
        exitAdminModeButton = findViewById(R.id.exit_admin_mode_button); // 初始化退出管理员模式的按钮

        viewPager.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                switch (position) {
                    case 0:
                        return new AdSupervisorFragment();
                    case 1:
                        return new AdProfessionsFragment();
                    case 2:
                        return new AdCollegeInfoFragment();
                    default:
                        return new Fragment();
                }
            }

            @Override
            public int getItemCount() {
                return 3;
            }
        });

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("导师");
                    break;
                case 1:
                    tab.setText("专业");
                    break;
                case 2:
                    tab.setText("学院信息");
                    break;
            }
        }).attach();

        exitAdminModeButton.setOnClickListener(v -> exitAdminMode()); // 设置退出管理员模式按钮的点击监听器
    }

    // 退出管理员模式的方法
    private void exitAdminMode() {
        clearAdminCredentials();
        finish(); // 结束当前Activity，返回到上一个Activity或Fragment
    }
    private void clearAdminCredentials() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove("username");
        editor.remove("password");
        editor.apply();
    }
}
