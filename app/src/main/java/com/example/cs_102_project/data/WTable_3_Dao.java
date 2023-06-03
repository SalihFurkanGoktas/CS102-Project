package com.example.cs_102_project.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface WTable_3_Dao {

    @Insert
    void addWork(WorkoutTable_3 workoutRow);

    @Update
    void updWork(WorkoutTable_3 workoutRow);

    @Delete
    void delWork(WorkoutTable_3 workoutRow);

    @Query("SELECT * FROM workoutTable_3")
    List<WorkoutTable_3> getEverything();
}
