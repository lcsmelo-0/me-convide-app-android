package com.example.meconvideapp.views.fragments.absent;

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

public class AbsentFragment extends Fragment {

    private ViewHolder mViewHolder = new ViewHolder();
    private GuestBusiness mGuestBusiness;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_absent, container, false);
        Context context = view.getContext();

        //Obtendo o recycler
        this.mViewHolder.mRecyclerAllAbsent = (RecyclerView) view.findViewById(R.id.recycler_absents);

        this.mGuestBusiness = new GuestBusiness(context);

        OnGuestListenerInteractionListener listener = new OnGuestListenerInteractionListener() {

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

        List<GuestEntity> guestEntityList = this.mGuestBusiness.getAbsent();

        //Definindo um adapter
        GuestListAdapter guestListAdapter = new GuestListAdapter(guestEntityList, listener);
        this.mViewHolder.mRecyclerAllAbsent.setAdapter(guestListAdapter);

        //Definindo layout
        this.mViewHolder.mRecyclerAllAbsent.setLayoutManager(new LinearLayoutManager(context));
        return view;

    }

    private static class ViewHolder {
        RecyclerView mRecyclerAllAbsent;
    }
}
