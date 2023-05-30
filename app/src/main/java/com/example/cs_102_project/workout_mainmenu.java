package com.example.cs_102_project;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.cs_102_project.data.WorkoutDatabase;

import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link workout_mainmenu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class workout_mainmenu extends Fragment implements View.OnClickListener {

    private Button button1, button2, button3, button4, button5, button6;
    private RadioButton radioButtonGymMain, radioButtonGymDorm, radioButtonGymEast;

    private WorkoutDatabase workoutDB;



    public workout_mainmenu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_workout_mainmenu, container, false);

        button1 = view.findViewById(R.id.buttonW1);
        button2 = view.findViewById(R.id.buttonW2);
        button3 = view.findViewById(R.id.buttonW3);
        button4 = view.findViewById(R.id.buttonW4);
        button5 = view.findViewById(R.id.buttonW5);
        button6 = view.findViewById(R.id.buttonW6);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);

        radioButtonSetUp(view);

        Button showInfoButton = view.findViewById(R.id.showInfoButton);

        // Set the OnClickListener
        showInfoButton.setOnClickListener(this);

        workoutDB = WorkoutDatabase.getInstance(getContext().getApplicationContext());

        return view;


    }

    @Override
    public void onClick(View view) {

        NavController navController = Navigation.findNavController(view);

        if (view.getId() == R.id.buttonW1) navController.navigate(R.id.action_workout_mainmenu2_to_workout_1);
        else if (view.getId() == R.id.buttonW2) navController.navigate(R.id.action_workout_mainmenu2_to_workout_2);
        else if (view.getId() == R.id.buttonW3) navController.navigate(R.id.action_workout_mainmenu2_to_workout_3);
        else if (view.getId() == R.id.buttonW4) navController.navigate(R.id.action_workout_mainmenu2_to_workout_4);
        else if (view.getId() == R.id.buttonW5) navController.navigate(R.id.action_workout_mainmenu2_to_workout_5);
        else if (view.getId() == R.id.buttonW6) navController.navigate(R.id.action_workout_mainmenu2_to_workout_6);

        else if (view.getId() == R.id.showInfoButton) {

            showList();
        }

    }

    public void radioButtonSetUp(View view)
    {
        radioButtonGymMain = view.findViewById(R.id.radioButtonMainGym);
        radioButtonGymDorm = view.findViewById(R.id.radioButtonDormGym);
        radioButtonGymEast = view.findViewById(R.id.radioButtonEastGym);

        int tempGymSelect = MainSharedPref.loadGymSelection();
        if (tempGymSelect == 0)
        {
            radioButtonGymMain.setChecked(true);
        }
        else if (tempGymSelect == 1)
        {
            radioButtonGymDorm.setChecked(true);
        }
        else if (tempGymSelect == 2)
        {
            radioButtonGymEast.setChecked(true);
        }

        radioButtonGymMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { MainSharedPref.saveGymSelection(0); }
        });
        radioButtonGymDorm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { MainSharedPref.saveGymSelection(1); }
        });
        radioButtonGymEast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { MainSharedPref.saveGymSelection(2); }
        });

    }

    public void showList()  //Using two dialog builders to show the names and details.
    {
        final String[] exercises = getResources().getStringArray(R.array.exercise_array);

        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Exercise List");
        builder.setItems(exercises, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int position) {
                String selectedExercise = exercises[position];
                showExerciseInfo(selectedExercise);
            }
        });

        builder.show();
    }


    public void showExerciseInfo(String exerciseName)
    {



        String[] exerciseArray = getResources().getStringArray(R.array.exercise_array);
        String[] exerciseDetailsArray = getResources().getStringArray(R.array.exercise_details_array);

        int index = Arrays.asList(exerciseArray).indexOf(exerciseName);         //exerciseDetailsArray için gereken index

        String exerciseDetails = exerciseDetailsArray[index];

        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());


        builder.setTitle(exerciseName);
        builder.setMessage(exerciseDetails);
        builder.show();
    }






}