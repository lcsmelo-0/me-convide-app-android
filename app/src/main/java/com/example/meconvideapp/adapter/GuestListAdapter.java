package com.example.meconvideapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meconvideapp.R;
import com.example.meconvideapp.entities.GuestEntity;
import com.example.meconvideapp.listener.OnGuestListenerInteractionListener;
import com.example.meconvideapp.viewHolder.GuestViewHolder;

import java.util.List;

public class GuestListAdapter  extends RecyclerView.Adapter<GuestViewHolder> {

    private List<GuestEntity> mGuestEntityList;
    private OnGuestListenerInteractionListener mOnGuestListenerInteractionListener;

    public GuestListAdapter(List<GuestEntity> guestEntityList, OnGuestListenerInteractionListener listener){
        this.mGuestEntityList = guestEntityList;
        this.mOnGuestListenerInteractionListener = listener;
    }

    @NonNull
    @Override
    public GuestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View carView = layoutInflater.inflate(R.layout.row_guest_list, parent, false);

        return new GuestViewHolder(carView, context);
    }

    @Override
    public void onBindViewHolder(@NonNull GuestViewHolder holder, int position) {
        GuestEntity guestEntity = this.mGuestEntityList.get(position);
        holder.bindData(guestEntity, mOnGuestListenerInteractionListener);
    }

    @Override
    public int getItemCount() {
        return this.mGuestEntityList.size();
    }
}
