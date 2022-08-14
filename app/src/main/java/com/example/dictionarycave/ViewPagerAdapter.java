

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

    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return "Oxford Dictionary";
        } else if(position == 1){
            return "Hindi Dictionary";
        } else{
            return "Collins Dictionary";
        }
    }
}
