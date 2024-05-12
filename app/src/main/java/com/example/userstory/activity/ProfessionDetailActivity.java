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

public class ProfessionDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profession_detail);

//         设置Toolbar作为ActionBar
        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView toolbarTitle = findViewById(R.id.toolbar_title);
        toolbarTitle.setText(R.string.profession_detail);
        toolbarTitle.setGravity(Gravity.LEFT);
        setSupportActionBar(toolbar);
//         标签页左边的返回按钮
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        // 设置返回按钮的点击事件
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 在这里处理返回按钮的点击事件，比如finish当前Activity
                finish();
            }
        });


//        TextView titleTextView = findViewById(R.id.textView2);
//        titleTextView.setText("专业介绍");
//
//        TextView researchTextView = findViewById(R.id.textView3);
//        researchTextView.setText("专业课程");
//
//
//
//        TextView introTextView = findViewById(R.id.textView5);
//        introTextView.setText("申请条件");

// 接收传递过来的数据
        String professionName = getIntent().getStringExtra("professionName");
        int imageResId = getIntent().getIntExtra("imageResId", 0);
        String professionIntro = getIntent().getStringExtra("professionIntro");
        String professionCourse = getIntent().getStringExtra("professionCourse");
        String professionRequirements = getIntent().getStringExtra("professionRequirements");

        // 设置图片
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(imageResId);

        // 设置基本信息
        TextView nameTextView = findViewById(R.id.textView);
        nameTextView.setText(professionName);

        // 设置文本信息
        TextView titleTextView = findViewById(R.id.textView2);
        titleTextView.setText(professionIntro);

        TextView researchTextView = findViewById(R.id.textView3);
        researchTextView.setText(professionCourse);

        TextView introTextView = findViewById(R.id.textView5);
        introTextView.setText(professionRequirements);
    }
}


