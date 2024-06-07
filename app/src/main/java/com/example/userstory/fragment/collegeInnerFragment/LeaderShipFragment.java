// 【学院】学院领导
package com.example.userstory.fragment.collegeInnerFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.userstory.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LeaderShip{
    String name;
    String intro;

    public LeaderShip(String name, String intro){
        this.name = name;
        this.intro = intro;
    }
}

public class LeaderShipFragment extends Fragment {
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
    public LeaderShipFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_leader_ship, container, false);

        TextView textView = rootView.findViewById(R.id.text_view_leader_ship);
        for (LeaderShip leaderShip: leaderShips){
            textView.setText(textView.getText()+"\n\n"+leaderShip.name+"："+leaderShip.intro);
        }

        return rootView;
    }
}