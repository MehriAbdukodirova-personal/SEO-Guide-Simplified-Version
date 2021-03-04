package com.learning.android.seoguidesimplifiedversion.step;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.learning.android.seoguidesimplifiedversion.R;
import com.learning.android.seoguidesimplifiedversion.entity.Step;
import com.learning.android.seoguidesimplifiedversion.entity.Steps;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerUtils;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;

public class StepDetailFragment extends Fragment {

    private int stepId;

    private TextView step_id;
    private TextView step_tip;
    private TextView step_description;
    private TextView step_why;
    private TextView step_how;
    private ImageView step_image;
    // private Videoview
    private YouTubePlayerView step_video;
    private Button bt_previous;
    private Button bt_next;
    private ImageView img_previous;
    private ImageView img_next;

    private ArrayList<Step> steps;

    public StepDetailFragment(int stepId){
        this.stepId = stepId;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_step, container, false);

        steps = Steps.getSteps();

        Step step = steps.get(stepId);

        step_id = view.findViewById(R.id.step_id);
        step_tip = view.findViewById(R.id.step_tip);
        step_description = view.findViewById(R.id.step_description);
        step_why = view.findViewById(R.id.step_why);
        step_how = view.findViewById(R.id.step_how);
        step_image = view.findViewById(R.id.step_image);
        step_video = view.findViewById(R.id.step_video);
        bt_next = view.findViewById(R.id.bt_next);
        bt_previous = view.findViewById(R.id.bt_previous);
        img_next = view.findViewById(R.id.img_next);
        img_previous = view.findViewById(R.id.img_previous);

        step_id.setText("Step " + step.getId());
        step_tip.setText(step.getTip());
        step_description.setText(step.getDescription());
        step_why.setText(step.getWhy());
        step_how.setText(step.getHow());

        // set immage
        Context context = step_image.getContext();
        int imageId = context.getResources().getIdentifier("step"+step.getId()+"_image", "drawable", context.getPackageName());
        step_image.setImageResource(imageId);

        // set vide/**
        /**
        String videoPath = "android.resource://" + getContext().getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(videoPath);
        step_video.setVideoURI(uri);
        MediaController mediaController = new MediaController(getContext());
        step_video.setMediaController(mediaController);
        mediaController.setAnchorView(step_video); **/
        getLifecycle().addObserver(step_video);

        step_video.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                YouTubePlayerUtils.loadOrCueVideo(
                        youTubePlayer,
                        getLifecycle(),
                        step.getVideoId(),
                        0f
                );

            }
        });

        // set Next button and icon
        if (step.getId() == 10){
            bt_next.setText("Finish");
            img_next.setVisibility(view.INVISIBLE);
        }
        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToNext(step);
            }
        });
        img_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToNext(step);
            }
        });


        // set previous button and icon
        if (step.getId() == 1){
            bt_previous.setVisibility(View.INVISIBLE);
            img_previous.setVisibility(View.INVISIBLE);
        }
        bt_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToPrevious(step);
            }
        });
        img_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToPrevious(step);
            }
        });

        return view;
    }

    private void goToNext(Step step){
        if (step.getId() != 10){
            getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new StepDetailFragment(stepId + 1)).addToBackStack(null).commit();
        } else {
//            ((MainActivity)getActivity()).createDialog();
            getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new StepListFragment()).addToBackStack(null).commit();
        }
    }

    private void goToPrevious(Step step){
        if (step.getId() != 1){
            getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new StepDetailFragment(stepId-1)).addToBackStack(null).commit();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
