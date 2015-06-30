package ca.thanasi.canditoslinearprogram.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by LaptopT on 2015-06-26.
 */
public class WorkoutDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    static final String DATABASE_NAME = "workouts.db";

    public WorkoutDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        final String SQL_CREATE_WEIGHT_TABLE = "CREATE TABLE " +
                WorkoutContract.WorkoutEntry.TABLE_NAME + " (" +
                WorkoutContract.WorkoutEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                WorkoutContract.WorkoutEntry.COLUMN_DATE + " INTEGER NOT NULL, " +
                WorkoutContract.WorkoutEntry.COLUMN_WEIGHT_ID + " INTEGER NOT NULL," +
                WorkoutContract.WorkoutEntry.COLUMN_EXERCISE_TYPE + " TEXT NOT NULL, " +
                WorkoutContract.WorkoutEntry.COLUMN_WEIGHT_LBS + " INTEGER NOT NULL, " +
                " UNIQUE (" + WorkoutContract.WorkoutEntry.COLUMN_DATE + ") ON CONFLICT REPLACE";

        sqLiteDatabase.execSQL(SQL_CREATE_WEIGHT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        // Note that this only fires if you change the version number for your database.
        // It does NOT depend on the version number for your application.
        // If you want to update the schema without wiping data, commenting out the next 2 lines
        // should be your top priority before modifying this method.
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + WorkoutContract.WorkoutEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
