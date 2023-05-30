package com.example.cs_102_project;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MapFragment_MapScreen extends Fragment {


    private Button dormGymNavButton, mainGymNavButton, eastGymNavButton;

    public MapFragment_MapScreen() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map__map_screen, container, false);
        gymFragmentNavManagement(view);

        return view;
    }

    public void gymFragmentNavManagement(View view)
    {
        dormGymNavButton = view.findViewById(R.id.dormGymNavButton);
        dormGymNavButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_mapFragment_MapScreen_to_map_dormGym);
            }
        });
        mainGymNavButton = view.findViewById(R.id.mainGymNavButton);
        mainGymNavButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_mapFragment_MapScreen_to_map_mainGym);
            }
        });
        eastGymNavButton = view.findViewById(R.id.eastGymNavButton);
        eastGymNavButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_mapFragment_MapScreen_to_map_eastGym);
            }
        });

    }
}