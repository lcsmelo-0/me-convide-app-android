package com.example.meconvideapp.ui.present;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PresentModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PresentModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Fragmento dos presentes");
    }

    public LiveData<String> getText() {
        return mText;
    }
}