package com.example.cs_102_project.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "workoutTable_3")
public class WorkoutTable_3 {
    @PrimaryKey
    private int moveID;

    private int weight3_1, weight3_2, weight3_3, weight3_4, weight3_5;
    private int rep3_1, rep3_2, rep3_3, rep3_4, rep3_5;

    public WorkoutTable_3(int moveNo, int weight1, int weight2, int weight3, int weight4, int weight5, int rep1, int rep2, int rep3, int rep4, int rep5) {

        this.moveID = moveNo;

        this.weight3_1 = weight1;
        this.weight3_2 = weight2;
        this.weight3_3 = weight3;
        this.weight3_4 = weight4;
        this.weight3_5 = weight5;

        this.rep3_1 = rep1;
        this.rep3_2 = rep2;
        this.rep3_3 = rep3;
        this.rep3_4 = rep4;
        this.rep3_5 = rep5;
    }

    public int getMoveNo() { return moveID; }

    public int getWeightNo1() { return weight3_1; }
    public int getWeightNo2() { return weight3_2; }
    public int getWeightNo3() { return weight3_3; }
    public int getWeightNo4() { return weight3_4; }
    public int getWeightNo5() { return weight3_5; }

    public int getRep1() { return rep3_1; }
    public int getRep2() { return rep3_2; }
    public int getRep3() { return rep3_3; }
    public int getRep4() { return rep3_4; }
    public int getRep5() { return rep3_5; }

    public void setMoveID(int moveNo) { this.moveID = moveNo; }

    public void setWeight1(int weight1) { this.weight3_1 = weight1; }
    public void setWeight2(int weight2) { this.weight3_2 = weight2; }
    public void setWeight3(int weight3) { this.weight3_3 = weight3; }
    public void setWeight4(int weight4) { this.weight3_4 = weight4; }
    public void setWeight5(int weight5) { this.weight3_5 = weight5; }

    public void setRep1(int rep1) { this.rep3_1 = rep1; }
    public void setRep2(int rep2) { this.rep3_2 = rep2; }
    public void setRep3(int rep3) { this.rep3_3 = rep3; }
    public void setRep4(int rep4) { this.rep3_4 = rep4; }
    public void setRep5(int rep5) { this.rep3_5 = rep5; }
}
