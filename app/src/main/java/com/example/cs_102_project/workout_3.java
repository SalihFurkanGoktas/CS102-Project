package com.example.cs_102_project;

import android.os.Bundle;
import android.text.TextUtils;
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

import com.example.cs_102_project.data.WTable_3_Dao;
import com.example.cs_102_project.data.WorkoutDatabase;
import com.example.cs_102_project.data.WorkoutTable_3;

import org.jetbrains.annotations.Nullable;


public class workout_3 extends Fragment implements View.OnClickListener {

    private Spinner inSpinner1, inSpinner2, inSpinner3, inSpinner4, inSpinner5, inSpinner6, inSpinner7, inSpinner8, inSpinner9, inSpinner10;
    private EditText inWeight1, inWeight2, inWeight3, inWeight4, inWeight5, inWeight6, inWeight7, inWeight8, inWeight9, inWeight10;
    private EditText inReps1, inReps2, inReps3, inReps4, inReps5, inReps6, inReps7, inReps8, inReps9, inReps10;

    private WTable_3_Dao wTable3Dao;
    private WorkoutTable_3 WRow1, WRow2, WRow3, WRow4, WRow5, WRow6, WRow7, WRow8, WRow9, WRow10;
    private Button submitBtn, finishBtn, backBtn;

    private WorkoutDatabase workoutDB;


    public workout_3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_workout_3, container, false);

        //backBtn = view.findViewById(R.id.backBtn1);

        //backBtn.setOnClickListener(this);

        workoutDB = WorkoutDatabase.getInstance(getContext().getApplicationContext());

        return view;
    }

    @Override
    public void onClick(View view) {

        //NavController navCtrl = Navigation.findNavController(view);

        //if (view.getId() == backBtn.getId())
        //    navCtrl.popBackStack();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) { //@NonNull View view

        initMoveWeightRep(view);

        submitBtn = view.findViewById(R.id.submitBtn3);

        wTable3Dao = workoutDB.W3Dao();
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertIntoDB();
            }
        });

        finishButtonManagement(view);
    }

    public void finishButtonManagement(View view)
    {
        finishBtn = view.findViewById(R.id.finishBtn3);

        if (!MainSharedPref.loadIsExercising())
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
                if (!MainSharedPref.loadIsExercising())
                {
                    if (MainSharedPref.loadIsStreakAvailable())
                    {
                        MainSharedPref.saveStreak(MainSharedPref.loadStreak() + 1);
                        MainSharedPref.saveIsStreakAvailable(false);
                        MainSharedPref.saveStreakInitialTime();
                    }
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

        inWeight1 = view.findViewById(R.id.inWeight3_1);
        inWeight2 = view.findViewById(R.id.inWeight3_2);
        inWeight3 = view.findViewById(R.id.inWeight3_3);
        inWeight4 = view.findViewById(R.id.inWeight3_4);
        inWeight5 = view.findViewById(R.id.inWeight3_5);
        inWeight6 = view.findViewById(R.id.inWeight3_6);
        inWeight7 = view.findViewById(R.id.inWeight3_7);
        inWeight8 = view.findViewById(R.id.inWeight3_8);
        inWeight9 = view.findViewById(R.id.inWeight3_9);
        inWeight10 = view.findViewById(R.id.inWeight3_10);

        inReps1 = view.findViewById(R.id.inReps3_1);
        inReps2 = view.findViewById(R.id.inReps3_2);
        inReps3 = view.findViewById(R.id.inReps3_3);
        inReps4 = view.findViewById(R.id.inReps3_4);
        inReps5 = view.findViewById(R.id.inReps3_5);
        inReps6 = view.findViewById(R.id.inReps3_6);
        inReps7 = view.findViewById(R.id.inReps3_7);
        inReps8 = view.findViewById(R.id.inReps3_8);
        inReps9 = view.findViewById(R.id.inReps3_9);
        inReps10 = view.findViewById(R.id.inReps3_10);

        inSpinner1 = view.findViewById(R.id.workoutSpinner3_1);
        inSpinner2 = view.findViewById(R.id.workoutSpinner3_2);
        inSpinner3 = view.findViewById(R.id.workoutSpinner3_3);
        inSpinner4 = view.findViewById(R.id.workoutSpinner3_4);
        inSpinner5 = view.findViewById(R.id.workoutSpinner3_5);
        inSpinner6 = view.findViewById(R.id.workoutSpinner3_6);
        inSpinner7 = view.findViewById(R.id.workoutSpinner3_7);
        inSpinner8 = view.findViewById(R.id.workoutSpinner3_8);
        inSpinner9 = view.findViewById(R.id.workoutSpinner3_9);
        inSpinner10 = view.findViewById(R.id.workoutSpinner3_10);

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

    public int getInt(EditText textField) {
        return Integer.parseInt(textField.getText().toString());
    }

    public boolean pairIsValid(EditText WeightField, EditText RepField) {

        return (TextUtils.isDigitsOnly(WeightField.getText().toString()) && WeightField.getText().toString().length() != 0) &&
                (TextUtils.isDigitsOnly(RepField.getText().toString()) && RepField.getText().toString().length() != 0);
    }

    public void insertIntoDB() {

        if (pairIsValid(inWeight1, inReps1)) {
            WRow1 = new WorkoutTable_3(0, inSpinner1.getSelectedItem().toString(), 1, getInt(inWeight1), getInt(inReps1));
            wTable3Dao.addWork(WRow1);
            inWeight1.setHint(null);
            inReps1.setHint(null);
        }
        if (pairIsValid(inWeight2, inReps2)) {
            WRow2 = new WorkoutTable_3(0, inSpinner2.getSelectedItem().toString(), 2, getInt(inWeight2), getInt(inReps2));
            wTable3Dao.addWork(WRow2);
            inWeight2.setHint(null);
            inReps2.setHint(null);
        }
        if (pairIsValid(inWeight3, inReps3)) {
            WRow3 = new WorkoutTable_3(0, inSpinner3.getSelectedItem().toString(), 3, getInt(inWeight3), getInt(inReps3));
            wTable3Dao.addWork(WRow3);
            inWeight3.setHint(null);
            inReps3.setHint(null);
        }
        if (pairIsValid(inWeight4, inReps4)) {
            WRow4 = new WorkoutTable_3(0, inSpinner4.getSelectedItem().toString(), 4, getInt(inWeight4), getInt(inReps4));
            wTable3Dao.addWork(WRow4);
            inWeight4.setHint(null);
            inReps4.setHint(null);
        }
        if (pairIsValid(inWeight5, inReps5)) {
            WRow5 = new WorkoutTable_3(0, inSpinner5.getSelectedItem().toString(),5, getInt(inWeight5), getInt(inReps5));
            wTable3Dao.addWork(WRow5);
            inWeight5.setHint(null);
            inReps5.setHint(null);
        }
        if (pairIsValid(inWeight6, inReps6)) {
            WRow6 = new WorkoutTable_3(0, inSpinner6.getSelectedItem().toString(),6, getInt(inWeight6), getInt(inReps6));
            wTable3Dao.addWork(WRow6);
            inWeight6.setHint(null);
            inReps6.setHint(null);
        }
        if (pairIsValid(inWeight7, inReps7)) {
            WRow7 = new WorkoutTable_3(0, inSpinner7.getSelectedItem().toString(),7, getInt(inWeight7), getInt(inReps7));
            wTable3Dao.addWork(WRow7);
            inWeight7.setHint(null);
            inReps7.setHint(null);
        }
        if (pairIsValid(inWeight8, inReps8)) {
            WRow8 = new WorkoutTable_3(0, inSpinner8.getSelectedItem().toString(),8, getInt(inWeight8), getInt(inReps8));
            wTable3Dao.addWork(WRow8);
            inWeight8.setHint(null);
            inReps8.setHint(null);
        }
        if (pairIsValid(inWeight9, inReps9)) {
            WRow9 = new WorkoutTable_3(0, inSpinner9.getSelectedItem().toString(), 9, getInt(inWeight9), getInt(inReps9));
            wTable3Dao.addWork(WRow9);
            inWeight9.setHint(null);
            inReps9.setHint(null);
        }
        if (pairIsValid(inWeight10, inReps10)) {
            WRow10 = new WorkoutTable_3(0, inSpinner10.getSelectedItem().toString(),10, getInt(inWeight10), getInt(inReps10));
            wTable3Dao.addWork(WRow10);
            inWeight10.setHint(null);
            inReps10.setHint(null);
        }
    }
}