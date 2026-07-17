package com.jaloldo.emulister;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class FavoritesFragment extends Fragment {
    private RecyclerView favoritesRecyclerView;
    private EmulatorsAdapter favoritesAdapter;
    private List<EmulatorItem> favoritesList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);

        favoritesRecyclerView = view.findViewById(R.id.favorites_recycler_view);
        favoritesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        
        favoritesList = new ArrayList<>();
        favoritesAdapter = new EmulatorsAdapter(favoritesList, getContext());
        favoritesRecyclerView.setAdapter(favoritesAdapter);

        loadFavorites();

        return view;
    }

    private void loadFavorites() {
        // Load from SharedPreferences in production
        favoritesList.add(new EmulatorItem("Yuzu", "Nintendo Switch", "4.8", "https://via.placeholder.com/150"));
        favoritesList.add(new EmulatorItem("Dolphin", "GameCube/Wii", "4.9", "https://via.placeholder.com/150"));
        
        favoritesAdapter.notifyDataSetChanged();
    }
}