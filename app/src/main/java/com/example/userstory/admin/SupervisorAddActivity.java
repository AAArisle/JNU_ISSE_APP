package com.example.userstory.admin;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.userstory.R;
import com.example.userstory.object.Supervisor;

public class SupervisorAddActivity extends AppCompatActivity {
    ActivityResultLauncher<Intent> photoAlbumLauncher;
    Supervisor supervisor;
    int photoTag = R.drawable.avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervisor_add);
        // 展示导师具体信息
        ImageView imageView = this.findViewById(R.id.ad_supervisor_imageView_add);
        TextView name = this.findViewById(R.id.ad_supervisor_textView_add);
        TextView job_title = this.findViewById(R.id.ad_supervisor_textView2_add);
        TextView research_direction = this.findViewById(R.id.ad_supervisor_textView4_add);
        TextView introduction = this.findViewById(R.id.ad_supervisor_textView6_add);
        TextView contact_information = this.findViewById(R.id.ad_supervisor_textView8_add);

        Button OKButton = this.findViewById(R.id.ad_supervisor_OK_button_add);
        Button cancelButton = this.findViewById(R.id.ad_supervisor_cancel_button_add);

        name.setOnClickListener(changeClick);
        job_title.setOnClickListener(changeClick);
        research_direction.setOnClickListener(changeClick);
        introduction.setOnClickListener(changeClick);
        contact_information.setOnClickListener(changeClick);
        photoAlbumLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent photoData = result.getData();
                        photoTag = photoData.getIntExtra("imageTag", R.drawable.avatar);
                        imageView.setImageResource(photoTag);
                    } else if (result.getResultCode() == Activity.RESULT_CANCELED) {
                        System.out.println("null");
                    }
                }
        );
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoAlbum = new Intent(SupervisorAddActivity.this, PhotoAlbumActivity.class);
                photoAlbumLauncher.launch(photoAlbum);
            }
        });
        OKButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                supervisor = new Supervisor((String) name.getText(), (String) research_direction.getText(), photoTag);
                supervisor.setIntroduction((String) introduction.getText());
                supervisor.setJob_title((String) job_title.getText());
                supervisor.setContact_information((String) contact_information.getText());
                Intent intent = new Intent();
                intent.putExtra("supervisor", supervisor);
                setResult(Activity.RESULT_OK, intent);
                SupervisorAddActivity.this.finish();
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SupervisorAddActivity.this.finish();
            }
        });
    }

    TextView.OnClickListener changeClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            LayoutInflater inflater = LayoutInflater.from(SupervisorAddActivity.this);
            View dialogView = inflater.inflate(R.layout.dialog_input, null);
            final EditText editText = dialogView.findViewById(R.id.editText);

            // 创建 AlertDialog
            new AlertDialog.Builder(SupervisorAddActivity.this)
                    .setTitle("修改")
                    .setView(dialogView)
                    .setPositiveButton("确认修改", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // 获取输入框中的文本
                            String inputText = editText.getText().toString();
                            ((TextView) v).setText(inputText);
//                            Toast.makeText(SupervisorAddActivity.this, "修改为" + inputText, Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .show();
        }
    };
}