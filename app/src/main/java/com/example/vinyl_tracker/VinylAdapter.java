package com.example.vinyl_tracker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VinylAdapter extends RecyclerView.Adapter<VinylAdapter.VinylViewHolder> {
    private ArrayList<Vinyl> vinylList;

    public VinylAdapter(ArrayList<Vinyl> vinylList) {
        this.vinylList = vinylList;
    }

    public static class VinylViewHolder extends RecyclerView.ViewHolder {
        public TextView vinylNameTextView;
        public TextView vinylArtistTextView;

        public VinylViewHolder(View vinylView) {
            super(vinylView);
            vinylNameTextView = vinylView.findViewById(R.id.vinylName);
            vinylArtistTextView = vinylView.findViewById(R.id.vinylArtist);
        }
    }

    @Override
    public VinylViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vinylView = LayoutInflater.from(parent.getContext()).inflate(R.layout.vinyl_layout, parent, false);
        return new VinylViewHolder(vinylView);
    }

    @Override
    public void onBindViewHolder(VinylViewHolder holder, int position) {
        Vinyl vinyl = vinylList.get(position);
        holder.vinylNameTextView.setText(vinyl.getName());
        holder.vinylArtistTextView.setText(vinyl.getArtist());
    }

    @Override
    public int getItemCount() {
        return vinylList.size();
    }
}