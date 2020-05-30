package com.example.meconvideapp.views.fragments.allGuests;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meconvideapp.R;
import com.example.meconvideapp.adapter.GuestListAdapter;
import com.example.meconvideapp.business.GuestBusiness;
import com.example.meconvideapp.constants.GuestConstants;
import com.example.meconvideapp.entities.GuestCount;
import com.example.meconvideapp.entities.GuestEntity;
import com.example.meconvideapp.listener.OnGuestListenerInteractionListener;
import com.example.meconvideapp.views.GuestFormActivity;

import java.util.List;

public class AllGuestsFragment extends Fragment {

    private ViewHolder mViewHolder = new ViewHolder();
    private GuestBusiness mGuestBusiness;
    private OnGuestListenerInteractionListener mOnGuestListenerInteractionListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_guests, container, false);
        Context context = view.getContext();

        //Obtendo o recycler
        this.mViewHolder.mRecyclerAllInvited = (RecyclerView) view.findViewById(R.id.recycler_all_guests);
        this.mViewHolder.mTextPresentCount = (TextView) view.findViewById(R.id.text_present_count);
        this.mViewHolder.mTextAbsentCount = (TextView) view.findViewById(R.id.text_absent_count);
        this.mViewHolder.mTextAllInvitedCount = (TextView) view.findViewById(R.id.text_all_invited_count);

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
                mGuestBusiness.remove(id);

                Toast.makeText(getContext(), getString(R.string.covidado_removido), Toast.LENGTH_LONG).show();
                loadDashboard();
                loadGuests();
            }
        };


        //Definindo layout
        this.mViewHolder.mRecyclerAllInvited.setLayoutManager(new LinearLayoutManager(context));
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        this.loadDashboard();
        this.loadGuests();
    }


    private void loadGuests() {
        List<GuestEntity> guestEntityList = this.mGuestBusiness.getInvited();

        //Definindo um adapter
        GuestListAdapter guestListAdapter = new GuestListAdapter(guestEntityList, this.mOnGuestListenerInteractionListener);
        this.mViewHolder.mRecyclerAllInvited.setAdapter(guestListAdapter);
        guestListAdapter.notifyDataSetChanged();
    }


    private void loadDashboard() {
        GuestCount guestCount = this.mGuestBusiness.loadDashboard();
        this.mViewHolder.mTextAllInvitedCount.setText(String.valueOf(guestCount.getAllInvitedCount()));
        this.mViewHolder.mTextPresentCount.setText(String.valueOf(guestCount.getPresentCount()));
        this.mViewHolder.mTextAbsentCount.setText(String.valueOf(guestCount.getAbsentCount()));
    }

    private static class ViewHolder {
        RecyclerView mRecyclerAllInvited;
        TextView mTextPresentCount;
        TextView mTextAbsentCount;
        TextView mTextAllInvitedCount;

    }
}
