package gruppe087.coursetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // When Sign up button pushed
        final Button button = (Button) findViewById(R.id.buttonCreateAccount);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                // Define action on click
                Intent myIntent = new Intent(SignupActivity.this, ChooseCourseAtSetupActivity.class);
                //Optional parameters: myIntent.putExtra("key", value);
                SignupActivity.this.startActivity(myIntent);
            }
        });
    }
}
