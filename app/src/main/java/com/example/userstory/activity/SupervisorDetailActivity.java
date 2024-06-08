
package com.example.userstory.activity;

import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.userstory.R;
import com.example.userstory.object.Supervisor;

public class SupervisorDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervisor_detail);
        // 接收intent以便个性化界面
        Supervisor receivedSupervisor = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            receivedSupervisor = getIntent().getParcelableExtra("Supervisor", Supervisor.class);
        }

        // 展示导师具体信息
        ImageView imageView = this.findViewById(R.id.imageView);
        TextView name = this.findViewById(R.id.textView);
        TextView job_title = this.findViewById(R.id.textView2);
        TextView research_direction = this.findViewById(R.id.textView4);
        TextView introduction = this.findViewById(R.id.textView6);
        TextView contact_information = this.findViewById(R.id.textView8);

        imageView.setImageResource(receivedSupervisor.getImageId());
        name.setText(receivedSupervisor.getSupervisorName());
        job_title.setText(receivedSupervisor.getJob_title());
        research_direction.setText(receivedSupervisor.getSupervisorDirection());
        introduction.setText(receivedSupervisor.getIntroduction());
        contact_information.setText(receivedSupervisor.getContact_information());

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