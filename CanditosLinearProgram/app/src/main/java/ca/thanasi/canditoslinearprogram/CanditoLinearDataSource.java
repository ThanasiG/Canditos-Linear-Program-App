package ca.thanasi.canditoslinearprogram;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by LaptopT on 2015-05-24.
 */
public class CanditoLinearDataSource extends SQLiteOpenHelper {

    private SQLiteDatabase database;
    private static final String DB_NAME = "canditolinearweights.db";
    private static final int DB_VERSION = 1;

    public static final String STRENGTH_HYPERTROPHY_TABLE = "strhyp";


    public CanditoLinearDataSource(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        try {
            database = getWritableDatabase();
        } catch (Exception e) {
            Log.e("CanditosLinearProgram", "Error opening Database");
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            String TABLE_CREATE = "CREATE TABLE " + STRENGTH_HYPERTROPHY_TABLE +
                    " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "EXERCISE TEXT, WEIGHT INTEGER";
            db.execSQL(TABLE_CREATE);
        } catch (Exception e) {
            Log.e("CanditosLinearProgram", "Error creating table");
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE IF EXISTS " + STRENGTH_HYPERTROPHY_TABLE);
    }
}
