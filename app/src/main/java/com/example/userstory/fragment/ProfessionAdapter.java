package com.example.userstory.fragment;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userstory.R;

import java.util.List;

public class ProfessionAdapter extends RecyclerView.Adapter<ProfessionAdapter.ProfessionViewHolder> {

    private final List<Profession> professionList;
    private final OnItemClickListener onItemClickListener;
    private final OnItemLongClickListener onItemLongClickListener;

    public interface OnItemClickListener {
        void onItemClick(Profession profession);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(Profession profession);
    }

    public ProfessionAdapter(List<Profession> professionList) {
        this(professionList,  null);
    }
    public ProfessionAdapter(List<Profession> professionList, OnItemClickListener onItemClickListener) {
        this(professionList, onItemClickListener, null);
    }

    public ProfessionAdapter(List<Profession> professionList, OnItemClickListener onItemClickListener, OnItemLongClickListener onItemLongClickListener) {
        this.professionList = professionList;
        this.onItemClickListener = onItemClickListener;
        this.onItemLongClickListener = onItemLongClickListener;
    }

    @NonNull
    @Override
    public ProfessionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_profession, parent, false);
        return new ProfessionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfessionViewHolder holder, int position) {
        Profession profession = professionList.get(position);
        holder.bind(profession, onItemClickListener, onItemLongClickListener);
    }

    @Override
    public int getItemCount() {
        return professionList.size();
    }

    static class ProfessionViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private final TextView textView;

        public ProfessionViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            textView = itemView.findViewById(R.id.text_view);
        }

        public void bind(Profession profession, OnItemClickListener onItemClickListener, OnItemLongClickListener onItemLongClickListener) {
            imageView.setImageResource(profession.getImageResId());
            textView.setText(profession.getName());
            itemView.setOnClickListener(v -> onItemClickListener.onItemClick(profession));
            if (onItemLongClickListener != null) {
                itemView.setOnLongClickListener(v -> {
                    onItemLongClickListener.onItemLongClick(profession);
                    return true;
                });
            }
        }
    }
}
