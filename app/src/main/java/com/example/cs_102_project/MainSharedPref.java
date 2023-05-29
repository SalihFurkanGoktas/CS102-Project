package com.example.cs_102_project;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainSharedPref {



    private static DatabaseReference gymDormRef;
    private static DatabaseReference gymMainRef;
    private static DatabaseReference gymEastRef;

    private static int gymDormNum;
    private static int gymMainNum;
    private static int gymEastNum;

    private static int gymSelection = 0;





    private static SharedPreferences instanceSharedPref;
    private static final String STREAK_KEY = "streak";

    private static final String GYM_SELECT_KEY = "gymSelect";

    private MainSharedPref() {}

    public static void init(Context context)
    {
        if(instanceSharedPref == null)
            instanceSharedPref = context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE);
        gymDormRef = FirebaseDatabase.getInstance("https://cs102-73984-default-rtdb.europe-west1.firebasedatabase.app/").getReference("GymDorm");
        gymMainRef = FirebaseDatabase.getInstance("https://cs102-73984-default-rtdb.europe-west1.firebasedatabase.app/").getReference("GymMain");
        gymEastRef = FirebaseDatabase.getInstance("https://cs102-73984-default-rtdb.europe-west1.firebasedatabase.app/").getReference("GymEast");
        updateGyms();
    }

    public static void saveStreak(int streak) {
        SharedPreferences.Editor editor = instanceSharedPref.edit();
        editor.putInt(STREAK_KEY, streak);
        editor.apply();
    }

    public static void saveGymSelection(int aGymSelection) {
        SharedPreferences.Editor editor = instanceSharedPref.edit();
        editor.putInt(GYM_SELECT_KEY, aGymSelection);
        editor.apply();

    }


    public static int loadStreak() {
        return instanceSharedPref.getInt(STREAK_KEY, 0);
    }

    public static int loadGymSelection() {
        return instanceSharedPref.getInt(GYM_SELECT_KEY, 0);
    }

    private static void updateGyms() {
        gymDormRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot snapshot) {
                gymDormNum = (snapshot.getValue(Integer.class));
            }
            @Override
            public void onCancelled( DatabaseError error) {}
        });
        gymMainRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot snapshot) {
                gymMainNum = (snapshot.getValue(Integer.class));
            }
            @Override
            public void onCancelled( DatabaseError error) {}
        });
        gymEastRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot snapshot) {
                gymEastNum = (snapshot.getValue(Integer.class));
            }
            @Override
            public void onCancelled( DatabaseError error) {}
        });

    }

    public static int loadGymDorm()
    {
        return gymDormNum;
    }
    public static int loadGymMain()
    {
        return gymMainNum;
    }
    public static int loadGymEast()
    {
        return gymEastNum;
    }







}
