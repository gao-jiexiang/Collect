package com.example.collect.ui.sort;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.collect.base.BaseFragment;

import java.util.ArrayList;

public class VpSortAdapter extends FragmentStateAdapter {
    private final ArrayList<BaseFragment> mList;

    public VpSortAdapter(@NonNull FragmentActivity fragmentActivity, ArrayList<BaseFragment> list) {
        super(fragmentActivity);
        mList = list;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return mList.get(position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
