package com.example.cs_102_project;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;


public class map_dormGym extends Fragment {

    private TextView placeHold;
    private TextView placeHold2;
    private TextView placeHold3;



    public map_dormGym() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map_dorm_gym, container, false);
        placeHold = view.findViewById(R.id.placeHoldTest);
        placeHold.setText(String.valueOf(MainSharedPref.loadGymDorm()));
        placeHold = view.findViewById(R.id.placeHoldTest2);
        placeHold.setText(String.valueOf(MainSharedPref.loadGymMain()));
        placeHold = view.findViewById(R.id.placeHoldTest3);
        placeHold.setText(String.valueOf(MainSharedPref.loadGymEast()));
        return view;
    }


}
