// 【我的】页面
package com.example.userstory.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.userstory.R;


public class MyFragment extends Fragment {

    private TextView usernameTextView;
    private ImageView avatarImageView;
    private TextView applicationCountTextView;
    private TextView followCountTextView;
    private TextView messageCountTextView;
    private ListView optionsListView;
    private ImageView settingsImageView;

    public MyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);

        usernameTextView = view.findViewById(R.id.usernameTextView);
        avatarImageView = view.findViewById(R.id.avatarImageView);
        applicationCountTextView = view.findViewById(R.id.applicationCountTextView);
        followCountTextView = view.findViewById(R.id.followCountTextView);
        messageCountTextView = view.findViewById(R.id.messageCountTextView);
        optionsListView = view.findViewById(R.id.optionsListView);
        settingsImageView = view.findViewById(R.id.settingsImageView);



        return view;
    }

    private void loadUserInfo() {
        // 这里可以从你的用户模型或数据库中加载数据
        usernameTextView.setText("用户名");
        applicationCountTextView.setText("0\n申请");
        followCountTextView.setText("0\n收藏");
        messageCountTextView.setText("0\n消息");

        // 设置头像的图片资源
        avatarImageView.setImageResource(R.drawable.avatar);
    }


}


