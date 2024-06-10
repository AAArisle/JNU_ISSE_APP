package com.example.userstory.object;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.userstory.admin.AdAcademicCommitteeFragment;
import com.example.userstory.admin.AdDeanMessageFragment;
import com.example.userstory.admin.AdCollegeIntroInfoFragment;
import com.example.userstory.admin.AdOrganizationStructureFragment;
import com.example.userstory.fragment.collegeInnerFragment.ContactUsFragment;
import com.example.userstory.admin.AdLeaderShipFragment;
import com.example.userstory.fragment.collegeInnerFragment.DeanMessageFragment;

public class AdPagerAdapter extends FragmentStateAdapter{
    public AdPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        //获得Tab对应的Fragment
        switch (position) {
            case 0:
                return new AdCollegeIntroInfoFragment(); // 历史沿革
            case 1:
                return new AdLeaderShipFragment(); // 学院领导
            case 2:
                return new AdOrganizationStructureFragment(); // 组织结构
            case 3:
                return new AdAcademicCommitteeFragment(); // 学术委员会
            case 4:
                return new AdDeanMessageFragment(); // 院长寄语
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
