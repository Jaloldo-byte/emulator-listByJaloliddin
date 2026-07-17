package com.jaloldo.emulister;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView newsRecyclerView;
    private ProgressBar progressBar;
    private NewsAdapter newsAdapter;
    private List<NewsItem> newsList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        newsRecyclerView = view.findViewById(R.id.news_recycler_view);
        progressBar = view.findViewById(R.id.progress_bar);

        newsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        newsList = new ArrayList<>();
        newsAdapter = new NewsAdapter(newsList, getContext());
        newsRecyclerView.setAdapter(newsAdapter);

        loadNews();

        return view;
    }

    private void loadNews() {
        // Mock news data - In production, fetch from API
        newsList.add(new NewsItem("New Yuzu Switch Emulator Update!", "Yuzu 15.0 released with improved performance", "2 hours ago", "https://via.placeholder.com/300"));
        newsList.add(new NewsItem("PCSX2 PS2 Emulator Reaches Milestone", "Better game compatibility achieved", "5 hours ago", "https://via.placeholder.com/300"));
        newsList.add(new NewsItem("Dolphin GameCube Emulator 5.0", "Major graphics improvements", "1 day ago", "https://via.placeholder.com/300"));
        
        newsAdapter.notifyDataSetChanged();
        progressBar.setVisibility(View.GONE);
    }
}