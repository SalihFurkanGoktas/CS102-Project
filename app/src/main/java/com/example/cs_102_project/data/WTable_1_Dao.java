package com.example.cs_102_project.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface WTable_1_Dao {

    @Insert
    void addWork1(WorkoutTable_1 workoutRow);

    @Update
    void updWork1(WorkoutTable_1 workoutRow);

    @Delete
    void delWork1(WorkoutTable_1 workoutRow);

    @Query("SELECT * FROM workoutTable_1")
    List<WorkoutTable_1> getEverything();

}
