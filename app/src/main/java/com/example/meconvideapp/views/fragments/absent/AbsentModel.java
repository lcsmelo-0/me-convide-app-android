package com.example.meconvideapp.views.fragments.absent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AbsentModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AbsentModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Fragmento dos ausentes");
    }

    public LiveData<String> getText() {
        return mText;
    }
}