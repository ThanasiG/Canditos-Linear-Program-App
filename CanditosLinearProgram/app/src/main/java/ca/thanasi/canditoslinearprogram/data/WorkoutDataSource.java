package ca.thanasi.canditoslinearprogram.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import ca.thanasi.canditoslinearprogram.DailyFragment;
import ca.thanasi.canditoslinearprogram.WorkoutType;

/**
 * Created by LaptopT on 2015-06-27.
 */
public class WorkoutDataSource extends SQLiteOpenHelper {

    private SQLiteDatabase database;

    DailyFragment dailyFragment;

    private static final int DATABASE_VERSION = 1;

    static final String DATABASE_NAME = "workouts.db";

    public static final String TABLE_NAME = "weight";

    public static final String _ID = "id";

    public static final String COLUMN_DATE = "date";

    public static final String COLUMN_EXERCISE_TYPE = "exercise_type";

    public static final String COLUMN_WEIGHT_LBS = "weight_lbs";

    //public static final String sortOrder = COLUMN_DATE + " ASC";

    public WorkoutDataSource(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        dailyFragment = new DailyFragment();

        final String SQL_CREATE_WEIGHT_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_DATE + " INTEGER NOT NULL, " +
                COLUMN_EXERCISE_TYPE + " TEXT NOT NULL, " +
                COLUMN_WEIGHT_LBS + " INTEGER NOT NULL"/*, " +
                " UNIQUE (" + COLUMN_DATE + ") ON CONFLICT REPLACE"*/;

        sqLiteDatabase.execSQL(SQL_CREATE_WEIGHT_TABLE);
    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
    }

    public int createExercise(int date, String exercise_type, int weight_lbs) {
        try {
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_DATE, date);
            cv.put(COLUMN_EXERCISE_TYPE, exercise_type);
            cv.put(COLUMN_WEIGHT_LBS, weight_lbs);

            return (int) database.insert(TABLE_NAME, null, cv);
        } catch (Exception e) {
            Log.e("CanditosLinearProgram", (e.getMessage() != null) ? e.getMessage() : "Error inserting");
        }
        return -1;
    }

    public void updateExercise(int id, int date, String exercise_type, int weight_lbs) {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_DATE, date);
        cv.put(COLUMN_EXERCISE_TYPE, exercise_type);
        cv.put(COLUMN_WEIGHT_LBS, weight_lbs);

        database.update(TABLE_NAME, cv, "id = ?", new String[] {String.valueOf(id)});
    }

    public List<WorkoutType> getExercises(){
        List<WorkoutType> wOuts = new ArrayList<WorkoutType>();
        try {
            Cursor cur = database.query(TABLE_NAME, new String[] {_ID, COLUMN_DATE, COLUMN_EXERCISE_TYPE, COLUMN_WEIGHT_LBS}, null, null, null, null, null);
            cur.moveToFirst();
            while(!cur.isAfterLast()) {
                wOuts.add(new WorkoutType(cur.getInt(0), cur.getInt(1), "Bench Press", 4, 8, cur.getInt(3), dailyFragment.formatWeight()));
                cur.moveToNext();
            }
            cur.close();
        }catch (Exception e) {
        }
        return wOuts;
    }

    public WorkoutType getExercise(int id) {
        WorkoutType workoutType = null;

        try {
            Cursor cur = database.query(TABLE_NAME, new String[] {"id", "restaurant", "address", "phone", "desc", "tags", "rating"},"id = ?", new String[]{String.valueOf(id)}, null, null, null);
            cur.moveToFirst();
            if(!cur.isAfterLast()) {
                workoutType = new WorkoutType(cur.getInt(0), cur.getInt(1), "Bench Press", 4, 8, cur.getInt(3), dailyFragment.formatWeight());
            }
            cur.close();
        }catch (Exception e) {
        }
        return workoutType;
    }
}
