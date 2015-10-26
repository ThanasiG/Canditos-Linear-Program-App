package ca.thanasi.canditoslinearprogram;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.liuguangqiang.swipeback.SwipeBackActivity;
import com.liuguangqiang.swipeback.SwipeBackLayout;
import com.manuelpeinado.fadingactionbar.FadingActionBarHelper;


public class DetailActivity extends SwipeBackActivity {

    private Toolbar mToolbar;
    String index_current = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setDragEdge(SwipeBackLayout.DragEdge.LEFT);


        //Toolbar
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        //mToolbar.setLogo(R.mipmap.ic_launcher);
        mToolbar.setTitle(" Bench Press");
        setSupportActionBar(mToolbar);
        if (Build.VERSION.SDK_INT >= 21) {// Could also use Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.rgb(0, 123, 164));

            mToolbar.setElevation(20.00f);
        }
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Intent intentGet = getIntent();
        //index_current = intentGet.getStringExtra("itemclicked");
        Bundle bundle = getIntent().getExtras();
        index_current = bundle.getString("itemclicked");

        if (index_current == "") {
            Toast.makeText(this, "Error getting index!", Toast.LENGTH_LONG).show();
        } else {
            mToolbar.setTitle(index_current);
            TextView exDiagram = (TextView) findViewById(R.id.exercise_diagram);
            TextView exInstruction = (TextView) findViewById(R.id.exercise_text);
            if (mToolbar.getTitle().toString().contains("Squat")) {
                exDiagram.setBackgroundResource(R.drawable.squat_2);
                exInstruction.setText(R.string.squat_instructions);
            }
            else if (mToolbar.getTitle().toString().contains("Deadlift")) {
                exDiagram.setBackgroundResource(R.drawable.deadlift2);
            }
            else if (mToolbar.getTitle().toString().contains("Bench")) {
                exDiagram.setBackgroundResource(R.drawable.bench_press_2);
                exInstruction.setText(R.string.bench_instructions);
            }
            else if (mToolbar.getTitle().toString().contains("Horizontal")) {
                exDiagram.setBackgroundResource(R.drawable.row_2);
            }
            else if (mToolbar.getTitle().toString().contains("Shoulder")) {
                exDiagram.setBackgroundResource(R.drawable.shoulder_press_2);
            }
            else if (mToolbar.getTitle().toString().contains("Vertical")) {
                exDiagram.setBackgroundResource(R.drawable.pullup_2);
            }
            else if (mToolbar.getTitle().toString().contains("Hamstring")) {
                exDiagram.setBackgroundResource(R.drawable.leg_curl_2);
            }
            else {
                exDiagram.setBackgroundResource(R.drawable.bench_press_2);
            }

        }


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_about) {
            startActivity(new Intent(this, AboutActivity.class));
            return true;
        }
        if (id == R.id.home) {
            this.finish();
            return true;
        }
        if (id == R.id.action_youtube) {
            Intent intent = new Intent(Intent.ACTION_SEARCH);
            intent.setPackage("com.google.android.youtube");
            intent.putExtra("query", "How To Bench Press");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*public int getShownIndex() {

        // Returns the index assigned
        return getArguments().getInt("index", 0);
    }*/

}
