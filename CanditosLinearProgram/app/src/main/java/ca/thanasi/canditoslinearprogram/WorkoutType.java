package ca.thanasi.canditoslinearprogram;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by LaptopT on 2015-05-27.
 */
public class WorkoutType {
    public int mId;
    public int mDate;
    public String mName;
    public int mSets;
    public int mReps;
    public String mReps2;
    public int mWeight;
    public String mWeightType;

    public WorkoutType(int mId, int mDate, String mName, int mSets, int mReps, int mWeight, String mWeightType) {
        this.mId = mId;
        this.mDate = mDate;
        this.mName = mName;
        this.mSets = mSets;
        this.mReps = mReps;
        this.mWeight = mWeight;
        this.mWeightType = mWeightType;
    }

    public WorkoutType(int mId, int mDate, String mName, int mSets, int mReps, String mReps2, int mWeight, String mWeightType) {
        this.mId = mId;
        this.mDate = mDate;
        this.mName = mName;
        this.mSets = mSets;
        this.mReps = mReps;
        this.mReps2 = mReps2;
        this.mWeight = mWeight;
        this.mWeightType = mWeightType;
    }


    //OLD CONSTRUCTORS, TEMPORARY

    public WorkoutType(String mName, int mSets, int mReps, int mWeight, String mWeightType) {
        this.mName = mName;
        this.mSets = mSets;
        this.mReps = mReps;
        this.mWeight = mWeight;
        this.mWeightType = mWeightType;
    }

    public WorkoutType(String mName, int mSets, int mReps, String mReps2, int mWeight, String mWeightType) {
        this.mName = mName;
        this.mSets = mSets;
        this.mReps = mReps;
        this.mReps2 = mReps2;
        this.mWeight = mWeight;
        this.mWeightType = mWeightType;
    }

}
