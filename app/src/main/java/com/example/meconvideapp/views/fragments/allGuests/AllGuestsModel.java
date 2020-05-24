package com.example.meconvideapp.views.fragments.allGuests;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AllGuestsModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AllGuestsModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Fragmento de todos os convidados");
    }

    public LiveData<String> getText() {
        return mText;
    }
}