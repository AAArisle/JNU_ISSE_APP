
package com.example.userstory.fragment.activity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import com.example.userstory.R;

public class SupervisorDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervisor_detail);
        ImageView imageView = this.findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.avatar);
    }
}