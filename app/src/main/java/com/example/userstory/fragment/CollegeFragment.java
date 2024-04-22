
package com.example.userstory.fragment;
import android.os.Bundle;
import com.example.userstory.R;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.userstory.R;

import androidx.fragment.app.Fragment;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.navigation.NavigationView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.PopupMenu;



//public class CollegeFragment extends Fragment {
//
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_college, container, false);
//        Button menuButton = view.findViewById(R.id.button_menu);
//
//        // 设置默认显示学院简介
//        showFragment(new CollegeIntroFragment());
//
//        // 设置按钮的弹出菜单
//        menuButton.setOnClickListener(v -> showPopupMenu(v));
//        return view;
//    }
//
//    private void showPopupMenu(View view) {
//        PopupMenu popup = new PopupMenu(getContext(), view);
//        popup.getMenuInflater().inflate(R.menu.drawer_menu, popup.getMenu());
//        popup.setOnMenuItemClickListener(item -> {
//            handleMenuItemClick(item);
//            return true;
//        });
//        popup.show();
//    }
//
//    private void handleMenuItemClick(MenuItem item) {
//        Fragment fragment = null;
//
//        if (item.getItemId() == R.id.nav_college_intro){
//            fragment = new CollegeIntroFragment();
//        } else if (item.getItemId() ==R.id.nav_dean_speech) {
//            fragment = new DeanMessageFragment();
//        }
//
//        if (fragment != null) {
//            showFragment(fragment);
//        }
//    }
//
//    private void showFragment(Fragment fragment) {
//        getChildFragmentManager().beginTransaction()
//                .replace(R.id.content_frame, fragment)
//                .commit();
//    }
//}
//




import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.userstory.R;
//
//public class CollegeFragment extends Fragment {
//
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_college, container, false);
//        Button menuButton = view.findViewById(R.id.button_menu);
//
//        // 默认显示学院简介
//        showFragment(new CollegeIntroFragment());
//
//        // 设置按钮的弹出菜单
//        menuButton.setOnClickListener(v -> showPopupMenu(v));
//        return view;
//    }
//
//    private void showPopupMenu(View view) {
//        PopupMenu popup = new PopupMenu(getContext(), view);
//        popup.getMenuInflater().inflate(R.menu.drawer_menu, popup.getMenu());
//        popup.setOnMenuItemClickListener(item -> {
//            handleMenuItemClick(item);
//            return true;
//        });
//        popup.show();
//    }
//
//    private void handleMenuItemClick(MenuItem item) {
//        Fragment fragment = null;
//        if (item.getItemId() == R.id.nav_college_intro){
//            fragment = new CollegeIntroFragment();
//        } else if (item.getItemId() ==R.id.nav_dean_speech) {
//            fragment = new DeanMessageFragment();
//        }
//
//        if (fragment != null) {
//            showFragment(fragment);
//        }
//
//    }
//
//    private void showFragment(Fragment fragment) {
//        getChildFragmentManager().beginTransaction()
//                .replace(R.id.content_frame, fragment)
//                .commit();
//    }
//}


import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.PopupMenu;
        import androidx.fragment.app.Fragment;

public class CollegeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_college, container, false);

        Button buttonNavigation = view.findViewById(R.id.button_navigation);
        buttonNavigation.setOnClickListener(this::showPopupMenu);

        // 默认显示学院简介的内容
        displaySection(R.id.nav_college_intro);

        return view;
    }

    private void showPopupMenu(View v) {
        PopupMenu popup = new PopupMenu(getContext(), v);
        popup.getMenuInflater().inflate(R.menu.drawer_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(item -> {
            displaySection(item.getItemId());
            return true;
        });
        popup.show();
    }


    private void displaySection(int sectionId) {
        Fragment fragment = null;
        if (sectionId == R.id.nav_college_intro){
            fragment = new CollegeIntroFragment();
        } else if (sectionId ==R.id.nav_dean_speech) {
            fragment = new DeanMessageFragment();
        }
        getChildFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}
