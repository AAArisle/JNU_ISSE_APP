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


    // 接收数据
    String name = getIntent().getStringExtra("professionName");
    int imageResId = getIntent().getIntExtra("imageResId", 0);
    String introDetail = getIntent().getStringExtra("professionIntro");
    String coursesDetail = getIntent().getStringExtra("professionCourses");
    String requirementsDetail = getIntent().getStringExtra("professionRequirements");

    // 设置数据
    ((ImageView) findViewById(R.id.imageView)).setImageResource(imageResId);
    ((TextView) findViewById(R.id.textView)).setText(name);
    ((TextView) findViewById(R.id.intro_detail)).setText(introDetail);
    ((TextView) findViewById(R.id.course_detail)).setText(coursesDetail);
    ((TextView) findViewById(R.id.requirements_detail)).setText(requirementsDetail);
}


}



