package com.jaloldo.emulister;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class EmulatorsAdapter extends RecyclerView.Adapter<EmulatorsAdapter.ViewHolder> {
    private List<EmulatorItem> emulators;
    private Context context;

    public EmulatorsAdapter(List<EmulatorItem> emulators, Context context) {
        this.emulators = emulators;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_emulator, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        EmulatorItem emulator = emulators.get(position);
        holder.nameText.setText(emulator.getName());
        holder.systemText.setText(emulator.getSystem());
        holder.ratingBar.setRating(Float.parseFloat(emulator.getRating()));
        
        Glide.with(context)
                .load(emulator.getImageUrl())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return emulators.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView nameText;
        public TextView systemText;
        public RatingBar ratingBar;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.emulator_image);
            nameText = itemView.findViewById(R.id.emulator_name);
            systemText = itemView.findViewById(R.id.emulator_system);
            ratingBar = itemView.findViewById(R.id.emulator_rating);
        }
    }
}