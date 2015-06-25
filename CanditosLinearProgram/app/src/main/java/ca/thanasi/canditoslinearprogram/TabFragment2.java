package ca.thanasi.canditoslinearprogram;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class TabFragment2 extends Fragment {
    View view;
    DailyFragment dailyFragment = new DailyFragment();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_fragment, container, false);
        TextView tvDay = ((TextView)view.findViewById(R.id.tvDay));

        ListView lv = (ListView)view.findViewById(R.id.main_list);

        tvDay.setText("Heavy Upper Day");
        List<WorkoutType> workouts = new ArrayList<WorkoutType>();
        workouts.add(new WorkoutType("Bench Press", 3, 6, 165, dailyFragment.formatWeight()));
        workouts.add(new WorkoutType("Horizontal Pull", 3, 6, 185, dailyFragment.formatWeight()));
        workouts.add(new WorkoutType("Shoulder Press", 1, 6, 60, dailyFragment.formatWeight()));
        workouts.add(new WorkoutType("Vertical Pull", 1, 6, 30, dailyFragment.formatWeight()));
        workouts.add(new WorkoutType("Optional Exercise", 3, 8, "-12", 100, dailyFragment.formatWeight()));
        workouts.add(new WorkoutType("Optional Exercise", 3, 8, "-12", 100, dailyFragment.formatWeight()));

        RoutineArrayAdapter routineArrayAdapter = new RoutineArrayAdapter(getActivity(), 0, workouts);
        lv.setAdapter(routineArrayAdapter);

        return view;
    }

}