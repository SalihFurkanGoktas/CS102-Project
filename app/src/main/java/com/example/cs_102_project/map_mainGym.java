package com.example.cs_102_project;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class map_mainGym extends Fragment {


    private TextView mainGymMembers;
    public map_mainGym() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map_main_gym, container, false);
        mainGymMembers = view.findViewById(R.id.mainGymMemberCount);
        mainGymMembers.setText(String.valueOf(MainSharedPref.loadGymMain()));

        return view;
    }
}