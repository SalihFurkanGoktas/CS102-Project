package com.example.cs_102_project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import org.jetbrains.annotations.Nullable;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link workout_1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class workout_1 extends Fragment implements View.OnClickListener {

    private TextView inMove1, inMove2, inMove3, inMove4, inMove5, inMove6, inMove7, inMove8, inMove9, inMove10;
    private EditText inWeight1, inWeight2, inWeight3, inWeight4, inWeight5, inWeight6, inWeight7, inWeight8, inWeight9, inWeight10;
    private EditText inReps1, inReps2, inReps3, inReps4, inReps5, inReps6, inReps7, inReps8, inReps9, inReps10;

    private Button submitBtn;

    private Button finishBtn;
    private Button backBtn;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public workout_1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment workout_1.
     */
    // TODO: Rename and change types and number of parameters
    public static workout_1 newInstance(String param1, String param2) {
        workout_1 fragment = new workout_1();
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
        View view = inflater.inflate(R.layout.fragment_workout_1, container, false);

        backBtn = view.findViewById(R.id.backBtn);

        backBtn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        NavController navCtrl = Navigation.findNavController(view);

        if (view.getId() == backBtn.getId())
            navCtrl.popBackStack();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        initMoveWeightRep(view);

        submitBtn = view.findViewById(R.id.submitBtn1);

        finishBtn = view.findViewById(R.id.finishBtn1);


    }

    public void initMoveWeightRep(View view) {

        inMove1 = view.findViewById(R.id.inMove1_1);
        inMove2 = view.findViewById(R.id.inMove1_2);
        inMove3 = view.findViewById(R.id.inMove1_3);
        inMove4 = view.findViewById(R.id.inMove1_4);
        inMove5 = view.findViewById(R.id.inMove1_5);
        inMove6 = view.findViewById(R.id.inMove1_6);
        inMove7 = view.findViewById(R.id.inMove1_7);
        inMove8 = view.findViewById(R.id.inMove1_8);
        inMove9 = view.findViewById(R.id.inMove1_9);
        inMove10 = view.findViewById(R.id.inMove1_10);

        inWeight1 = view.findViewById(R.id.inWeight1_1);
        inWeight2 = view.findViewById(R.id.inWeight1_2);
        inWeight3 = view.findViewById(R.id.inWeight1_3);
        inWeight4 = view.findViewById(R.id.inWeight1_4);
        inWeight5 = view.findViewById(R.id.inWeight1_5);
        inWeight6 = view.findViewById(R.id.inWeight1_6);
        inWeight7 = view.findViewById(R.id.inWeight1_7);
        inWeight8 = view.findViewById(R.id.inWeight1_8);
        inWeight9 = view.findViewById(R.id.inWeight1_9);
        inWeight10 = view.findViewById(R.id.inWeight1_10);

        inReps1 = view.findViewById(R.id.inReps1_1);
        inReps2 = view.findViewById(R.id.inReps1_2);
        inReps3 = view.findViewById(R.id.inReps1_3);
        inReps4 = view.findViewById(R.id.inReps1_4);
        inReps5 = view.findViewById(R.id.inReps1_5);
        inReps6 = view.findViewById(R.id.inReps1_6);
        inReps7 = view.findViewById(R.id.inReps1_7);
        inReps8 = view.findViewById(R.id.inReps1_8);
        inReps9 = view.findViewById(R.id.inReps1_9);
        inReps10 = view.findViewById(R.id.inReps1_10);


    }
}