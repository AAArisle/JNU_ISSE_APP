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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;





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
import com.example.userstory.fragment.ProfessionRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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
import com.example.userstory.fragment.ProfessionRepository;
import com.example.userstory.fragment.Profession;
import com.example.userstory.fragment.ProfessionAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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
import com.example.userstory.fragment.ProfessionRepository;
import com.example.userstory.fragment.Profession;
import com.example.userstory.fragment.ProfessionAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



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
import com.example.userstory.fragment.ProfessionRepository;
import com.example.userstory.fragment.Profession;
import com.example.userstory.fragment.ProfessionAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProfessionFragment extends Fragment {
    private RecyclerView recyclerView;
    private ProfessionAdapter professionAdapter;
    static List<Profession> professions;
    private List<Profession> filteredProfessions;
    private ProfessionRepository professionRepository;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profession, container, false);

        EditText searchProfession = view.findViewById(R.id.search_profession);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        professionRepository = new ProfessionRepository(getContext());
        professions = professionRepository.getAllProfessions();

        filteredProfessions = new ArrayList<>(professions);

        professionAdapter = new ProfessionAdapter(filteredProfessions, this::navigateToDetail);
        recyclerView.setAdapter(professionAdapter);

        searchProfession.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterProfessions(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        professions.clear();
        professions.addAll(professionRepository.getAllProfessions());
        filterProfessions(""); // 重新过滤，确保搜索结果与更新后的数据匹配
    }

    private void filterProfessions(String query) {
        filteredProfessions.clear();
        if (query.isEmpty()) {
            filteredProfessions.addAll(professions);
        } else {
            String lowerCaseQuery = query.toLowerCase();
            filteredProfessions.addAll(professions.stream()
                    .filter(profession -> profession.getName().toLowerCase().contains(lowerCaseQuery))
                    .collect(Collectors.toList()));
        }
        professionAdapter.notifyDataSetChanged();
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
