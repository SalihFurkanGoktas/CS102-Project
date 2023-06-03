package com.example.cs_102_project.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "workoutTable_6")
public class WorkoutTable_6 {
    @PrimaryKey(autoGenerate = true)
    private int specialID;
    private int moveNo;

    private String moveName;
    private int weight;
    private int rep;

    public WorkoutTable_6(int specialID, String moveName, int moveNo, int weight, int rep) {

        this.specialID = specialID;

        this.moveName = moveName;

        this.moveNo = moveNo;

        this.weight = weight;

        this.rep = rep;

    }

    public int getSpecialID() { return specialID; }

    public String getMoveName() { return moveName; }
    public int getMoveNo() { return moveNo; }
    public int getWeight() { return weight; }
    public int getRep() { return rep; }


    public void setSpecialID(int specialID) { this.specialID = specialID; }

    public void setMoveName(String moveName) { this.moveName = moveName; }
    public void setMoveNo(int moveNo) { this.moveNo = moveNo; }
    public void setWeight(int weight) { this.weight = weight; }
    public void setRep(int rep) { this.rep = rep; }
}
