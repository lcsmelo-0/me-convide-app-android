package com.example.meconvideapp.business;

import android.content.Context;

import com.example.meconvideapp.constants.DataBaseConstants;
import com.example.meconvideapp.constants.GuestConstants;
import com.example.meconvideapp.entities.GuestEntity;
import com.example.meconvideapp.repository.GuestRepository;

import java.util.List;

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

    public Boolean update(GuestEntity guestEntity){
        return this.mGuestRepository.update(guestEntity);
    }

    public Boolean remove(int id){
        return this.mGuestRepository.remove(id);
    }

    public List<GuestEntity> getInvited() {
        return this.mGuestRepository.getGuestsByQuery("select * from " + DataBaseConstants.GUEST.TABLE_NAME);
    }

    public List<GuestEntity> getAbsent() {
        return this.mGuestRepository.getGuestsByQuery("select * from " + DataBaseConstants.GUEST.TABLE_NAME + " where "
                + DataBaseConstants.GUEST.COLUMNS.PRESENCE + " = " + GuestConstants.CONFIRMATION.ABSENT);
    }

    public List<GuestEntity> getPresent() {
        return this.mGuestRepository.getGuestsByQuery("select * from " + DataBaseConstants.GUEST.TABLE_NAME + " where "
                + DataBaseConstants.GUEST.COLUMNS.PRESENCE + " = " + GuestConstants.CONFIRMATION.PRESENT);
    }

    public GuestEntity load(int id) {
        return this.mGuestRepository.load(id);
    }
}
