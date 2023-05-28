package com.example.cs_102_project;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;


public class MainSharedPref {

    //private int streak;

    private static SharedPreferences instanceSharedPref;
    private static final String STREAK_KEY = "streak";

    private MainSharedPref() {}

    public static void init(Context context)
    {
        if(instanceSharedPref == null)
            instanceSharedPref = context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE);
    }

    public static void saveStreak(int streak) {
        SharedPreferences.Editor editor = instanceSharedPref.edit();
        editor.putInt(STREAK_KEY, streak);
        editor.apply();
    }

    public static int loadStreak() {
        return instanceSharedPref.getInt(STREAK_KEY, 0);
    }


}
