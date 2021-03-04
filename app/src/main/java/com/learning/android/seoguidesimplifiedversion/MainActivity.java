package com.learning.android.seoguidesimplifiedversion;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.learning.android.seoguidesimplifiedversion.help.RequestHelpFragment;
import com.learning.android.seoguidesimplifiedversion.home.HomeFragment;

import hotchemi.android.rate.AppRate;

public class MainActivity extends AppCompatActivity {

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private Button bt_ok;
    private boolean isHomeFragment = true;
    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        // FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        // Rate us function

        AppRate.with(this)
                .setInstallDays(5) // show after 3 days
                .setLaunchTimes(10) // at least launch 10 times
                .setRemindInterval(7) // how many days have to past if user click remind me later
                .monitor();

        AppRate.showRateDialogIfMeetsConditions(this);

        /*
        Home Fragment automatically displayed when onCreate
        without having to click on it
         */
        bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
        }
    }

    /*
    this lines helps to click the bottom navigation bar and
     responds with displaying the fragments
     */
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    //clears the existing stacked fragments to fix back button bug
                    clearExistingStackedFragments();


                    if (item.getItemId() == R.id.nav_home) {
                        isHomeFragment = true;
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new HomeFragment()).commit();

                    } else if (item.getItemId() == R.id.nav_request_help) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new RequestHelpFragment()).commit();
                    }

                    return true;
                }
            };

    public void createDialog() {
        dialogBuilder = new AlertDialog.Builder(this);
        View popUpView = getLayoutInflater().inflate(R.layout.popup_congratulation, null);
        dialogBuilder.setView(popUpView);
        dialog = dialogBuilder.create();
        dialog.show();

        bt_ok = popUpView.findViewById(R.id.bt_ok);
        bt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }


    @Override
    public void onBackPressed() {
        int fragmentCounts = getSupportFragmentManager().getBackStackEntryCount();
        if (fragmentCounts == 0 && isHomeFragment) {
            bottomNav.setSelectedItemId(R.id.nav_home);
            isHomeFragment = false;


        } else
            super.onBackPressed();
    }

    private void clearExistingStackedFragments() {
    /*
    this method fixes the back button bug on stacked activities of RequestHelpFragment,
    StepDetailFragment, AboutAppFragment and AboutSharpCirclesFragment
     */

        FragmentManager fm = getSupportFragmentManager();
        int count = fm.getBackStackEntryCount();
        for (int i = 0; i < count; ++i) {
            fm.popBackStack();
        }
    }
}