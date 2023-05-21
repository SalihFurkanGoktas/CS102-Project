package com.example.cs_102_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class WorkoutActivity extends AppCompatActivity {

    private ImageButton mapSwitch;
    private ImageButton workoutSwitch;
    private ImageButton mainSwitch;
    private ImageButton streakSwitch;
    private ImageButton settingsSwitch;



    //// TEST PURPOSES - Feel free to erase.
    private Button testGymButton;
    private DatabaseReference testDataRef2;
    private int testCurrentVal;
    private static boolean firstClick = true;
    ////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);



        bottomNavButtonManagement();



        //// TEST PURPOSES - Feel free to erase.
        testDataRef2 = FirebaseDatabase.getInstance("https://cs102-73984-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Gym1");
        testGymButton = findViewById(R.id.gymAddButton);
        replaceText();
        gymButtonMan();
        if (firstClick)
        {
            testGymButton.setText("START");
        }
        else
        {
            testGymButton.setText("STOP");
        }
        ////

    }

    // TEST PURPOSES - Feel free to erase.
    private void gymButtonMan()
    {
        testGymButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if (firstClick)
                {
                    testDataRef2.setValue(testCurrentVal + 1);
                    firstClick = false;
                    testGymButton.setText("STOP");
                }
                else
                {
                    testDataRef2.setValue(testCurrentVal - 1);
                    firstClick = true;
                    testGymButton.setText("START");
                }

            }
        });
    }

    // TEST PURPOSES - Feel free to erase.
    private void replaceText()
    {
        testDataRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot snapshot) {

                testCurrentVal = snapshot.getValue(Integer.class);

            }

            @Override
            public void onCancelled( DatabaseError error) {}
        });
    }





    private void bottomNavButtonManagement()
    {
        mapSwitch = findViewById(R.id.Workout_toMap);
        mapSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivity(mapSwitch);
            }
        });
        workoutSwitch = findViewById(R.id.Workout_toWorkout);
        workoutSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivity(workoutSwitch);
            }
        });
        mainSwitch = findViewById(R.id.Workout_toMain);
        mainSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivity(mainSwitch);
            }
        });
        streakSwitch = findViewById(R.id.Workout_toStreak);
        streakSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { switchActivity(streakSwitch); }
        });
        settingsSwitch = findViewById(R.id.Workout_toSettings);
        settingsSwitch .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { switchActivity(settingsSwitch); }
        });
    }



    private void switchActivity(ImageButton imgBut) {
        if (imgBut.equals(mapSwitch))
        {
            Intent switchActivityIntent = new Intent(this, MapActivity.class);
            startActivity(switchActivityIntent);
        }
        else if (imgBut.equals(workoutSwitch))
        {
            Intent switchActivityIntent = new Intent(this, WorkoutActivity.class);
            startActivity(switchActivityIntent);
        }
        else if (imgBut.equals(mainSwitch))
        {
            Intent switchActivityIntent = new Intent(this, MainActivity.class);
            startActivity(switchActivityIntent);
        }
        else if (imgBut.equals(streakSwitch))
        {
            Intent switchActivityIntent = new Intent(this, StreakActivity.class);
            startActivity(switchActivityIntent);
        }
        else if (imgBut.equals(settingsSwitch))
        {
            Intent switchActivityIntent = new Intent(this, SettingsActivity.class);
            startActivity(switchActivityIntent);
        }

    }



}