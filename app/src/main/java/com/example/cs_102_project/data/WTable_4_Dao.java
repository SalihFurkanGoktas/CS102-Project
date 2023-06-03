package com.example.cs_102_project.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface WTable_4_Dao {

    @Insert
    void addWork(WorkoutTable_4 workoutRow);

    @Update
    void updWork(WorkoutTable_4 workoutRow);

    @Delete
    void delWork(WorkoutTable_4 workoutRow);

    @Query("SELECT * FROM workoutTable_4")
    List<WorkoutTable_4> getEverything();
}
