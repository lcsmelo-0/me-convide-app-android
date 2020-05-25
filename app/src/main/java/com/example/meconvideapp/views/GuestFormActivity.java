package com.example.meconvideapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.meconvideapp.R;
import com.example.meconvideapp.business.GuestBusiness;
import com.example.meconvideapp.constants.GuestConstants;
import com.example.meconvideapp.entities.GuestEntity;

public class GuestFormActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private GuestBusiness mGuestBusiness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_form);

        this.mViewHolder.mEditName = this.findViewById(R.id.edit_name);
        this.mViewHolder.mRadioNotConfirmed = this.findViewById(R.id.radio_not_confirmed);
        this.mViewHolder.mRadioPresent = this.findViewById(R.id.radio_present);
        this.mViewHolder.mRadioAbsent = this.findViewById(R.id.radio_absent);
        this.mViewHolder.mButtonSave = this.findViewById(R.id.button_save);
        this.mGuestBusiness = new GuestBusiness(this);
        this.setListeners();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button_save){
            this.handleSave();
        }
    }

    private void setListeners(){
        this.mViewHolder.mButtonSave.setOnClickListener(this);
    }

    private void handleSave() {
        GuestEntity guestEntity = new GuestEntity();
        guestEntity.setName(this.mViewHolder.mEditName.getText().toString());

        if(this.mViewHolder.mRadioNotConfirmed.isChecked()){
            guestEntity.setConfirmed(GuestConstants.CONFIRMATION.NOT_CONFIRMED);
        } else if(this.mViewHolder.mRadioPresent.isChecked()){
            guestEntity.setConfirmed(GuestConstants.CONFIRMATION.PRESENT);
        } else{
            guestEntity.setConfirmed(GuestConstants.CONFIRMATION.ABSENT);
        }

        this.mGuestBusiness.insert(guestEntity);
    }

    private static class ViewHolder{
        EditText mEditName;
        RadioButton mRadioNotConfirmed;
        RadioButton mRadioPresent;
        RadioButton mRadioAbsent;
        Button mButtonSave;
    }
}
