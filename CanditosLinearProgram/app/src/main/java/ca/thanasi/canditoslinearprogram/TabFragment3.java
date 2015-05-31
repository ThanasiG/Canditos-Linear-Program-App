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


public class TabFragment3 extends Fragment {
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_fragment, container, false);
        TextView tvDay = ((TextView)view.findViewById(R.id.tvDay));

        ListView lv = (ListView)view.findViewById(R.id.main_list);

        tvDay.setText("Hypertrophy Lower Day");
        List<WorkoutType> workouts = new ArrayList<WorkoutType>();
        workouts.add(new WorkoutType("Squat", 5, 8, 185, WeightType.LBS));
        workouts.add(new WorkoutType("Deadlift Variation", 3, 8, 185, WeightType.LBS));
        workouts.add(new WorkoutType("Hamstring Curl", 3, 12, 140, WeightType.LBS));
        workouts.add(new WorkoutType("Calf Raise", 5, 15, 140, WeightType.LBS));
        workouts.add(new WorkoutType("Optional Exercise", 4, 8, "-12 reps"));
        workouts.add(new WorkoutType("Optional Exercise", 4, 8, "-12 reps"));

        RoutineArrayAdapter routineArrayAdapter = new RoutineArrayAdapter(getActivity(), 0, workouts);
        lv.setAdapter(routineArrayAdapter);

        return view;
    }

}