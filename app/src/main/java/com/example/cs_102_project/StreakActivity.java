package com.example.cs_102_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Date;

public class StreakActivity extends AppCompatActivity {

    private ImageButton mapSwitch;
    private ImageButton workoutSwitch;
    private ImageButton mainSwitch;
    private ImageButton streakSwitch;
    private ImageButton settingsSwitch;

    private int streak = 0;
    private GridLayout gridCrosses;
    private int imagesPerRow = 1; //?????? SHOULD WORK WHEN IT'S 7 BUT ONLY WORKS WHEN IT'S 1  DON'T TOUCH THIS
    private int currentRow = 0;
    private long lastExerciseTimestamp = 0; //To see when exactly the user last exercised.
    private LinearLayout currentLinearLayout;

    private int imageWidth = 100;  // Adjust the desired image width
    private int imageHeight  = 100;

        //can be deleted probably
//    private static final String PREFS_NAME = "Preferences";
//    private static final String STREAK_KEY = "streak";
//    private static final String CROSS_IMAGE_KEY = "cross_image_";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_streak);

        bottomNavButtonManagement();

        gridCrosses = findViewById(R.id.gridCrosses);

        streak = MainSharedPref.loadStreak();
        updateStreakTextView();
        displayCrosses();
    }

    public void completeSession(View view)
    {


        long currentTimestamp = new Date().getTime();   //sees current time


        if (currentLinearLayout == null || currentLinearLayout.getChildCount() >= imagesPerRow) {
            // Create a new row LinearLayout
            currentLinearLayout = new LinearLayout(this);
            currentLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
            gridCrosses.addView(currentLinearLayout);
            currentRow++;
        }

        // Create a new ImageView for the cross icon
        ImageView crossImageView = new ImageView(this);
        crossImageView.setImageResource(R.drawable.ic_cross_background);

        crossImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(imageWidth, imageHeight);
        layoutParams.setMargins(5, 5, 5, 5); // Add margin between crosses
        crossImageView.setLayoutParams(layoutParams);

        // Add the new cross ImageView to the current row LinearLayout
        currentLinearLayout.addView(crossImageView);

        if (currentLinearLayout.getChildCount() == imagesPerRow) {
            currentLinearLayout = null;
        }

        lastExerciseTimestamp = currentTimestamp;
        // Check if it's been more than 24 hours since the last exercise TODO 86400000


        if (currentTimestamp - lastExerciseTimestamp >= 86400000)
        {
            streak = 0; // Reset streak to zero
        }

        streak++;


        MainSharedPref.saveStreak(streak);
        updateStreakTextView();
    }

    private void updateStreakTextView() {
        TextView streakTextView = findViewById(R.id.streakTextView);
        streakTextView.setText("Your Current Streak Count: " + streak);
    }

//    private void saveStreak() {
//        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
//        editor.putInt(STREAK_KEY, streak);
//        editor.apply();
//    }
//
//    private void loadStreak() {
//        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
//        streak = prefs.getInt(STREAK_KEY, 0);
//    }

    private void displayCrosses()
    {
        gridCrosses.removeAllViews();
        currentRow = 0;
        currentLinearLayout = null;

        int numCrosses = streak;
        while (numCrosses > 0) {
            if (currentLinearLayout == null || currentLinearLayout.getChildCount() >= imagesPerRow) {
                currentLinearLayout = new LinearLayout(this);
                currentLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
                gridCrosses.addView(currentLinearLayout);
                currentRow++;
            }

            ImageView crossImageView = new ImageView(this);
            crossImageView.setImageResource(R.drawable.ic_cross_background);
            crossImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(imageWidth, imageHeight);
            layoutParams.setMargins(5, 5, 5, 5);
            crossImageView.setLayoutParams(layoutParams);

            currentLinearLayout.addView(crossImageView);

            numCrosses--;
        }
    }

    public void reset(View view)
    {
        streak = 0;
        MainSharedPref.saveStreak(streak);
        gridCrosses.removeAllViews();

        updateStreakTextView();
        displayCrosses();
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