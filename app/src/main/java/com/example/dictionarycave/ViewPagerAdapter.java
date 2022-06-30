

package com.example.dictionarycave;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public Fragment getItem(int position) {
        if(position == 0){
            return new fragment1();
        } else if(position == 1){
            return new fragment2();
        } else{
            return new fragment3();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    // TODO: 29-06-2022 place names according to position on tabs
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return "One";
        } else if(position == 1){
            return "Two";
        } else{
            return "Three";
        }
    }
}
