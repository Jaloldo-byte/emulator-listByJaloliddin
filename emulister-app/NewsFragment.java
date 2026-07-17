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

public class NewsFragment extends Fragment {
    private RecyclerView newsRecyclerView;
    private NewsAdapter newsAdapter;
    private List<NewsItem> newsList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        newsRecyclerView = view.findViewById(R.id.news_recycler_view);
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        
        newsList = new ArrayList<>();
        newsAdapter = new NewsAdapter(newsList, getContext());
        newsRecyclerView.setAdapter(newsAdapter);

        loadNews();

        return view;
    }

    private void loadNews() {
        newsList.add(new NewsItem("Yuzu 15.0 Released", "Major performance improvements and new features", "2 hours ago", "https://via.placeholder.com/300"));
        newsList.add(new NewsItem("PCSX2 Gets Better Support", "Latest update improves PS2 game compatibility", "5 hours ago", "https://via.placeholder.com/300"));
        newsList.add(new NewsItem("Dolphin Reaches New Milestone", "GameCube emulation now at 95% compatibility", "1 day ago", "https://via.placeholder.com/300"));
        newsList.add(new NewsItem("RetroArch 1.15 Out Now", "Multi-system emulator with new cores", "2 days ago", "https://via.placeholder.com/300"));
        
        newsAdapter.notifyDataSetChanged();
    }
}