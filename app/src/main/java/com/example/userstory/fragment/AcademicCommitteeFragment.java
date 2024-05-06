// 【学院】学术委员会
package com.example.userstory.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.userstory.R;

public class AcademicCommitteeFragment extends Fragment {
    private String title = "关于成立智能科学与工程学院学术委员会的通知";
    private String body = "学院各单位：\n" +
            "　　根据《暨南大学关于推进学术委员会建设工作的指导意见》《暨南大学学术委员会章程》等文件，学院完成智能科学与工程学院学术委员会的组建工作，现将委员会名单公布如下：\n" +
            "主　　　任：黄国全\n" +
            "常务副主任：屈　挺\n" +
            "副　主　任：孔　锐\n" +
            "委　　　员：（按姓氏笔画顺序）\n" +
            "吕广庆　刘晓翔　杨光华　徐素秀\n" +
            "秘　　　书：刘煜琼　王晓红";
    private String time = "\n" +
            "\n" +
            "智能科学与工程学院\n" +
            "\n" +
            "2019年7月11日";

    public AcademicCommitteeFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_academic_committee, container, false);

        TextView text_title = rootView.findViewById(R.id.text_view_title);
        TextView text_body = rootView.findViewById(R.id.text_view_body);
        TextView text_time = rootView.findViewById(R.id.text_view_time);

        text_title.setText(title);
        text_body.setText(body);
        text_time.setText(time);

        return rootView;
    }
}