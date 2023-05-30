package com.example.cs_102_project;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class map_eastGym extends Fragment {

    private TextView eastGymMembers;

    private Button eastGymBackButton;

    private static final int eastGymMaxCount = 150;

    public map_eastGym() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map_east_gym, container, false);
        eastGymMembers = view.findViewById(R.id.eastGymMemberCount);
        eastGymMembers.setText("Capacity: " + MainSharedPref.loadGymEast() + "/" + eastGymMaxCount);
        backButtonManagement(view);
        return view;
    }

    public void backButtonManagement(View view)
    {
        eastGymBackButton = view.findViewById(R.id.eastGymBackButton);
        eastGymBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Navigation.findNavController(view).navigate(R.id.action_map_eastGym_to_mapFragment_MapScreen);
            }
        });
    }
}