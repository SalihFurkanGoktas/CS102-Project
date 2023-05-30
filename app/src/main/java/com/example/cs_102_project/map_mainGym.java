package com.example.cs_102_project;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class map_mainGym extends Fragment {


    private TextView mainGymMembers;

    private Button mainGymBackButton;

    private static final int mainGymMaxCount = 225;


    public map_mainGym() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map_main_gym, container, false);
        mainGymMembers = view.findViewById(R.id.mainGymMemberCount);
        mainGymMembers.setText("Capacity: " + MainSharedPref.loadGymMain() + "/" + mainGymMaxCount);
        backButtonManagement(view);
        return view;
    }

    public void backButtonManagement(View view)
    {
        mainGymBackButton = view.findViewById(R.id.mainGymBackButton);
        mainGymBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Navigation.findNavController(view).navigate(R.id.action_map_mainGym_to_mapFragment_MapScreen);
            }
        });
    }
}