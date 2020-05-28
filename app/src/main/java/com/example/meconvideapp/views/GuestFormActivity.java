package com.example.meconvideapp.views;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.meconvideapp.R;
import com.example.meconvideapp.business.GuestBusiness;
import com.example.meconvideapp.constants.GuestConstants;
import com.example.meconvideapp.entities.GuestEntity;

public class GuestFormActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private GuestBusiness mGuestBusiness;
    private int mGuestId;

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
        this.loadDataFromActivity();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_save) {
            this.handleSave();
        }
    }

    private void setListeners() {
        this.mViewHolder.mButtonSave.setOnClickListener(this);
    }

    private void handleSave() {

        if (!this.validateSave()) {
            return;
        }

        GuestEntity guestEntity = new GuestEntity();
        guestEntity.setName(this.mViewHolder.mEditName.getText().toString());

        if (this.mViewHolder.mRadioNotConfirmed.isChecked()) {
            guestEntity.setConfirmed(GuestConstants.CONFIRMATION.NOT_CONFIRMED);
        } else if (this.mViewHolder.mRadioPresent.isChecked()) {
            guestEntity.setConfirmed(GuestConstants.CONFIRMATION.PRESENT);
        } else {
            guestEntity.setConfirmed(GuestConstants.CONFIRMATION.ABSENT);
        }

        if (this.mGuestBusiness.insert(guestEntity)) {
            Toast.makeText(this, getString(R.string.convidado_salvo), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, getString(R.string.erro_salvar), Toast.LENGTH_LONG).show();
        }
        ;

        finish();
    }

    private void loadDataFromActivity() {
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            this.mGuestId = bundle.getInt(GuestConstants.BundleConstants.GUEST_ID);
            GuestEntity guestEntity = this.mGuestBusiness.load(this.mGuestId);
            this.mViewHolder.mEditName.setText(guestEntity.getName());

            if (guestEntity.getConfirmed() == GuestConstants.CONFIRMATION.PRESENT) {
                this.mViewHolder.mRadioPresent.setChecked(true);
            } else if (guestEntity.getConfirmed() == GuestConstants.CONFIRMATION.NOT_CONFIRMED) {
                this.mViewHolder.mRadioNotConfirmed.setChecked(true);
            } else {
                this.mViewHolder.mRadioAbsent.setChecked(true);
            }
        }
    }

    private Boolean validateSave() {
        if (this.mViewHolder.mEditName.getText().toString().equals("")) {
            this.mViewHolder.mEditName.setError(getString(R.string.nome_obrigatorio));
            return false;
        } else {
            return true;
        }
    }

    private static class ViewHolder {
        EditText mEditName;
        RadioButton mRadioNotConfirmed;
        RadioButton mRadioPresent;
        RadioButton mRadioAbsent;
        Button mButtonSave;
    }
}
