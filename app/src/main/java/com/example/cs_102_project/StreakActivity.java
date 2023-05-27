package com.example.cs_102_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class StreakActivity extends AppCompatActivity {

    private ImageButton mapSwitch;
    private ImageButton workoutSwitch;
    private ImageButton mainSwitch;
    private ImageButton streakSwitch;
    private ImageButton settingsSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_streak);

        bottomNavButtonManagement();
    }


    private void bottomNavButtonManagement()
    {
        mapSwitch = findViewById(R.id.Streak_toMap);
        mapSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivity(mapSwitch);
            }
        });
        workoutSwitch = findViewById(R.id.Streak_toWorkout);
        workoutSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivity(workoutSwitch);
            }
        });
        mainSwitch = findViewById(R.id.Streak_toMain);
        mainSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivity(mainSwitch);
            }
        });
        streakSwitch = findViewById(R.id.Streak_toStreak);
        streakSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { switchActivity(streakSwitch); }
        });
        settingsSwitch = findViewById(R.id.Streak_toSettings);
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