package ca.thanasi.canditoslinearprogram;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    // Holds tab titles
    private String tabTitles[] = new String[]{"Daily", "Monthly", "Goals"};
    private Context context;

    public MyFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return 3;
    }

    // Return the correct Fragment based on index
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new DailyFragment();
        } else if (position == 1) {
            return new MonthlyFragment();
        } else if (position == 2) {
            return new GoalsFragment();
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Return the tab title to SlidingTabLayout
        return tabTitles[position];
    }
}