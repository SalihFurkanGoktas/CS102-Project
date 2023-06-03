package com.example.cs_102_project.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface WTable_6_Dao {

    @Insert
    void addWork(WorkoutTable_6 workoutRow);

    @Update
    void updWork(WorkoutTable_6 workoutRow);

    @Delete
    void delWork(WorkoutTable_6 workoutRow);

    @Query("SELECT * FROM workoutTable_6")
    List<WorkoutTable_6> getEverything();
}
