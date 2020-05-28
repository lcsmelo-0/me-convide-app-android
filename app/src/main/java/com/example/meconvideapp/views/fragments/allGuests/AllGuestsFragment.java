package com.example.meconvideapp.views.fragments.allGuests;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meconvideapp.R;
import com.example.meconvideapp.adapter.GuestListAdapter;

public class AllGuestsFragment extends Fragment {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view=  inflater.inflate(R.layout.fragment_all_guests, container, false);
        Context context = view.getContext();
        this.mViewHolder.mRecyclerAllInvited = (RecyclerView) view.findViewById(R.id.recycler_all_guests);

        GuestListAdapter guestListAdapter = new GuestListAdapter();
        this.mViewHolder.mRecyclerAllInvited.setAdapter(guestListAdapter);

        this.mViewHolder.mRecyclerAllInvited.setLayoutManager(new LinearLayoutManager(context));
        return view;

    }

    private static class ViewHolder{
        RecyclerView mRecyclerAllInvited;
    }
}
