package ca.thanasi.canditoslinearprogram;

/**
 * Created by LaptopT on 2015-05-27.
 */
public class WorkoutType {
    public String mName;
    public int mSets;
    public int mReps;
    public String mReps2;
    public int mWeight;
    public WeightType mWeightType;

    public WorkoutType(String mName, int mSets, int mReps, int mWeight, WeightType mWeightType) {
        this.mName = mName;
        this.mSets = mSets;
        this.mReps = mReps;
        this.mWeight = mWeight;
        this.mWeightType = mWeightType;
    }

    public WorkoutType(String mName, int mSets, int mReps, String mReps2) {
        this.mName = mName;
        this.mSets = mSets;
        this.mReps = mReps;
        this.mReps2 = mReps2;
    }

}
