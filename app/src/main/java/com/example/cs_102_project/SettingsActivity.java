package com.example.cs_102_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SettingsActivity extends AppCompatActivity {


    //Navigation Buttons
    private ImageButton mapSwitch;
    private ImageButton workoutSwitch;
    private ImageButton mainSwitch;
    private ImageButton streakSwitch;
    private ImageButton settingsSwitch;


    //Settings Menu Buttons
    private Button resetStreakButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        bottomNavButtonManagement();

        settingsButtonManagement();
    }

    private void settingsButtonManagement()
    {
        resetStreakButton = findViewById(R.id.resetStreakButton);
        resetStreakButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                MainSharedPref.saveStreak(0);
            }
        });
    }




    private void bottomNavButtonManagement()
    {
        mapSwitch = findViewById(R.id.Settings_toMap);
        mapSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivity(mapSwitch);
            }
        });
        workoutSwitch = findViewById(R.id.Settings_toWorkout);
        workoutSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivity(workoutSwitch);
            }
        });
        mainSwitch = findViewById(R.id.Settings_toMain);
        mainSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivity(mainSwitch);
            }
        });
        streakSwitch = findViewById(R.id.Settings_toStreak);
        streakSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { switchActivity(streakSwitch); }
        });
        settingsSwitch = findViewById(R.id.Settings_toSettings);
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