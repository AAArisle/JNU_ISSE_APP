// 【专业】页面
package com.example.userstory.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userstory.R;
import com.example.userstory.activity.ProfessionDetailActivity;
import com.example.userstory.object.Profession;
import com.example.userstory.object.ProfessionAdapter;

import java.util.ArrayList;
import java.util.List;

public class ProfessionFragment extends Fragment {
    private RecyclerView recyclerView;
    private ProfessionAdapter professionAdapter;
    private List<Profession> professions;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profession, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        professions = new ArrayList<>();
        professions.add(new Profession("Biology", R.drawable.avatar));
        professions.add(new Profession("Computer Science", R.drawable.avatar));
        professions.add(new Profession("Politics", R.drawable.avatar));
        professions.add(new Profession("Pholophy", R.drawable.avatar));
        professions.add(new Profession("Maths", R.drawable.avatar));
        professions.add(new Profession("AI", R.drawable.avatar));

        professionAdapter = new ProfessionAdapter(professions, this::navigateToDetail);
        recyclerView.setAdapter(professionAdapter);
        return view;
    }

    private void navigateToDetail(Profession profession) {
        Intent intent = new Intent(getActivity(), ProfessionDetailActivity.class);
        intent.putExtra("professionName", profession.getName());
        intent.putExtra("imageResId", profession.getImageResId());
        startActivity(intent);
    }
}
