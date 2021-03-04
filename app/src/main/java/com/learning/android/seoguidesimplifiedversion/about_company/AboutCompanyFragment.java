package com.learning.android.seoguidesimplifiedversion.about_company;

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

import com.learning.android.seoguidesimplifiedversion.R;


public class AboutCompanyFragment extends Fragment {
    private Button bt_contact;
    private Button bt_free_seo_audit;
    private Button bt_affordable_seo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about_sharp_circles,container,false);

        bt_contact = view.findViewById(R.id.button_contact_us);
        bt_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.sharpcircles.com.au/seo-company-australia/"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        bt_free_seo_audit = view.findViewById(R.id.button_free_seo_audit);
        bt_free_seo_audit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.sharpcircles.com.au/website-analysis-seo-audit/"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });

        bt_affordable_seo = view.findViewById(R.id.button_seo_package);
        bt_affordable_seo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.sharpcircles.com.au/affordable-seo-packages-australia/"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        return view;
    }
}
