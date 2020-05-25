package com.example.meconvideapp.business;

import android.content.Context;

import com.example.meconvideapp.entities.GuestEntity;
import com.example.meconvideapp.repository.GuestRepository;

public class GuestBusiness {
    private GuestRepository mGuestRepository;
    private Context mContext;

    public GuestBusiness(Context context) {
        this.mContext = context;
        this.mGuestRepository = GuestRepository.getInstance(context);
    }

    public Boolean insert(GuestEntity guestEntity) {

        return this.mGuestRepository.insert(guestEntity);

    }
}
