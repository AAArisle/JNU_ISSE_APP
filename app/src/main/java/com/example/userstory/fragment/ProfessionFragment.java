//
//package com.example.userstory.fragment;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.GridLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.userstory.R;
//import com.example.userstory.activity.ProfessionDetailActivity;
//import com.example.userstory.object.Profession;
//import com.example.userstory.object.ProfessionAdapter;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ProfessionFragment extends Fragment {
//    private RecyclerView recyclerView;
//    private ProfessionAdapter professionAdapter;
//    private List<Profession> professions;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_profession, container, false);
//        recyclerView = view.findViewById(R.id.recycler_view);
//        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
//
//
//        professions = new ArrayList<>();
//        professions.add(new Profession("Biology", R.drawable.avatar, "Biology is about life.", "Courses cover genetics, etc.", "Requirements include..."));
//        professions.add(new Profession("Computer Science", R.drawable.avatar, "Study of algorithmic processes.", "Courses include programming, etc.", "Requirements include..."));
//        professions.add(new Profession("Politics", R.drawable.avatar, "Politics involves governance.", "Courses include political theory, etc.", "Requirements include..."));
//        professions.add(new Profession("Philosophy", R.drawable.avatar, "Philosophy explores general questions.", "Courses cover ethics, etc.", "Requirements include..."));
//        professions.add(new Profession("Maths", R.drawable.avatar, "Mathematics is about quantity.", "Courses cover algebra, etc.", "Requirements include..."));
//        professions.add(new Profession("AI", R.drawable.avatar, "AI is about machine intelligence.", "Courses include machine learning, etc.", "Requirements include..."));
//
//
//        professionAdapter = new ProfessionAdapter(professions, this::navigateToDetail);
//        recyclerView.setAdapter(professionAdapter);
//        return view;
//    }
//
//    private void navigateToDetail(Profession profession) {
//        Intent intent = new Intent(getActivity(), ProfessionDetailActivity.class);
//        intent.putExtra("professionName", profession.getName());
//        intent.putExtra("imageResId", profession.getImageResId());
//        intent.putExtra("professionIntro", profession.getIntroDetail());
//        intent.putExtra("professionCourses", profession.getCoursesDetail());
//        intent.putExtra("professionRequirements", profession.getRequirementsDetail());
//        startActivity(intent);
//    }
//
//
//}


package com.example.userstory.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userstory.R;
import com.example.userstory.activity.ProfessionDetailActivity;
import com.example.userstory.object.Profession;
import com.example.userstory.object.ProfessionAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProfessionFragment extends Fragment {
    private RecyclerView recyclerView;
    private ProfessionAdapter professionAdapter;
    private List<Profession> professions;
    private List<Profession> filteredProfessions;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profession, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        professions = new ArrayList<>();
        professions.add(new Profession("Biology", R.drawable.avatar, "Biology is about life.", "Courses cover genetics, etc.", "Requirements include..."));
        professions.add(new Profession("Computer Science", R.drawable.avatar, "Study of algorithmic processes.", "Courses include programming, etc.", "Requirements include..."));
        professions.add(new Profession("Politics", R.drawable.avatar, "Politics involves governance.", "Courses include political theory, etc.", "Requirements include..."));
        professions.add(new Profession("Philosophy", R.drawable.avatar, "Philosophy explores general questions.", "Courses cover ethics, etc.", "Requirements include..."));
        professions.add(new Profession("Maths", R.drawable.avatar, "Mathematics is about quantity.", "Courses cover algebra, etc.", "Requirements include..."));
        professions.add(new Profession("AI", R.drawable.avatar, "AI is about machine intelligence.", "Courses include machine learning, etc.", "Requirements include..."));

        filteredProfessions = new ArrayList<>(professions);

        professionAdapter = new ProfessionAdapter(filteredProfessions, this::navigateToDetail);
        recyclerView.setAdapter(professionAdapter);


        return view;
    }


    private void navigateToDetail(Profession profession) {
        Intent intent = new Intent(getActivity(), ProfessionDetailActivity.class);
        intent.putExtra("professionName", profession.getName());
        intent.putExtra("imageResId", profession.getImageResId());
        intent.putExtra("professionIntro", profession.getIntroDetail());
        intent.putExtra("professionCourses", profession.getCoursesDetail());
        intent.putExtra("professionRequirements", profession.getRequirementsDetail());
        startActivity(intent);
    }
}


