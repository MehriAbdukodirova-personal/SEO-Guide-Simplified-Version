package com.learning.android.seoguidesimplifiedversion.step;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;


import com.learning.android.seoguidesimplifiedversion.R;
import com.learning.android.seoguidesimplifiedversion.entity.Step;
import com.learning.android.seoguidesimplifiedversion.entity.Steps;

import java.util.ArrayList;

public class StepListFragment extends Fragment {

    private LinearLayout linearLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_steps_list, container,false);

        linearLayout = view.findViewById(R.id.linear_steps);

        ArrayList<Step> steps = Steps.getSteps();

        for (Step step : steps){
            addStepCard(step.getId(), step.getTip());
        }

        return view;
    }

    public void addStepCard(int id, String tip){

        // design card
        CardView card = new CardView(getContext());
        //card.setCardBackgroundColor(Color.parseColor("#FFC6D6C3"));
        card.setRadius(10);
        card.setPadding(30,1,1,5);
        card.setCardElevation(9);

        // make card items horizontally
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,200);
        params.setMargins(50,20,50,10);
        LinearLayout innerLinear = new LinearLayout(getContext());
        innerLinear.setOrientation(LinearLayout.HORIZONTAL);
       // ConstraintLayout innerLinear = new ConstraintLayout(getContext());
        card.addView(innerLinear);
        card.setLayoutParams(params);


        View element = getLayoutInflater().inflate(R.layout.card,null,false);
        TextView tv_id = element.findViewById(R.id.step_id);
        TextView tv_tip = element.findViewById(R.id.step_tip);
        tv_id.setText(id+"");
        tv_tip.setText(tip);
        card.addView(element);


        // make card clickable
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new StepDetailFragment(id - 1)).addToBackStack(null).commit();
            }
        });

        // add card into linearlayout
        linearLayout.addView(card);
    }
}
