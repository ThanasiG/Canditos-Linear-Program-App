package ca.thanasi.canditoslinearprogram.data;

import android.net.Uri;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;
import android.text.format.Time;

/**
 * Created by LaptopT on 2015-06-26.
 */
public class WorkoutContract {

    public static final String CONTENT_AUTHORITY = "ca.thanasi.canditoslinearprogram";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_WEIGHT = "weight";

    public static long normalizeDate(long startDate) {
        Time time = new Time();
        time.set(startDate);
        int julianDay = Time.getJulianDay(startDate, time.gmtoff);
        return time.setJulianDay(julianDay);
    }

    public static final class WorkoutEntry implements BaseColumns {

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_WEIGHT).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_WEIGHT;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_WEIGHT;

        public static final String TABLE_NAME = "weight";

        public static final String COLUMN_DATE = "date";

        public static final String COLUMN_WEIGHT_ID = "weight_id";

        public static final String COLUMN_EXERCISE_TYPE = "exercise_type";

        public static final String COLUMN_WEIGHT_LBS = "weight_lbs";

        public static Uri buildWeightUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static long getDateFromUri(Uri uri) {
            return Long.parseLong(uri.getPathSegments().get(1));
        }

        public static long getStartDateFromUri(Uri uri) {
            String dateString = uri.getQueryParameter(COLUMN_DATE);
            if (null != dateString && dateString.length() > 0)
                return Long.parseLong(dateString);
            else
                return 0;
        }


    }
}
