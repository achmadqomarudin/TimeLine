package com.achmadqomarudin.timeline;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.AdapterViewHolder> {
    private List<Model> modelList;

    public Adapter(List<Model> modelList) {
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        final Context context = holder.itemView.getContext();
        final Model model = modelList.get(position);
        final int color = ContextCompat.getColor(context,
                model.isHead ? android.R.color.black : android.R.color.darker_gray);
        holder.title.setTextColor(color);
        holder.title.setText(model.text);
        holder.subtitle.setTextColor(color);
        holder.subtitle.setText(model.time);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {
        private TextView title, subtitle;

        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            title    = itemView.findViewById(R.id.title);
            subtitle = itemView.findViewById(R.id.subtitle);
        }
    }
}
