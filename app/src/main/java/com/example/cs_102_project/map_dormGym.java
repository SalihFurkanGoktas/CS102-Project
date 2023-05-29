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

    private TextView dormGymMembers;




    public map_dormGym() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map_dorm_gym, container, false);
        dormGymMembers = view.findViewById(R.id.dormGymMemberCount);
        dormGymMembers.setText(String.valueOf(MainSharedPref.loadGymDorm()));

        return view;
    }


}
