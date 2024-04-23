
package com.example.userstory.activity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.userstory.R;

public class SupervisorDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervisor_detail);
        ImageView imageView = this.findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.avatar);

        // 设置Toolbar作为ActionBar
        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView toolbarTitle = findViewById(R.id.toolbar_title);
        toolbarTitle.setText(R.string.supervisor_detail);
        toolbarTitle.setGravity(Gravity.LEFT);
        setSupportActionBar(toolbar);
        // 标签页左边的返回按钮
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        // 设置返回按钮的点击事件
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 在这里处理返回按钮的点击事件，比如finish当前Activity
                finish();
            }
        });
    }
}