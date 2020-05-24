package com.example.meconvideapp.views.fragments.absent;

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

public class AbsentFragment extends Fragment {

    private AbsentModel absentModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        absentModel =
                ViewModelProviders.of(this).get(AbsentModel.class);
        View root = inflater.inflate(R.layout.fragment_absent, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        absentModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
