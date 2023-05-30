package com.example.cs_102_project.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "workoutTable_5")
public class WorkoutTable_5 {
    @PrimaryKey(autoGenerate = true)
    private int specialID;
    private int moveNo;

    private int weight;
    private int rep;

    public WorkoutTable_5(int moveNo, int weight, int rep) {

        this.moveNo = moveNo;

        this.weight = weight;

        this.rep = rep;

    }

    public int getSpecialID() { return specialID; }
    public int getMoveNo() { return moveNo; }
    public int getWeight() { return weight; }
    public int getRep() { return rep; }


    public void setSpecialID(int specialID) { this.specialID = specialID; }
    public void setMoveNo(int moveNo) { this.moveNo = moveNo; }
    public void setWeight(int weight) { this.weight = weight; }
    public void setRep(int rep) { this.rep = rep; }
}
