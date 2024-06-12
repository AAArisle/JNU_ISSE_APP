package com.example.userstory.admin;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.userstory.R;
import com.example.userstory.fragment.collegeInnerFragment.LeaderShipFragment;
import com.example.userstory.object.LeaderShip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class AdLeaderShipFragment extends Fragment{
    public static List<LeaderShip> leaderShips = getLeaderShips();
    public static List<LeaderShip> getLeaderShips(){
        List<LeaderShip> leaderShips = new ArrayList<>();
        leaderShips.addAll(Arrays.asList(
                new LeaderShip("杨光华","院长，负责学院全面工作；分管行政、人事、财务、高水平大学建设等工作；联系物联网与物流工程研究院。"),
                new LeaderShip("周玉宇", "党总支书记，负责学院党总支全面工作；分管党建、思政、意识形态、干部、宣传、监察、安全、保密、统战、工会等工作。"),
                new LeaderShip("陈韶鹏", "党总支副书记，分管学生工作、信息化、竞赛基地、校友等工作。"),
                new LeaderShip("施政", "副院长，分管学科建设、科研、研究生教育、高级研修班、产学研合作平台、国际交流与合作等工作。"),
                new LeaderShip("闫勉", "副院长，分管本科教育、教师教学培训、实验室、实习/实践平台与基地、人工智能产业学院建设等工作。")
        ));
        return leaderShips;
    }
    public AdLeaderShipFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.ad_fragment_leader_ship, container, false);
        TextView collegeIntro = rootView.findViewById(R.id.text_view_leader_ship_add);
        EditText collegeIntroEditText = rootView.findViewById(R.id.edit_leadership_add);
        Button buttonSave = rootView.findViewById(R.id.button_save2);
        TextView textView = rootView.findViewById(R.id.text_view_leader_ship_add);
        if(LeaderShipFragment.intro2==""){
            for (LeaderShip leaderShip: leaderShips){
                textView.setText(textView.getText()+leaderShip.getName()+"："+leaderShip.getIntro()+"\n\n");
            }}
        else textView.setText(LeaderShipFragment.intro2);
        //collegeIntro.setText(ORIGINAL_INTRO);

        collegeIntro.setOnClickListener(v -> {
            collegeIntro.setVisibility(View.GONE);
            collegeIntroEditText.setVisibility(View.VISIBLE);
            buttonSave.setVisibility(View.VISIBLE);
            collegeIntroEditText.setText(textView.getText().toString());
            collegeIntroEditText.setEnabled(true);
            collegeIntroEditText.requestFocus();
        });

        buttonSave.setOnClickListener(v -> {
            String editedIntro = collegeIntroEditText.getText().toString();
            if (!TextUtils.isEmpty(editedIntro)) {
                String intro = editedIntro;
                collegeIntro.setText(intro);
                LeaderShipFragment.intro2=intro;
            }
            collegeIntroEditText.setVisibility(View.GONE);
            buttonSave.setVisibility(View.GONE);
            collegeIntro.setVisibility(View.VISIBLE);
        });
        return rootView;
    }
}
