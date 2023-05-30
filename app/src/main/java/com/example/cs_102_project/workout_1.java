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
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.cs_102_project.data.WTable_1_Dao;
import com.example.cs_102_project.data.WorkoutDatabase;
import com.example.cs_102_project.data.WorkoutTable_1;

import org.jetbrains.annotations.Nullable;


public class workout_1 extends Fragment implements View.OnClickListener {

    private Spinner inSpinner1, inSpinner2, inSpinner3, inSpinner4, inSpinner5, inSpinner6, inSpinner7, inSpinner8, inSpinner9, inSpinner10;
    private EditText inWeight1, inWeight2, inWeight3, inWeight4, inWeight5, inWeight6, inWeight7, inWeight8, inWeight9, inWeight10;
    private EditText inReps1, inReps2, inReps3, inReps4, inReps5, inReps6, inReps7, inReps8, inReps9, inReps10;

    private WTable_1_Dao wTable1Dao;
    private WorkoutTable_1 WRow1, WRow2, WRow3, WRow4, WRow5, WRow6, WRow7, WRow8, WRow9, WRow10;
    private Button submitBtn, finishBtn, backBtn;

    private WorkoutDatabase workoutDB;


    public workout_1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_workout_1, container, false);

        backBtn = view.findViewById(R.id.backBtn1);

        backBtn.setOnClickListener(this);

        workoutDB = WorkoutDatabase.getInstance(getContext().getApplicationContext());

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

        submitBtn = view.findViewById(R.id.submitBtn1);

        wTable1Dao = workoutDB.W1Dao();
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
        finishBtn = view.findViewById(R.id.finishBtn1);

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
                    if (MainSharedPref.loadIsStreakAvailable() == true)
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

        inWeight1 = view.findViewById(R.id.inWeight1_1);
        inWeight2 = view.findViewById(R.id.inWeight1_2);
        inWeight3 = view.findViewById(R.id.inWeight1_3);
        inWeight4 = view.findViewById(R.id.inWeight1_4);
        inWeight5 = view.findViewById(R.id.inWeight1_5);
        inWeight6 = view.findViewById(R.id.inWeight1_6);
        inWeight7 = view.findViewById(R.id.inWeight1_7);
        inWeight8 = view.findViewById(R.id.inWeight1_8);
        inWeight9 = view.findViewById(R.id.inWeight1_9);
        inWeight10 = view.findViewById(R.id.inWeight1_10);

        inReps1 = view.findViewById(R.id.inReps1_1);
        inReps2 = view.findViewById(R.id.inReps1_2);
        inReps3 = view.findViewById(R.id.inReps1_3);
        inReps4 = view.findViewById(R.id.inReps1_4);
        inReps5 = view.findViewById(R.id.inReps1_5);
        inReps6 = view.findViewById(R.id.inReps1_6);
        inReps7 = view.findViewById(R.id.inReps1_7);
        inReps8 = view.findViewById(R.id.inReps1_8);
        inReps9 = view.findViewById(R.id.inReps1_9);
        inReps10 = view.findViewById(R.id.inReps1_10);

        inSpinner1 = view.findViewById(R.id.workoutSpinner1_1);
        inSpinner2 = view.findViewById(R.id.workoutSpinner1_2);
        inSpinner3 = view.findViewById(R.id.workoutSpinner1_3);
        inSpinner4 = view.findViewById(R.id.workoutSpinner1_4);
        inSpinner5 = view.findViewById(R.id.workoutSpinner1_5);
        inSpinner6 = view.findViewById(R.id.workoutSpinner1_6);
        inSpinner7 = view.findViewById(R.id.workoutSpinner1_7);
        inSpinner8 = view.findViewById(R.id.workoutSpinner1_8);
        inSpinner9 = view.findViewById(R.id.workoutSpinner1_9);
        inSpinner10 = view.findViewById(R.id.workoutSpinner1_10);

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
            WRow1 = new WorkoutTable_1(0, 1, getInt(inWeight1), getInt(inReps1));
            wTable1Dao.addWork(WRow1);
            inWeight1.setHint(null);
            inReps1.setHint(null);
        }
        if (pairIsValid(inWeight2, inReps2)) {
            WRow2 = new WorkoutTable_1(0, 2, getInt(inWeight2), getInt(inReps2));
            wTable1Dao.addWork(WRow2);
            inWeight2.setHint(null);
            inReps2.setHint(null);
        }
        if (pairIsValid(inWeight3, inReps3)) {
            WRow3 = new WorkoutTable_1(0, 3, getInt(inWeight3), getInt(inReps3));
            wTable1Dao.addWork(WRow3);
            inWeight3.setHint(null);
            inReps3.setHint(null);
        }
        if (pairIsValid(inWeight4, inReps4)) {
            WRow4 = new WorkoutTable_1(0, 4, getInt(inWeight4), getInt(inReps4));
            wTable1Dao.addWork(WRow4);
            inWeight4.setHint(null);
            inReps4.setHint(null);
        }
        if (pairIsValid(inWeight5, inReps5)) {
            WRow5 = new WorkoutTable_1(0, 5, getInt(inWeight5), getInt(inReps5));
            wTable1Dao.addWork(WRow5);
            inWeight5.setHint(null);
            inReps5.setHint(null);
        }
        if (pairIsValid(inWeight6, inReps6)) {
            WRow6 = new WorkoutTable_1(0, 6, getInt(inWeight6), getInt(inReps6));
            wTable1Dao.addWork(WRow6);
            inWeight6.setHint(null);
            inReps6.setHint(null);
        }
        if (pairIsValid(inWeight7, inReps7)) {
            WRow7 = new WorkoutTable_1(0, 7, getInt(inWeight7), getInt(inReps7));
            wTable1Dao.addWork(WRow7);
            inWeight7.setHint(null);
            inReps7.setHint(null);
        }
        if (pairIsValid(inWeight8, inReps8)) {
            WRow8 = new WorkoutTable_1(0, 8, getInt(inWeight8), getInt(inReps8));
            wTable1Dao.addWork(WRow8);
            inWeight8.setHint(null);
            inReps8.setHint(null);
        }
        if (pairIsValid(inWeight9, inReps9)) {
            WRow9 = new WorkoutTable_1(0, 9, getInt(inWeight9), getInt(inReps9));
            wTable1Dao.addWork(WRow9);
            inWeight9.setHint(null);
            inReps9.setHint(null);
        }
        if (pairIsValid(inWeight10, inReps10)) {
            WRow10 = new WorkoutTable_1(0, 10, getInt(inWeight10), getInt(inReps10));
            wTable1Dao.addWork(WRow10);
            inWeight10.setHint(null);
            inReps10.setHint(null);
        }
    }
}