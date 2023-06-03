package com.example.cs_102_project.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface WTable_5_Dao {

    @Insert
    void addWork(WorkoutTable_5 workoutRow);

    @Update
    void updWork(WorkoutTable_5 workoutRow);

    @Delete
    void delWork(WorkoutTable_5 workoutRow);

    @Query("SELECT * FROM workoutTable_5")
    List<WorkoutTable_5> getEverything();
}
