package com.example.taskdemo.ui.tab.discover;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.taskdemo.R;
import com.example.taskdemo.VersionModel;

public class CoordinatorFragment extends Fragment {
    RecyclerView recyclerView;
    ViewPager2 viewPager;
    SimpleStringRecyclerViewAdapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.coordinator_layout, container, false);

        // Initialize ViewPager2
        viewPager = rootView.findViewById(R.id.viewPager);
        setupViewPager();

        // Initialize RecyclerView
        recyclerView = rootView.findViewById(R.id.recyclerView);
        setupRecyclerView();

        return rootView;
    }

    private void setupViewPager() {

        adapter = new SimpleStringRecyclerViewAdapter(getActivity(), VersionModel.imageUrls); // Replace with your actual data
        if (viewPager != null) {
            viewPager.setAdapter(adapter);
        }
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new SimpleStringRecyclerViewAdapter(getActivity(), VersionModel.data));
    }
}
