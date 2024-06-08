package com.example.userstory.admin;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.userstory.R;
import com.example.userstory.object.Supervisor;

public class SupervisorChangeActivity extends AppCompatActivity {
    ActivityResultLauncher<Intent> photoAlbumLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervisor_change);
        // 获取Intent
        Intent data = getIntent();

        Supervisor supervisor = data.getParcelableExtra("supervisor");
        int position = data.getIntExtra("position", 0);

        // 展示导师具体信息
        ImageView imageView = this.findViewById(R.id.ad_supervisor_imageView);
        TextView name = this.findViewById(R.id.ad_supervisor_textView);
        TextView job_title = this.findViewById(R.id.ad_supervisor_textView2);
        TextView research_direction = this.findViewById(R.id.ad_supervisor_textView4);
        TextView introduction = this.findViewById(R.id.ad_supervisor_textView6);
        TextView contact_information = this.findViewById(R.id.ad_supervisor_textView8);

        Button OKButton = this.findViewById(R.id.ad_supervisor_OK_button);
        Button cancelButton = this.findViewById(R.id.ad_supervisor_cancel_button);

        imageView.setImageResource(supervisor.getImageId());
        name.setText(supervisor.getSupervisorName());
        job_title.setText(supervisor.getJob_title());
        research_direction.setText(supervisor.getSupervisorDirection());
        introduction.setText(supervisor.getIntroduction());
        contact_information.setText(supervisor.getContact_information());

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
                        int photoTag = photoData.getIntExtra("imageTag", R.drawable.avatar);
                        imageView.setImageResource(photoTag);
                        supervisor.setImageId(photoTag);
                    } else if (result.getResultCode() == Activity.RESULT_CANCELED) {
                        System.out.println("null");
                    }
                }
        );
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoAlbum = new Intent(SupervisorChangeActivity.this, PhotoAlbumActivity.class);
                photoAlbumLauncher.launch(photoAlbum);
            }
        });
        OKButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                supervisor.setSupervisorName((String) name.getText());
                supervisor.setSupervisorDirection((String) research_direction.getText());
                supervisor.setIntroduction((String) introduction.getText());
                supervisor.setJob_title((String) job_title.getText());
                supervisor.setContact_information((String) contact_information.getText());
                Intent intent = new Intent();
                intent.putExtra("position", position);
                intent.putExtra("supervisor", supervisor);
                setResult(Activity.RESULT_OK, intent);
                SupervisorChangeActivity.this.finish();
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SupervisorChangeActivity.this.finish();
            }
        });
    }

    TextView.OnClickListener changeClick = new View.OnClickListener() {


        @Override
        public void onClick(View v) {
            LayoutInflater inflater = LayoutInflater.from(SupervisorChangeActivity.this);
            View dialogView = inflater.inflate(R.layout.dialog_input, null);
            final EditText editText = dialogView.findViewById(R.id.editText);

            // 创建 AlertDialog
            new AlertDialog.Builder(SupervisorChangeActivity.this)
                    .setTitle("修改")
                    .setView(dialogView)
                    .setPositiveButton("确认修改", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // 获取输入框中的文本
                            String inputText = editText.getText().toString();
                            ((TextView) v).setText(inputText);
//                            Toast.makeText(SupervisorChangeActivity.this, "修改为" + inputText, Toast.LENGTH_SHORT).show();
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