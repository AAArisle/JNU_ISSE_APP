package com.example.userstory;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.userstory.R;
import com.squareup.picasso.Picasso;






public class ProfessionDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profession_detail);
//        Button exportButton = findViewById(R.id.btn_export_json);
//        exportButton.setOnClickListener(v -> exportToJson());
        // 接收传递过来的数据
        String professionName = getIntent().getStringExtra("professionName");
        int imageResId = getIntent().getIntExtra("imageResId", 0);

        // 设置图片
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(imageResId);

        // 设置基本信息
        TextView nameTextView = findViewById(R.id.textView);
        nameTextView.setText(professionName);

        // 示例数据，实际应用中这些应该是动态加载的
        TextView titleTextView = findViewById(R.id.textView2);
        titleTextView.setText("专业介绍");

        TextView researchTextView = findViewById(R.id.textView3);
        researchTextView.setText("专业课程");

//        TextView researchDetailTextView = findViewById(R.id.textView4);
//        researchDetailTextView.setText("申请条件");

        TextView introTextView = findViewById(R.id.textView5);
        introTextView.setText("申请条件");

//        TextView introDetailTextView = findViewById(R.id.textView6);
//        introDetailTextView.setText("专业规划");


    }
    private void exportToJson() {
        // 这里编写导出 JSON 的代码逻辑
        Toast.makeText(this, "导出数据为 JSON", Toast.LENGTH_SHORT).show();
    }
}


