package ca.thanasi.canditoslinearprogram;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.CalendarView;


public class CalendarActivity extends ActionBarActivity {
    CalendarView calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

    }
}