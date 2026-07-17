package com.jaloldo.emulister;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class EmulatorsFragment extends Fragment {
    private RecyclerView emulatorsRecyclerView;
    private SearchView searchView;
    private EmulatorsAdapter emulatorsAdapter;
    private List<EmulatorItem> emulatorsList;
    private List<EmulatorItem> filteredList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_emulators, container, false);

        emulatorsRecyclerView = view.findViewById(R.id.emulators_recycler_view);
        searchView = view.findViewById(R.id.search_emulators);

        emulatorsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        emulatorsList = new ArrayList<>();
        filteredList = new ArrayList<>(emulatorsList);
        emulatorsAdapter = new EmulatorsAdapter(filteredList, getContext());
        emulatorsRecyclerView.setAdapter(emulatorsAdapter);

        loadEmulators();
        setupSearch();

        return view;
    }

    private void loadEmulators() {
        // Mock emulator data
        emulatorsList.add(new EmulatorItem("Yuzu", "Nintendo Switch", "4.8", "https://via.placeholder.com/150"));
        emulatorsList.add(new EmulatorItem("PCSX2", "PlayStation 2", "4.7", "https://via.placeholder.com/150"));
        emulatorsList.add(new EmulatorItem("Dolphin", "GameCube/Wii", "4.9", "https://via.placeholder.com/150"));
        emulatorsList.add(new EmulatorItem("Snes9x", "SNES", "4.6", "https://via.placeholder.com/150"));
        emulatorsList.add(new EmulatorItem("mGBA", "Game Boy Advance", "4.7", "https://via.placeholder.com/150"));
        emulatorsList.add(new EmulatorItem("Mupen64Plus", "Nintendo 64", "4.5", "https://via.placeholder.com/150"));
        
        filteredList.addAll(emulatorsList);
        emulatorsAdapter.notifyDataSetChanged();
    }

    private void setupSearch() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filteredList.clear();
                if (newText.isEmpty()) {
                    filteredList.addAll(emulatorsList);
                } else {
                    for (EmulatorItem item : emulatorsList) {
                        if (item.getName().toLowerCase().contains(newText.toLowerCase()) ||
                            item.getSystem().toLowerCase().contains(newText.toLowerCase())) {
                            filteredList.add(item);
                        }
                    }
                }
                emulatorsAdapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}