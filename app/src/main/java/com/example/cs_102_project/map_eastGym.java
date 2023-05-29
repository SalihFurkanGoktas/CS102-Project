package com.example.cs_102_project;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class map_eastGym extends Fragment {

    private TextView eastGymMembers;

    public map_eastGym() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map_east_gym, container, false);
        eastGymMembers = view.findViewById(R.id.eastGymMemberCount);
        eastGymMembers.setText(String.valueOf(MainSharedPref.loadGymEast()));

        return view;
    }
}