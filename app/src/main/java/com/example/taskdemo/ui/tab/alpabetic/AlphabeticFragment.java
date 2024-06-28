package com.example.taskdemo.ui.tab.alpabetic;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taskdemo.R;

public class AlphabeticFragment extends Fragment {

    private AlphabeticViewModel mViewModel;

    public static AlphabeticFragment newInstance() {
        return new AlphabeticFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_alphabetic, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AlphabeticViewModel.class);
        // TODO: Use the ViewModel
    }

}