// 【我的】页面
package com.example.userstory.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.userstory.R;
import com.example.userstory.admin.AdminActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


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

        // 设置监听器
        settingsImageView.setOnClickListener(v -> {
            // 处理设置图标的点击事件
        });

        optionsListView.setOnItemClickListener((parent, view1, position, id) -> {
            // 处理列表项的点击事件，比如跳转到其他Fragment或Activity
            if (position == 0) {
                if (Environment.isExternalStorageManager()) {
                    // 已经有权限
                    importData();
                } else {
                    // 引导用户授予权限
                    Intent intent = new Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
                    startActivity(intent);
                }
            }
            if (position == 1) {
                adminExportData();
            }
            if (position == 2) { // Assuming the 3rd item is "管理员登录"
                showAdminLoginDialog();
            }
        });

        // 初始化数据
        loadUserInfo();

        // 添加选项数据
        String[] options = {"导入数据", "导出数据", "管理员模式"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, options);
        optionsListView.setAdapter(adapter);

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

    private void showAdminLoginDialog() {
        Context context = getContext();
        if (context == null) return;

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_admin_login, null);
        builder.setView(dialogView);

        EditText usernameEditText = dialogView.findViewById(R.id.usernameEditText);
        EditText passwordEditText = dialogView.findViewById(R.id.passwordEditText);

        builder.setPositiveButton("登录", (dialog, which) -> {
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            if (authenticateAdmin(username, password)) {
                // 密码正确，进入管理员界面
                Intent intent = new Intent(context, AdminActivity.class);
                startActivity(intent);
            } else {
                // 密码错误，显示提示
                Toast.makeText(context, "用户名或密码错误", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("取消", (dialog, which) -> dialog.dismiss());

        builder.create().show();
    }

    private boolean authenticateAdmin(String username, String password) {
        // 这里可以进行实际的用户名和密码验证
        return "".equals(username) && "".equals(password);
    }
}


