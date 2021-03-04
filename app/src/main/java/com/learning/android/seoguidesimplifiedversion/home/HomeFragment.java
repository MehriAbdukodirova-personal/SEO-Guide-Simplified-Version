package com.learning.android.seoguidesimplifiedversion.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.learning.android.seoguidesimplifiedversion.BuildConfig;
import com.learning.android.seoguidesimplifiedversion.R;
import com.learning.android.seoguidesimplifiedversion.about_app.AboutAppFragment;
import com.learning.android.seoguidesimplifiedversion.about_company.AboutCompanyFragment;
import com.learning.android.seoguidesimplifiedversion.step.StepListFragment;


public class HomeFragment extends Fragment {

    private CardView bt_steps;
    private CardView bt_about_sharp_circle;
    private CardView bt_about_app;
    private CardView bt_share;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_home, container,false);

        // bind buttons in UI
        bt_steps = view.findViewById(R.id.button_website_seo_steps_id);
        bt_steps.setUseCompatPadding(false);
        bt_about_app = view.findViewById(R.id.button_about_app_id);
        bt_about_app.setUseCompatPadding(false);
        bt_about_sharp_circle = view.findViewById(R.id.button_about_sharp_circles_id);
        bt_about_sharp_circle.setUseCompatPadding(false);

        bt_share = view.findViewById(R.id.button_share_id);
        bt_share.setUseCompatPadding(false);
//        bt_feedback = view.findViewById(R.id.button_leave_feedback_id);
//        bt_tip = view.findViewById(R.id.button_seo_tips_id);

        // set listener to buttons
        bt_steps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new StepListFragment()).addToBackStack(null).commit();
            }
        });

        bt_about_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AboutAppFragment()).addToBackStack(null).commit();
            }
        });

        bt_about_sharp_circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AboutCompanyFragment()).addToBackStack(null).commit();
            }
        });

        bt_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Intent shareIntent = new Intent();
                    shareIntent.setAction(Intent.ACTION_SEND);  //can change ACTION_SEND TO other available options later
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "SEO Guide App to Optimise Your Website");
                    shareIntent.putExtra(Intent.EXTRA_TEXT,
                            "Hey, check out this SEO Guide App to achieve high rankings and visibility for your website, in Google's organic search results at: https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n");
//                    String shareMessage = "https://play.google.com/store/apps/details?=" + BuildConfig.APPLICATION_ID + "\n\n";
//                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(shareIntent.createChooser(shareIntent, "Share by "));

                }catch (Exception e){
                    Toast.makeText(HomeFragment.this.getContext(), "Error occurred", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return view;
    }
}
