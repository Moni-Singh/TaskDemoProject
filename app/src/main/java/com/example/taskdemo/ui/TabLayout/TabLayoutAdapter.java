package com.example.demotask.ui.TabLayout;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.navigation.NavController;

import com.example.demotask.ui.tab.discover.DiscoverFragment;
import com.example.demotask.ui.tab.home.HomeFragment;
import com.example.demotask.ui.tab.sport.SportFragment;

public class TabLayoutAdapter  extends FragmentStatePagerAdapter {
    private Context myContext;
    private int totalTabs;

    public TabLayoutAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:

                return new DiscoverFragment();
            case 1:
                return new HomeFragment();
            case 2:
                return new SportFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
