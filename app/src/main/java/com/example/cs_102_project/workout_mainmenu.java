package com.example.cs_102_project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link workout_mainmenu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class workout_mainmenu extends Fragment implements View.OnClickListener {

    private Button button1, button2, button3, button4, button5, button6;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public workout_mainmenu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment workout_mainmenu.
     */
    // TODO: Rename and change types and number of parameters
    public static workout_mainmenu newInstance(String param1, String param2) {
        workout_mainmenu fragment = new workout_mainmenu();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_workout_mainmenu, container, false);

        button1 = view.findViewById(R.id.buttonW1);
        button2 = view.findViewById(R.id.buttonW2);
        button3 = view.findViewById(R.id.buttonW3);
        button4 = view.findViewById(R.id.buttonW4);
        button5 = view.findViewById(R.id.buttonW5);
        button6 = view.findViewById(R.id.buttonW6);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        NavController navController = Navigation.findNavController(view);

        if (view.getId() == R.id.buttonW1) navController.navigate(R.id.action_workout_mainmenu2_to_workout_1);
        else if (view.getId() == R.id.buttonW2) navController.navigate(R.id.action_workout_mainmenu2_to_workout_2);
        else if (view.getId() == R.id.buttonW3) navController.navigate(R.id.action_workout_mainmenu2_to_workout_3);
        else if (view.getId() == R.id.buttonW4) navController.navigate(R.id.action_workout_mainmenu2_to_workout_4);
        else if (view.getId() == R.id.buttonW5) navController.navigate(R.id.action_workout_mainmenu2_to_workout_5);
        else if (view.getId() == R.id.buttonW6) navController.navigate(R.id.action_workout_mainmenu2_to_workout_6);

    }
}