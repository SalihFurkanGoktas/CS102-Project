package com.example.cs_102_project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import org.jetbrains.annotations.Nullable;


public class workout_2 extends Fragment implements View.OnClickListener {

    private Spinner inSpinner1, inSpinner2, inSpinner3, inSpinner4, inSpinner5, inSpinner6, inSpinner7, inSpinner8, inSpinner9, inSpinner10;
    private EditText inWeight1, inWeight2, inWeight3, inWeight4, inWeight5, inWeight6, inWeight7, inWeight8, inWeight9, inWeight10;
    private EditText inReps1, inReps2, inReps3, inReps4, inReps5, inReps6, inReps7, inReps8, inReps9, inReps10;
    private Button submitBtn, finishBtn, backBtn;


    public workout_2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_workout_2, container, false);

        backBtn = view.findViewById(R.id.backBtn2);

        backBtn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        NavController navCtrl = Navigation.findNavController(view);

        if (view.getId() == backBtn.getId())
            navCtrl.popBackStack();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        initMoveWeightRep(view);

        submitBtn = view.findViewById(R.id.submitBtn2);

        finishButtonManagement(view);

    }

    public void finishButtonManagement(View view)
    {
        finishBtn = view.findViewById(R.id.finishBtn2);

        if (MainSharedPref.loadIsExercising() == false)
        {
            finishBtn.setText("Start");
        }
        else
        {
            finishBtn.setText("Stop");
        }



        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MainSharedPref.loadIsExercising() == false)
                {
                    MainSharedPref.saveStreak(MainSharedPref.loadStreak() + 1);
                    MainSharedPref.incrementGymCount();
                    MainSharedPref.saveIsExercising(true);
                    finishBtn.setText("Stop");
                }
                else
                {
                    MainSharedPref.decrementGymCount();
                    MainSharedPref.saveIsExercising(false);
                    finishBtn.setText("Start");
                }
            }
        });
    }

    public void initMoveWeightRep(View view) {

        inWeight1 = view.findViewById(R.id.inWeight2_1);
        inWeight2 = view.findViewById(R.id.inWeight2_2);
        inWeight3 = view.findViewById(R.id.inWeight2_3);
        inWeight4 = view.findViewById(R.id.inWeight2_4);
        inWeight5 = view.findViewById(R.id.inWeight2_5);
        inWeight6 = view.findViewById(R.id.inWeight2_6);
        inWeight7 = view.findViewById(R.id.inWeight2_7);
        inWeight8 = view.findViewById(R.id.inWeight2_8);
        inWeight9 = view.findViewById(R.id.inWeight2_9);
        inWeight10 = view.findViewById(R.id.inWeight2_10);

        inReps1 = view.findViewById(R.id.inReps2_1);
        inReps2 = view.findViewById(R.id.inReps2_2);
        inReps3 = view.findViewById(R.id.inReps2_3);
        inReps4 = view.findViewById(R.id.inReps2_4);
        inReps5 = view.findViewById(R.id.inReps2_5);
        inReps6 = view.findViewById(R.id.inReps2_6);
        inReps7 = view.findViewById(R.id.inReps2_7);
        inReps8 = view.findViewById(R.id.inReps2_8);
        inReps9 = view.findViewById(R.id.inReps2_9);
        inReps10 = view.findViewById(R.id.inReps2_10);

        inSpinner1 = view.findViewById(R.id.workoutSpinner2_1);
        inSpinner2 = view.findViewById(R.id.workoutSpinner2_2);
        inSpinner3 = view.findViewById(R.id.workoutSpinner2_3);
        inSpinner4 = view.findViewById(R.id.workoutSpinner2_4);
        inSpinner5 = view.findViewById(R.id.workoutSpinner2_5);
        inSpinner6 = view.findViewById(R.id.workoutSpinner2_6);
        inSpinner7 = view.findViewById(R.id.workoutSpinner2_7);
        inSpinner8 = view.findViewById(R.id.workoutSpinner2_8);
        inSpinner9 = view.findViewById(R.id.workoutSpinner2_9);
        inSpinner10 = view.findViewById(R.id.workoutSpinner2_10);


        ArrayAdapter<CharSequence> workoutAdapter = ArrayAdapter.createFromResource(requireContext(), R.array.workout_array, android.R.layout.simple_spinner_item);
        workoutAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        inSpinner1.setAdapter(workoutAdapter);
        inSpinner2.setAdapter(workoutAdapter);
        inSpinner3.setAdapter(workoutAdapter);
        inSpinner4.setAdapter(workoutAdapter);
        inSpinner5.setAdapter(workoutAdapter);
        inSpinner6.setAdapter(workoutAdapter);
        inSpinner7.setAdapter(workoutAdapter);
        inSpinner8.setAdapter(workoutAdapter);
        inSpinner9.setAdapter(workoutAdapter);
        inSpinner10.setAdapter(workoutAdapter);
    }
}