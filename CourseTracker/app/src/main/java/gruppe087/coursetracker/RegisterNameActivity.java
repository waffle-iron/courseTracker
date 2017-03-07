package gruppe087.coursetracker;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;
import android.widget.Button;
import android.widget.EditText;

public class RegisterNameActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register_name);

        final Button button = (Button) findViewById(R.id.dummy_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Define action on click
<<<<<<< HEAD
                Intent myIntent = new Intent(RegisterNameActivity.this, MainActivity.class);
=======
                //Intent myIntent = new Intent(RegisterNameActivity.this, TodayOverviewActivity.class);
                Intent myIntent = new Intent(RegisterNameActivity.this, ChooseCourseAtSetupActivity.class);
>>>>>>> b051882ba731b37e53bcca9f12ed96df61131446
                //Optional parameters: myIntent.putExtra("key", value);
                RegisterNameActivity.this.startActivity(myIntent);
            }
        });
    }
}
