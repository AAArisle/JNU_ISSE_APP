package com.example.userstory.fragment;


import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userstory.R;
import com.example.userstory.fragment.ProfessionRepository;
import com.example.userstory.fragment.Profession;
import com.example.userstory.fragment.ProfessionAdapter;

import java.util.List;


import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userstory.R;
import com.example.userstory.fragment.ProfessionRepository;
import com.example.userstory.fragment.Profession;
import com.example.userstory.fragment.ProfessionAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class AdProfessionsFragment extends Fragment {
    private RecyclerView recyclerView;
    private ProfessionAdapter professionAdapter;
    private List<Profession> professions;
    private ProfessionRepository professionRepository;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ad_fragment_professions, container, false);

        recyclerView = view.findViewById(R.id.recycler_view_admin);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        FloatingActionButton fabAddProfession = view.findViewById(R.id.fab_add_profession);
        fabAddProfession.setOnClickListener(v -> showAddDialog());

        professionRepository = new ProfessionRepository(getContext());
        professions = professionRepository.getAllProfessions();

        professionAdapter = new ProfessionAdapter(professions, this::showEditDialog);
        recyclerView.setAdapter(professionAdapter);

        return view;
    }

    private void showAddDialog() {
        View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_add_profession, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Add Profession");
        builder.setView(dialogView);
        builder.setPositiveButton("添加", (dialog, which) -> {
            EditText nameInput = dialogView.findViewById(R.id.edit_profession_name);
            EditText introInput = dialogView.findViewById(R.id.edit_profession_intro);
            EditText coursesInput = dialogView.findViewById(R.id.edit_profession_courses);
            EditText requirementsInput = dialogView.findViewById(R.id.edit_profession_requirements);

            String name = nameInput.getText().toString();
            String intro = introInput.getText().toString();
            String courses = coursesInput.getText().toString();
            String requirements = requirementsInput.getText().toString();

            // 默认图片，这里可以修改为动态选择图片
            int imageResId = R.drawable.biology;

            if (!name.isEmpty() && !intro.isEmpty() && !courses.isEmpty() && !requirements.isEmpty()) {
                Profession profession = new Profession(name, imageResId, intro, courses, requirements);
                professionRepository.addProfession(profession);
                professions.clear();
                professions.addAll(professionRepository.getAllProfessions());
                professionAdapter.notifyDataSetChanged();
            } else {
                Toast.makeText(getContext(), "均必填", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", null);
        builder.create().show();
    }

    private void showEditDialog(Profession profession) {
        View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_add_profession, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Edit Profession");
        builder.setView(dialogView);

        EditText nameInput = dialogView.findViewById(R.id.edit_profession_name);
        EditText introInput = dialogView.findViewById(R.id.edit_profession_intro);
        EditText coursesInput = dialogView.findViewById(R.id.edit_profession_courses);
        EditText requirementsInput = dialogView.findViewById(R.id.edit_profession_requirements);

        nameInput.setText(profession.getName());
        introInput.setText(profession.getIntroDetail());
        coursesInput.setText(profession.getCoursesDetail());
        requirementsInput.setText(profession.getRequirementsDetail());

        builder.setPositiveButton("Save", (dialog, which) -> {
            String name = nameInput.getText().toString();
            String intro = introInput.getText().toString();
            String courses = coursesInput.getText().toString();
            String requirements = requirementsInput.getText().toString();

            if (!name.isEmpty() && !intro.isEmpty() && !courses.isEmpty() && !requirements.isEmpty()) {
                profession.setName(name);
                profession.setIntroDetail(intro);
                profession.setCoursesDetail(courses);
                profession.setRequirementsDetail(requirements);
                professionRepository.updateProfession(profession);
                professions.clear();
                professions.addAll(professionRepository.getAllProfessions());
                professionAdapter.notifyDataSetChanged();
            } else {
                Toast.makeText(getContext(), "All fields are required", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", null);
        builder.create().show();
    }


}
