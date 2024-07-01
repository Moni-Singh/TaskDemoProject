package com.example.demotask.ui.TabLayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;

import com.example.demotask.R;
import com.example.demotask.databinding.FragmentTabMainBinding;
import com.example.demotask.utils.ApplicationSharedPreferences;
import com.google.android.material.tabs.TabLayout;

public class TabMainFragment extends Fragment {
    private FragmentTabMainBinding binding;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTabMainBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        MenuHost menuHost = requireActivity();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        tabLayout = binding.tabLayout;
        viewPager = binding.viewPager;

        tabLayout.addTab(tabLayout.newTab().setText("Discover"));
        tabLayout.addTab(tabLayout.newTab().setText("Home"));
        tabLayout.addTab(tabLayout.newTab().setText("Sport"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.getTabAt(0).select();

        final TabLayoutAdapter tabLayoutAdapter = new TabLayoutAdapter(requireContext(), getChildFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(tabLayoutAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
        });

        ((AppCompatActivity) requireActivity()).getSupportActionBar().setTitle("Main");
        menuHost.addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                menuInflater.inflate(R.menu.item_menu, menu);
            }

            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.overflowMenu) {

                    Navigation.findNavController(requireView())
                            .navigate(R.id.navigation_setting);
                }
                return true;
            }
        }, getViewLifecycleOwner());
        return root;
    }
}