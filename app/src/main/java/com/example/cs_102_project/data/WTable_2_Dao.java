package com.example.cs_102_project.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface WTable_2_Dao {

    @Insert
    void addWork(WorkoutTable_2 workoutRow);

    @Update
    void updWork(WorkoutTable_2 workoutRow);

    @Delete
    void delWork(WorkoutTable_2 workoutRow);

    @Query("SELECT * FROM workoutTable_2")
    List<WorkoutTable_2> getEverything();
}
