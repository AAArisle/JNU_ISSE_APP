// 【专业】页面的adapter
package com.example.userstory.object;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userstory.R;

import java.util.List;

public class ProfessionAdapter extends RecyclerView.Adapter<ProfessionAdapter.ProfessionViewHolder> {
    private List<Profession> professions;
    private OnProfessionClickListener listener;

    public interface OnProfessionClickListener {
        void onProfessionClick(Profession profession);
    }

    public ProfessionAdapter(List<Profession> professions, OnProfessionClickListener listener) {
        this.professions = professions;
        this.listener = listener;
    }

    @Override
    public ProfessionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_profession, parent, false);
        return new ProfessionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProfessionViewHolder holder, int position) {
        Profession profession = professions.get(position);
        holder.textView.setText(profession.getName());
        holder.imageView.setImageResource(profession.getImageResId());
        holder.cardView.setOnClickListener(v -> listener.onProfessionClick(profession));
    }

    @Override
    public int getItemCount() {
        return professions.size();
    }
    public void updateProfessions(List<Profession> newProfessions) {
        this.professions = newProfessions;
        notifyDataSetChanged();
    }


    public static class ProfessionViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public ImageView imageView;
        public TextView textView;

        public ProfessionViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            imageView = itemView.findViewById(R.id.image_view);
            textView = itemView.findViewById(R.id.text_view);
        }
    }
}
