package com.example.FinanceMobileApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      bottomNav=findViewById(R.id.bottomNav);


        NavHostFragment navHostFragment=(NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);

        NavigationUI.setupWithNavController(bottomNav, navHostFragment.getNavController());


    }
}