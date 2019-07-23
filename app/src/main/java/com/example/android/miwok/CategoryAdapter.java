package com.example.android.miwok;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * Created by admin on 26-06-2016.
 */
public class CategoryAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[] { "Numbers", "Colors", "Family", "Phrases","Weekdays","A","B","C","D","User Defined"};

    public CategoryAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public androidx.fragment.app.Fragment getItem(int position) {
        if (position == 0) {
            return new NumbersFragment();
        } else if (position == 1){
            return new ColorsFragment();
        } else if (position == 2) {
            return new FamilyFragment();
        }
        else if(position==3){
            return new PhrasesFragment();
        }
        else if(position==4){
            return new DaysOfWeekFragment();
        }
        else if(position==5){
            return new A();
        }
        else if(position==6){
            return new B();
        }
        else if(position==7){
            return new C();
        }
        else if (position==8){
            return new D();
        }
        else return new UserDefined();
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }

}
