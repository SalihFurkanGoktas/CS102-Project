package com.example.cs_102_project.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "workoutTable_6")
public class WorkoutTable_6 {
    @PrimaryKey
    private int moveID;

    private int weight6_1, weight6_2, weight6_3, weight6_4, weight6_5;
    private int rep6_1, rep6_2, rep6_3, rep6_4, rep6_5;

    public WorkoutTable_6(int moveNo, int weight1, int weight2, int weight3, int weight4, int weight5, int rep1, int rep2, int rep3, int rep4, int rep5) {

        this.moveID = moveNo;

        this.weight6_1 = weight1;
        this.weight6_2 = weight1;
        this.weight6_3 = weight1;
        this.weight6_4 = weight1;
        this.weight6_5 = weight1;

        this.rep6_1 = rep1;
        this.rep6_2 = rep2;
        this.rep6_3 = rep3;
        this.rep6_4 = rep4;
        this.rep6_5 = rep5;
    }

    public int getMoveNo() { return moveID; }

    public int getWeightNo1() { return weight6_1; }
    public int getWeightNo2() { return weight6_2; }
    public int getWeightNo3() { return weight6_3; }
    public int getWeightNo4() { return weight6_4; }
    public int getWeightNo5() { return weight6_5; }

    public int getRep1() { return rep6_1; }
    public int getRep2() { return rep6_2; }
    public int getRep3() { return rep6_3; }
    public int getRep4() { return rep6_4; }
    public int getRep5() { return rep6_5; }

    public void setMoveID(int moveNo) { this.moveID = moveNo; }

    public void setWeight1(int weight1) { this.weight6_1 = weight1; }
    public void setWeight2(int weight2) { this.weight6_2 = weight2; }
    public void setWeight3(int weight3) { this.weight6_3 = weight3; }
    public void setWeight4(int weight4) { this.weight6_4 = weight4; }
    public void setWeight5(int weight5) { this.weight6_5 = weight5; }

    public void setRep1(int rep1) { this.rep6_1 = rep1; }
    public void setRep2(int rep2) { this.rep6_2 = rep2; }
    public void setRep3(int rep3) { this.rep6_3 = rep3; }
    public void setRep4(int rep4) { this.rep6_4 = rep4; }
    public void setRep5(int rep5) { this.rep6_5 = rep5; }
}
