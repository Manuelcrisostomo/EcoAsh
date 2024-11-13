// WaterLevelAdapter.java
package com.example.inicio;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class WaterLevelAdapter extends RecyclerView.Adapter<WaterLevelAdapter.ViewHolder> {

    private final ArrayList<WaterLevel> waterLevels;

    public WaterLevelAdapter(ArrayList<WaterLevel> waterLevels) {
        this.waterLevels = waterLevels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        WaterLevel waterLevel = waterLevels.get(position);
        holder.nivelTextView.setText("Nivel: " + waterLevel.getNivel());
        holder.estadoTextView.setText("Estado: " + waterLevel.getEstado());
    }

    @Override
    public int getItemCount() {
        return waterLevels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nivelTextView;
        TextView estadoTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            nivelTextView = itemView.findViewById(android.R.id.text1);
            estadoTextView = itemView.findViewById(android.R.id.text2);
        }
    }
}
