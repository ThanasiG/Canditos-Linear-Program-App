package ca.thanasi.canditoslinearprogram;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    // Holds tab titles
    private String tabTitles[] = new String[]{"Monday", "Tuesday", "Thursday", "Friday"};
    private Context context;

    public MyFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return 4;
    }

    // Return the correct Fragment based on index
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new TabFragment1();
        } else if (position == 1) {
            return new TabFragment2();
        } else if (position == 2) {
            return new TabFragment3();
        } else if (position == 3) {
            return new TabFragment4();
        }

        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Return the tab title to SlidingTabLayout
        return tabTitles[position];
    }
}