

package com.example.userstory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;


import com.example.userstory.fragment.CollegeFragment;
import com.example.userstory.fragment.MyFragment;
import com.example.userstory.fragment.ProfessionFragment;
import com.example.userstory.fragment.SupervisorFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private Fragment activeFragment;
    private SupervisorFragment supervisorFragment;
    private ProfessionFragment professionFragment;
    private CollegeFragment collegeFragment;
    private MyFragment myFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navi_view);

        //初始化 Fragment
        supervisorFragment = new SupervisorFragment();
        professionFragment = new ProfessionFragment();
        collegeFragment = new CollegeFragment();
        myFragment = new MyFragment();

        //现实默认的 Fragment
        activeFragment = supervisorFragment;
        getSupportFragmentManager().beginTransaction().add(R.id.frame_layout, supervisorFragment)
                .add(R.id.frame_layout, professionFragment).hide(professionFragment)
                .add(R.id.frame_layout, collegeFragment).hide(collegeFragment)
                .add(R.id.frame_layout, myFragment).hide(myFragment).commit();

        // 设置BottomNavigationView的点击事件监听器
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            if(item.getItemId() == R.id.menu_supervisor){
                getSupportFragmentManager().beginTransaction().remove(supervisorFragment).commit();
                supervisorFragment = new SupervisorFragment();
                getSupportFragmentManager().beginTransaction().add(R.id.frame_layout, supervisorFragment).hide(supervisorFragment).commit();
                showFragment(supervisorFragment);
                return true;
            } else if (item.getItemId() == R.id.menu_profession) {
                getSupportFragmentManager().beginTransaction().remove(professionFragment).commit();
                professionFragment = new ProfessionFragment();
                getSupportFragmentManager().beginTransaction().add(R.id.frame_layout, professionFragment).hide(professionFragment).commit();
                showFragment(professionFragment);
                return true;
            }else if (item.getItemId() == R.id.menu_college) {
                getSupportFragmentManager().beginTransaction().remove(collegeFragment).commit();
                collegeFragment = new CollegeFragment();
                getSupportFragmentManager().beginTransaction().add(R.id.frame_layout, collegeFragment).hide(collegeFragment).commit();
                showFragment(collegeFragment);
                return true;
            }else if (item.getItemId() == R.id.menu_my) {
                getSupportFragmentManager().beginTransaction().remove(myFragment).commit();
                myFragment = new MyFragment();
                getSupportFragmentManager().beginTransaction().add(R.id.frame_layout, myFragment).hide(myFragment).commit();
                showFragment(myFragment);
                return true;
            }else
                return false;
        });
    }

    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // 隐藏当前显示的 Fragment
        fragmentTransaction.hide(activeFragment);
        // 显示要显示的 Fragment
        fragmentTransaction.show(fragment);
        fragmentTransaction.commit();

        // 更新当前显示的 Fragment
        activeFragment = fragment;

    }
}