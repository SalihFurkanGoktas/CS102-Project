package com.example.cs_102_project.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "workoutTable_2")
public class WorkoutTable_2 {


    @PrimaryKey
    private int moveID;

    private int weight2_1, weight2_2, weight2_3, weight2_4, weight2_5;
    private int rep2_1, rep2_2, rep2_3, rep2_4, rep2_5;

    public WorkoutTable_2(int moveNo, int weight1, int weight2, int weight3, int weight4, int weight5, int rep1, int rep2, int rep3, int rep4, int rep5) {

        this.moveID = moveNo;

        this.weight2_1 = weight1;
        this.weight2_2 = weight2;
        this.weight2_3 = weight3;
        this.weight2_4 = weight4;
        this.weight2_5 = weight5;

        this.rep2_1 = rep1;
        this.rep2_2 = rep2;
        this.rep2_3 = rep3;
        this.rep2_4 = rep4;
        this.rep2_5 = rep5;
    }

    public int getMoveNo() { return moveID; }

    public int getWeightNo1() { return weight2_1; }
    public int getWeightNo2() { return weight2_2; }
    public int getWeightNo3() { return weight2_3; }
    public int getWeightNo4() { return weight2_4; }
    public int getWeightNo5() { return weight2_5; }

    public int getRep1() { return rep2_1; }
    public int getRep2() { return rep2_2; }
    public int getRep3() { return rep2_3; }
    public int getRep4() { return rep2_4; }
    public int getRep5() { return rep2_5; }

    public void setMoveID(int moveNo) { this.moveID = moveNo; }

    public void setWeight1(int weight1) { this.weight2_1 = weight1; }
    public void setWeight2(int weight2) { this.weight2_2 = weight2; }
    public void setWeight3(int weight3) { this.weight2_3 = weight3; }
    public void setWeight4(int weight4) { this.weight2_4 = weight4; }
    public void setWeight5(int weight5) { this.weight2_5 = weight5; }

    public void setRep1(int rep1) { this.rep2_1 = rep1; }
    public void setRep2(int rep2) { this.rep2_2 = rep2; }
    public void setRep3(int rep3) { this.rep2_3 = rep3; }
    public void setRep4(int rep4) { this.rep2_4 = rep4; }
    public void setRep5(int rep5) { this.rep2_5 = rep5; }
}
