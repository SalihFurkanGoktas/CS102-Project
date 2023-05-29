package com.example.cs_102_project.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "workoutTable_1")
public class WorkoutTable_1 {

    @PrimaryKey
    private int moveID;

    private int weight1_1, weight1_2, weight1_3, weight1_4, weight1_5;
    private int rep1_1, rep1_2, rep1_3, rep1_4, rep1_5;

    public WorkoutTable_1(int moveNo, int weight1, int weight2, int weight3, int weight4, int weight5, int rep1, int rep2, int rep3, int rep4, int rep5) {

        this.moveID = moveNo;

        this.weight1_1 = weight1;
        this.weight1_2 = weight1;
        this.weight1_3 = weight1;
        this.weight1_4 = weight1;
        this.weight1_5 = weight1;

        this.rep1_1 = rep1;
        this.rep1_2 = rep2;
        this.rep1_3 = rep3;
        this.rep1_4 = rep4;
        this.rep1_5 = rep5;
    }

    public int getMoveNo() { return moveID; }

    public int getWeightNo1() { return weight1_1; }
    public int getWeightNo2() { return weight1_2; }
    public int getWeightNo3() { return weight1_3; }
    public int getWeightNo4() { return weight1_4; }
    public int getWeightNo5() { return weight1_5; }

    public int getRep1() { return rep1_1; }
    public int getRep2() { return rep1_2; }
    public int getRep3() { return rep1_3; }
    public int getRep4() { return rep1_4; }
    public int getRep5() { return rep1_5; }

    public void setMoveID(int moveNo) { this.moveID = moveNo; }

    public void setWeight1(int weight1) { this.weight1_1 = weight1; }
    public void setWeight2(int weight2) { this.weight1_2 = weight2; }
    public void setWeight3(int weight3) { this.weight1_3 = weight3; }
    public void setWeight4(int weight4) { this.weight1_4 = weight4; }
    public void setWeight5(int weight5) { this.weight1_5 = weight5; }

    public void setRep1(int rep1) { this.rep1_1 = rep1; }
    public void setRep2(int rep2) { this.rep1_2 = rep2; }
    public void setRep3(int rep3) { this.rep1_3 = rep3; }
    public void setRep4(int rep4) { this.rep1_4 = rep4; }
    public void setRep5(int rep5) { this.rep1_5 = rep5; }
}
