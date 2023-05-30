package com.example.cs_102_project;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class MainSharedPref {

    private static Calendar cal;

    private static DatabaseReference gymDormRef;
    private static DatabaseReference gymMainRef;
    private static DatabaseReference gymEastRef;

    private static int gymDormNum;
    private static int gymMainNum;
    private static int gymEastNum;

    private static final int streakDayMilliRef = 86400000;






    private static SharedPreferences instanceSharedPref;
    private static final String STREAK_KEY = "streak";
    private static final String IS_EXERCISING_KEY = "isExercising";

    private static final String IS_STREAK_AVAILABLE_KEY = "isStreakAvailable";

    private static final String STREAK_INITIAL_TIME_KEY = "streakAvailableTime";
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
        streakManagement();
    }

    public static void saveStreak(int streak) {
        SharedPreferences.Editor editor = instanceSharedPref.edit();
        editor.putInt(STREAK_KEY, streak);
        editor.apply();
    }

    public static void saveStreakInitialTime() {
        SharedPreferences.Editor editor = instanceSharedPref.edit();
        cal = new GregorianCalendar();
        editor.putLong(STREAK_INITIAL_TIME_KEY, cal.getTimeInMillis());
        editor.apply();
    }

    public static void saveGymSelection(int aGymSelection) {
        if (loadIsExercising() == true)
        {
            MainSharedPref.decrementGymCount();
            MainSharedPref.saveIsExercising(false);
        }


        SharedPreferences.Editor editor = instanceSharedPref.edit();
        editor.putInt(GYM_SELECT_KEY, aGymSelection);
        editor.apply();

    }

    public static void saveIsExercising(boolean exerciseStatus) {
        SharedPreferences.Editor editor = instanceSharedPref.edit();
        editor.putBoolean(IS_EXERCISING_KEY, exerciseStatus);
        editor.apply();

    }

    public static void saveIsStreakAvailable(boolean streakStatus) {
        SharedPreferences.Editor editor = instanceSharedPref.edit();
        editor.putBoolean(IS_STREAK_AVAILABLE_KEY, streakStatus);
        editor.apply();

    }




    public static int loadStreak() {
        return instanceSharedPref.getInt(STREAK_KEY, 0);
    }

    public static int loadGymSelection() {
        return instanceSharedPref.getInt(GYM_SELECT_KEY, 0);
    }

    public static boolean loadIsExercising() {
        return instanceSharedPref.getBoolean(IS_EXERCISING_KEY, false);
    }

    public static boolean loadIsStreakAvailable() {
        return instanceSharedPref.getBoolean(IS_STREAK_AVAILABLE_KEY, true);
    }

    public static long loadStreakInitialTime() {
        return instanceSharedPref.getLong(STREAK_INITIAL_TIME_KEY, cal.getTimeInMillis());
    }

    public static void streakManagement()
    {
        cal = new GregorianCalendar();
        long timePassed = cal.getTimeInMillis() - loadStreakInitialTime();
        if (timePassed < streakDayMilliRef)
        {
            //do nothing
        }
        else if (timePassed >= streakDayMilliRef && timePassed < (streakDayMilliRef * 2))
        {
            saveIsStreakAvailable(true);
        }
        else // more time has passed
        {
            saveStreak(0); //resets the streak
            saveIsStreakAvailable(true);
        }

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

    public static void incrementGymCount()
    {
        int gymSelect = loadGymSelection();
        if (gymSelect == 0)
        {
            gymMainRef.setValue(ServerValue.increment(1));
        }
        else if (gymSelect == 1)
        {
            gymDormRef.setValue(ServerValue.increment(1));
        }
        else if (gymSelect == 2)
        {
            gymEastRef.setValue(ServerValue.increment(1));
        }
    }

    public static void decrementGymCount()
    {
        int gymSelect = loadGymSelection();
        if (gymSelect == 0)
        {
            gymMainRef.setValue(ServerValue.increment(-1));
        }
        else if (gymSelect == 1)
        {
            gymDormRef.setValue(ServerValue.increment(-1));
        }
        else if (gymSelect == 2)
        {
            gymEastRef.setValue(ServerValue.increment(-1));
        }
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
