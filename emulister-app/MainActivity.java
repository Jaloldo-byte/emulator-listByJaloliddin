package com.jaloldo.emulister;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNav;
    private SearchView searchView;
    private FrameLayout fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.bottom_navigation);
        searchView = findViewById(R.id.search_view);
        fragmentContainer = findViewById(R.id.fragment_container);

        // Load Home Fragment by default
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new HomeFragment())
                    .commit();
        }

        // Bottom Navigation Listener
        bottomNav.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_home:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new HomeFragment())
                            .commit();
                    return true;
                case R.id.nav_emulators:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new EmulatorsFragment())
                            .commit();
                    return true;
                case R.id.nav_news:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new NewsFragment())
                            .commit();
                    return true;
                case R.id.nav_favorites:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new FavoritesFragment())
                            .commit();
                    return true;
            }
            return false;
        });
    }
}