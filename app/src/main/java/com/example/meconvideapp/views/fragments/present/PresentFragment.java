package com.example.meconvideapp.views.fragments.present;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meconvideapp.R;
import com.example.meconvideapp.adapter.GuestListAdapter;
import com.example.meconvideapp.business.GuestBusiness;
import com.example.meconvideapp.constants.GuestConstants;
import com.example.meconvideapp.entities.GuestEntity;
import com.example.meconvideapp.listener.OnGuestListenerInteractionListener;
import com.example.meconvideapp.views.GuestFormActivity;

import java.util.List;

public class PresentFragment extends Fragment {

    private ViewHolder mViewHolder = new ViewHolder();
    private GuestBusiness mGuestBusiness;
    private OnGuestListenerInteractionListener mOnGuestListenerInteractionListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_present, container, false);
        Context context = view.getContext();

        //Obtendo o recycler
        this.mViewHolder.mRecyclerAllPresent = (RecyclerView) view.findViewById(R.id.recycler_presents);

        this.mGuestBusiness = new GuestBusiness(context);

        this.mOnGuestListenerInteractionListener = new OnGuestListenerInteractionListener() {

            @Override
            public void onListClick(int id) {
                //Abrir activity de form
                Bundle bundle = new Bundle();
                bundle.putInt(GuestConstants.BundleConstants.GUEST_ID, id);

                Intent intent = new Intent(getContext(), GuestFormActivity.class);

                intent.putExtras(bundle);
                startActivity(intent);
            }

            @Override
            public void onDeleteClick(int id) {

            }
        };


        //Definindo layout
        this.mViewHolder.mRecyclerAllPresent.setLayoutManager(new LinearLayoutManager(context));
        return view;

    }

    @Override
    public void onResume() {
        super.onResume();

        this.loadGuests();
    }

    private void loadGuests() {
        List<GuestEntity> guestEntityList = this.mGuestBusiness.getPresent();

        //Definindo um adapter
        GuestListAdapter guestListAdapter = new GuestListAdapter(guestEntityList, this.mOnGuestListenerInteractionListener);
        this.mViewHolder.mRecyclerAllPresent.setAdapter(guestListAdapter);
        guestListAdapter.notifyDataSetChanged();

    }


    private static class ViewHolder {
        RecyclerView mRecyclerAllPresent;
    }
}
