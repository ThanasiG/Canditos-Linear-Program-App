package ca.thanasi.canditoslinearprogram;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.TaskStackBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ca.thanasi.canditoslinearprogram.data.WorkoutDataSource;


public class DailyFragment extends Fragment {
    View view;
    int i = 0;
    int mCurCheckPosition = 0;
    ListView lv;
    private WorkoutType workout;
    private WorkoutDataSource dataSource;

    int squatHeavy = 245;
    int deadliftHeavy = 305;
    int opt1LHeavy = 95;
    int opt2LHeavy = 85;

    int benchHeavy = 185;
    int rowHeavy = 180;
    int shoulderHeavy = 115;
    int pullupHeavy = 35;
    int opt1UHeavy = 90;
    int opt2UHeavy = 85;

    int squatHyper = 225;
    int deadliftHyper = 230;
    int hamCurlHyper = 140;
    int calfRaiseHyper = 150;
    int opt1LHyper = 140;
    int opt2LHyper = 120;

    int benchHyper = 175;
    int incBenchHyper = 145;
    int rowHyper = 165;
    int pullupHyper = 30;
    int shoulderHyper = 95;
    int opt1UHyper = 85;
    int opt2UHyper = 75;
    String positionName = "";
    TextView tvDay;
    List<WorkoutType> workouts = new ArrayList<WorkoutType>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_fragment, container, false);
        tvDay = ((TextView) view.findViewById(R.id.tvDay));
        lv = (ListView) view.findViewById(R.id.main_list);

        workoutOne();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView name = (TextView)view.findViewById(R.id.textName);

                positionName = name.getText().toString();

                TaskStackBuilder.create(getActivity())
                        .addParentStack(MainActivity.class)
                        .addNextIntent(new Intent(getActivity(), MainActivity.class))
                        .startActivities();
                showDetails(position, positionName);

            }
        });

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
                else if (i == 1) {
                    workoutTwo();
                }
                else if (i == 2) {
                    workoutThree();
                }
                else if (i == 3) {
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
                else if (i == 1) {
                    workoutTwo();
                }
                else if (i == 2) {
                    workoutThree();
                }
                else if (i == 3) {
                    workoutFour();
                }
            }
        });

        return view;
    }

    public void workoutOne() {
        tvDay.setText("Heavy Lower Day");
        workouts.clear();
        workouts.add(new WorkoutType("Squat", 3, 6, squatHeavy, formatWeight()));
        workouts.add(new WorkoutType("Deadlift", 2, 6, deadliftHeavy, formatWeight()));
        workouts.add(new WorkoutType("Optional Exercise", 3, 8, opt1LHeavy, formatWeight()));
        workouts.add(new WorkoutType("Optional Exercise", 3, 8, opt2LHeavy, formatWeight()));
        RoutineArrayAdapter routineArrayAdapter = new RoutineArrayAdapter(getActivity(), 0, workouts);
        lv.setAdapter(routineArrayAdapter);

    }

    public void workoutTwo() {
        tvDay.setText("Heavy Upper Day");
        workouts.clear();
        workouts.add(new WorkoutType("Bench Press", 3, 6, benchHeavy, formatWeight()));
        workouts.add(new WorkoutType("Horizontal Pull", 3, 6, rowHeavy, formatWeight()));
        workouts.add(new WorkoutType("Shoulder Press", 1, 6, shoulderHeavy, formatWeight()));
        workouts.add(new WorkoutType("Vertical Pull", 1, 6, pullupHeavy, formatWeight()));
        workouts.add(new WorkoutType("Optional Exercise", 3, 8, "-12", opt1UHeavy, formatWeight()));
        workouts.add(new WorkoutType("Optional Exercise", 3, 8, "-12", opt2UHeavy, formatWeight()));
        RoutineArrayAdapter routineArrayAdapter = new RoutineArrayAdapter(getActivity(), 0, workouts);
        lv.setAdapter(routineArrayAdapter);

    }

    public void workoutThree() {
        tvDay.setText("Hypertrophy Lower Day");
        workouts.clear();
        workouts.add(new WorkoutType("Squat", 5, 8, squatHyper, formatWeight()));
        workouts.add(new WorkoutType("Deadlift Variation", 3, 8, deadliftHyper, formatWeight()));
        workouts.add(new WorkoutType("Hamstring Curl", 3, 12, hamCurlHyper, formatWeight()));
        workouts.add(new WorkoutType("Calf Raise", 5, 15, calfRaiseHyper, formatWeight()));
        workouts.add(new WorkoutType("Optional Exercise", 4, 8, "-12", opt1LHyper, formatWeight()));
        workouts.add(new WorkoutType("Optional Exercise", 4, 8, "-12", opt2LHyper, formatWeight()));
        RoutineArrayAdapter routineArrayAdapter = new RoutineArrayAdapter(getActivity(), 0, workouts);
        lv.setAdapter(routineArrayAdapter);

    }

    public void workoutFour() {
        tvDay.setText("Hypertrophy Upper Day");
        workouts.clear();
        workouts.add(new WorkoutType("Bench Press", 4, 8, benchHyper, formatWeight()));
        workouts.add(new WorkoutType("Incline Bench Press", 4, 8, incBenchHyper, formatWeight()));
        workouts.add(new WorkoutType("Horizontal Pull", 4, 8, rowHyper, formatWeight()));
        workouts.add(new WorkoutType("Vertical Pull", 4, 8, pullupHyper, formatWeight()));
        workouts.add(new WorkoutType("Shoulder Press", 3, 10, shoulderHyper, formatWeight()));
        workouts.add(new WorkoutType("Optional Exercise", 4, 8, "-12", opt1UHyper, formatWeight()));
        workouts.add(new WorkoutType("Optional Exercise", 4, 8, "-12", opt2UHyper, formatWeight()));
        RoutineArrayAdapter routineArrayAdapter = new RoutineArrayAdapter(getActivity(), 0, workouts);
        lv.setAdapter(routineArrayAdapter);

    }

    public String formatWeight() {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String unitType = sharedPrefs.getString(getString(R.string.pref_units_key), getString(R.string.pref_units_lbs));

        if (unitType.equals(getString(R.string.pref_units_kg))) {
            return getString(R.string.pref_units_kg);
        } else return getString(R.string.pref_units_lbs);
    }

    public void loadWorkout(final int id) {
        workout = dataSource.getExercise(id);
        if (workout != null) {
            ((TextView) view.findViewById(R.id.textName)).setText(workout.mName);
        }
    }

    void showDetails(int index, String name) {
        mCurCheckPosition = index;
        Intent intent = new Intent();
        intent.setClass(getActivity(), DetailActivity.class);

        intent.putExtra("index", index);
        intent.putExtra("itemclicked", name);
        startActivity(intent);
    }

    /*if (formatWeight() == getString(R.string.pref_units_kg)) {
            benchHeavy = (int)Math.round(benchHeavy / 2.20462);
            rowHeavy = (int)Math.round(rowHeavy / 2.20462);
            shoulderHeavy = (int)Math.round(shoulderHeavy / 2.20462);
            pullupHeavy = (int)Math.round(pullupHeavy / 2.20462);
            opt1LHeavy = (int)Math.round(opt1LHeavy / 2.20462);
            opt2LHeavy = (int)Math.round(opt2LHeavy / 2.20462);
        }
*/
}