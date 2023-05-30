package com.example.cs_102_project.data;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {WorkoutTable_1.class, WorkoutTable_2.class, WorkoutTable_3.class, WorkoutTable_4.class, WorkoutTable_5.class, WorkoutTable_6.class}, version = 1)
public abstract class WorkoutDatabase extends RoomDatabase {

    public abstract WTable_1_Dao W1Dao();
    public abstract WTable_2_Dao W2Dao();
    public abstract WTable_3_Dao W3Dao();
    public abstract WTable_4_Dao W4Dao();
    public abstract WTable_5_Dao W5Dao();
    public abstract WTable_6_Dao W6Dao();
    private static final String DB_NAME = "workoutDB";
    private static WorkoutDatabase workout_db;

    public static synchronized WorkoutDatabase getInstance(Context context) {
        if (workout_db == null)
        {
            workout_db = Room.databaseBuilder(context.getApplicationContext(), WorkoutDatabase.class, DB_NAME).fallbackToDestructiveMigration().allowMainThreadQueries().build();
            Log.d("INIT_DATABASE", "Database has been init");
        }
        else Log.d("INIT_DATABASE", "Instance of DB already exists.");

        workout_db.getOpenHelper().getWritableDatabase();

        return workout_db;
    }
}


