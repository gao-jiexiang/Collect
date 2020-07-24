package com.example.collect.ui.main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import com.example.collect.base.BaseFragment;

import java.util.ArrayList;

public class VpMainAdapter extends FragmentPagerAdapter {
    private final ArrayList<BaseFragment> mFragments;
    private final ArrayList<String> mTitles;

    public VpMainAdapter(@NonNull FragmentManager fm, ArrayList<BaseFragment> fragments, ArrayList<String> titles) {
        super(fm);
        mFragments = fragments;
        mTitles = titles;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
