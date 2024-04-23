package com.example.userstory.object;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.userstory.fragment.AcademicCommitteeFragment;
import com.example.userstory.fragment.CollegeIntroFragment;
import com.example.userstory.fragment.ContactUsFragment;
import com.example.userstory.fragment.DeanMessageFragment;
import com.example.userstory.fragment.LeaderShipFragment;
import com.example.userstory.fragment.OrganizationStructureFragment;

public class PagerAdapter extends FragmentStateAdapter{
    public PagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        //获得Tab对应的Fragment
        switch (position) {
            case 0:
                return new CollegeIntroFragment(); // 历史沿革
            case 1:
                return new LeaderShipFragment(); // 学院领导
            case 2:
                return new OrganizationStructureFragment(); // 组织结构
            case 3:
                return new AcademicCommitteeFragment(); // 学术委员会
            case 4:
                return new DeanMessageFragment(); // 院长寄语
            case 5:
                return new ContactUsFragment(); // 联系我们
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
