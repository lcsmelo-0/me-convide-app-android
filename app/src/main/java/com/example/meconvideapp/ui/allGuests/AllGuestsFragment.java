package com.example.meconvideapp.ui.allGuests;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.meconvideapp.R;

public class AllGuestsFragment extends Fragment {

    private AllGuestsModel allGuestsModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        allGuestsModel =
                ViewModelProviders.of(this).get(AllGuestsModel.class);
        View root = inflater.inflate(R.layout.fragment_all_guests, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        allGuestsModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
