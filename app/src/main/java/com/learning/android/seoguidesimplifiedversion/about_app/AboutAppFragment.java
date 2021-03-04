package com.learning.android.seoguidesimplifiedversion.about_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.android.play.core.tasks.OnCompleteListener;
import com.google.android.play.core.tasks.Task;
import com.learning.android.seoguidesimplifiedversion.R;

public class AboutAppFragment extends Fragment {
    // private Button bt_rate_us;
    private Button bt_feedback;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about_app,container,false);

        bt_feedback = view.findViewById(R.id.button_leave_feedback_id);

        bt_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto: "));
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "hello@sharpcircles.com.au" });
                startActivity(intent);
            }
        });

        /**
        bt_rate_us = view.findViewById(R.id.button_rate_us_id);

        bt_rate_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                popUpDialog();

            }
        });
         */

        return view;
    }


    // in-app review pop-up dialog
    private void popUpDialog () {
        ReviewManager manager = ReviewManagerFactory.create(getContext()); // getActivity
        Task<ReviewInfo> request = manager.requestReviewFlow();
        request.addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                // We can get the ReviewInfo object
                ReviewInfo reviewInfo = task.getResult();
                Task<Void> flow = manager.launchReviewFlow(getActivity(), reviewInfo);
                flow.addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // The flow has finished. The API does not indicate whether the user
                        // reviewed or not, or even whether the review dialog was shown. Thus, no
                        // matter the result, we continue our app flow.
                    }
                });
            } else {
                // There was some problem, continue regardless of the result.
            }
        });
    }
}
