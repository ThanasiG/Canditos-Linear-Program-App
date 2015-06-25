package ca.thanasi.canditoslinearprogram;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by LaptopT on 2015-05-27.
 */
public class RoutineArrayAdapter extends ArrayAdapter {
    Activity mActivityContext;
    List<WorkoutType> mItems;

    public RoutineArrayAdapter(Activity context, int resource, List<WorkoutType> items) {
        super(context, resource, items);

        this.mActivityContext = context;
        this.mItems = items;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = mActivityContext.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.activity_routine_list_row, null, true);

        TextView tvName = ((TextView) rowView.findViewById(R.id.textName));
        TextView tvSets = ((TextView) rowView.findViewById(R.id.textSets));
        TextView tvReps = ((TextView) rowView.findViewById(R.id.textReps));
        TextView tvWeight = ((TextView) rowView.findViewById(R.id.textWeight));
        TextView tvWeightType = ((TextView) rowView.findViewById(R.id.textWeightType));

        tvName.setText(mItems.get(position).mName);
        tvSets.setText(mItems.get(position).mSets + " x");
        tvReps.setText(mItems.get(position).mReps + "");
        tvWeight.setText(mItems.get(position).mWeight + "");

        if (mItems.get(position).mName.contains("Optional")) {
            tvReps.setText(mItems.get(position).mReps + "-12");
        }
        if (mItems.get(position).mWeightType != null) {
            tvWeightType.setText(mItems.get(position).mWeightType.toString().toLowerCase());
        }

        return rowView;
    }


}