package com.example.michael.simplemoviecatalogue;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.michael.simplemoviecatalogue.helper.BottomNavigationBehavior;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {

    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = getSupportActionBar();

        BottomNavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        // attaching bottom sheet behaviour - hide / show on scroll
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigationView.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());

        toolbar.setTitle(getString(R.string.movies));
    }

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment fragment;
                    switch (menuItem.getItemId()) {
                        case R.id.nav_movie:
                            toolbar.setTitle(getString(R.string.movies));
                            return true;
                        case R.id.nav_tv:
                            toolbar.setTitle(getString(R.string.tv_shows));
                            return true;
//                        case R.id.nav_favorite:
//                            toolbar.setTitle(getString(R.string.favorite));
//                            return true;
                        case R.id.nav_settings:
                            toolbar.setTitle(getString(R.string.settings));
                            return true;
                    }

                    return false;
                }
            };
}
