package com.example.meconvideapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meconvideapp.R;
import com.example.meconvideapp.viewHolder.GuestViewHolder;

public class GuestListAdapter  extends RecyclerView.Adapter<GuestViewHolder> {

    @NonNull
    @Override
    public GuestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View carView = layoutInflater.inflate(R.layout.row_guest_list, parent, false);

        return new GuestViewHolder(carView);
    }

    @Override
    public void onBindViewHolder(@NonNull GuestViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
