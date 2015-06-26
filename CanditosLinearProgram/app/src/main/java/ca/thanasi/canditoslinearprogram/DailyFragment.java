package ca.thanasi.canditoslinearprogram;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class DailyFragment extends Fragment {
    View view;
    int i = 0;
    ListView lv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_fragment, container, false);
        TextView tvDay = ((TextView) view.findViewById(R.id.tvDay));

        ListView lv = (ListView) view.findViewById(R.id.main_list);

        tvDay.setText("Heavy Lower Day");
        List<WorkoutType> workouts = new ArrayList<WorkoutType>();
        workouts.add(new WorkoutType("Squat", 3, 6, 230, formatWeight()));
        workouts.add(new WorkoutType("Deadlift", 2, 6, 185, formatWeight()));
        workouts.add(new WorkoutType("Optional Exercise", 3, 8, 100, formatWeight()));
        workouts.add(new WorkoutType("Optional Exercise", 3, 8, 100, formatWeight()));
        RoutineArrayAdapter routineArrayAdapter = new RoutineArrayAdapter(getActivity(), 0, workouts);
        lv.setAdapter(routineArrayAdapter);


        Button btnArrowRight = ((Button) view.findViewById(R.id.btn_arrow_right));
        Button btnArrowLeft = ((Button) view.findViewById(R.id.btn_arrow_left));

        btnArrowRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                if (i > 3) {
                    i = 0;
                }
                if (i == 0) {
                    workoutOne();
                }
                if (i == 1) {
                    workoutTwo();
                }
                if (i == 2) {
                    workoutThree();
                }
                if (i == 3) {
                    workoutFour();
                }

            }
        });
        btnArrowLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i--;
                if (i < 0) {
                    i = 3;
                }
                if (i == 0) {
                    workoutOne();
                }
                if (i == 1) {
                    workoutTwo();
                }
                if (i == 2) {
                    workoutThree();
                }
                if (i == 3) {
                    workoutFour();
                }
            }
        });

        return view;
    }

    public void workoutOne() {
        ListView lv = (ListView) view.findViewById(R.id.main_list);
        TextView tvDay = ((TextView) view.findViewById(R.id.tvDay));
        tvDay.setText("Heavy Lower Day");
        List<WorkoutType> workouts = new ArrayList<WorkoutType>();
        workouts.add(new WorkoutType("Squat", 3, 6, 230, formatWeight()));
        workouts.add(new WorkoutType("Deadlift", 2, 6, 185, formatWeight()));
        workouts.add(new WorkoutType("Optional Exercise", 3, 8, 100, formatWeight()));
        workouts.add(new WorkoutType("Optional Exercise", 3, 8, 100, formatWeight()));
        RoutineArrayAdapter routineArrayAdapter = new RoutineArrayAdapter(getActivity(), 0, workouts);
        lv.setAdapter(routineArrayAdapter);

    }

    public void workoutTwo() {
        ListView lv = (ListView) view.findViewById(R.id.main_list);
        TextView tvDay = ((TextView) view.findViewById(R.id.tvDay));
        tvDay.setText("Heavy Upper Day");
        List<WorkoutType> workouts2 = new ArrayList<WorkoutType>();
        workouts2.add(new WorkoutType("Bench Press", 3, 6, 165, formatWeight()));
        workouts2.add(new WorkoutType("Horizontal Pull", 3, 6, 185, formatWeight()));
        workouts2.add(new WorkoutType("Shoulder Press", 1, 6, 60, formatWeight()));
        workouts2.add(new WorkoutType("Vertical Pull", 1, 6, 30, formatWeight()));
        workouts2.add(new WorkoutType("Optional Exercise", 3, 8, "-12", 100, formatWeight()));
        workouts2.add(new WorkoutType("Optional Exercise", 3, 8, "-12", 100, formatWeight()));
        RoutineArrayAdapter routineArrayAdapter = new RoutineArrayAdapter(getActivity(), 0, workouts2);
        lv.setAdapter(routineArrayAdapter);

    }

    public void workoutThree() {
        ListView lv = (ListView) view.findViewById(R.id.main_list);
        TextView tvDay = ((TextView) view.findViewById(R.id.tvDay));
        tvDay.setText("Hypertrophy Lower Day");
        List<WorkoutType> workouts3 = new ArrayList<WorkoutType>();
        workouts3.add(new WorkoutType("Squat", 5, 8, 185, formatWeight()));
        workouts3.add(new WorkoutType("Deadlift Variation", 3, 8, 185, formatWeight()));
        workouts3.add(new WorkoutType("Hamstring Curl", 3, 12, 140, formatWeight()));
        workouts3.add(new WorkoutType("Calf Raise", 5, 15, 140, formatWeight()));
        workouts3.add(new WorkoutType("Optional Exercise", 4, 8, "-12", 100, formatWeight()));
        workouts3.add(new WorkoutType("Optional Exercise", 4, 8, "-12", 100, formatWeight()));
        RoutineArrayAdapter routineArrayAdapter = new RoutineArrayAdapter(getActivity(), 0, workouts3);
        lv.setAdapter(routineArrayAdapter);

    }

    public void workoutFour() {
        ListView lv = (ListView) view.findViewById(R.id.main_list);
        TextView tvDay = ((TextView) view.findViewById(R.id.tvDay));
        tvDay.setText("Hypertrophy Upper Day");
        List<WorkoutType> workouts4 = new ArrayList<WorkoutType>();
        workouts4.add(new WorkoutType("Bench Press", 4, 8, 155, formatWeight()));
        workouts4.add(new WorkoutType("Incline Bench Press", 4, 8, 60, formatWeight()));
        workouts4.add(new WorkoutType("Horizontal Pull", 4, 8, 170, formatWeight()));
        workouts4.add(new WorkoutType("Vertical Pull", 4, 8, 140, formatWeight()));
        workouts4.add(new WorkoutType("Shoulder Press", 3, 10, 140, formatWeight()));
        workouts4.add(new WorkoutType("Optional Exercise", 4, 8, "-12", 100, formatWeight()));
        workouts4.add(new WorkoutType("Optional Exercise", 4, 8, "-12", 100, formatWeight()));
        RoutineArrayAdapter routineArrayAdapter = new RoutineArrayAdapter(getActivity(), 0, workouts4);
        lv.setAdapter(routineArrayAdapter);

    }

    public String formatWeight() {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String unitType = sharedPrefs.getString(getString(R.string.pref_units_key), getString(R.string.pref_units_lbs));

        if (unitType.equals(getString(R.string.pref_units_kg))) {
            return getString(R.string.pref_units_kg);
        } else return getString(R.string.pref_units_lbs);
    }

}