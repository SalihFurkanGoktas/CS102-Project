package com.example.cs_102_project.data;

import android.content.Context;

import androidx.room.Room;

public class Database {

    private static final String DB_NAME = "workoutDB";
    private static volatile WorkoutDatabase workout_db;

    public static synchronized WorkoutDatabase getInstance(Context context) {
        if (workout_db == null)
            workout_db = Room.databaseBuilder(context.getApplicationContext(), WorkoutDatabase.class, DB_NAME).build();

        return workout_db;
    }
}
