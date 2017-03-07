package gruppe087.coursetracker;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class ChooseCourseAtSetupActivity extends AppCompatActivity {

    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> listItems = new ArrayList<String>();
    ListView lv;
    EditText et;
    HttpGetRequest getRequest;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_course_at_setup);

        lv = (ListView)findViewById(R.id.initlv);
        arrayAdapter = new ArrayAdapter<String>(this,R.layout.list_text_view, listItems);

        //START LISTVIEW

        lv = (ListView) findViewById(R.id.initlv);
        et = (EditText) findViewById(R.id.searchtxt);

        initList();
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //END LISTVIEW

        final Button button = (Button) findViewById(R.id.dummy_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Define action on click
                //Intent myIntent = new Intent(RegisterNameActivity.this, TodayOverviewActivity.class);
                Intent myIntent = new Intent(ChooseCourseAtSetupActivity.this, MainActivity.class);
                //Optional parameters: myIntent.putExtra("key", value);
                ChooseCourseAtSetupActivity.this.startActivity(myIntent);
            }
        });

    }

    public void initList(){
        // Initializing getRequest class
        getRequest = new HttpGetRequest("addCoursesSetup.php");
        String result;
        try {
            result = getRequest.execute().get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
            result=null;
        } catch (ExecutionException e) {
            e.printStackTrace();
            result=null;
        }


        String[] overview = new String[]{};
        final List<String> overview_list = new ArrayList<String>(Arrays.asList(overview));

        // Parsing the result and turning it into an JSONArray, so that it is simpler to pick
        // out the fields that are wanted.
        try {
            JSONArray jsonArray = new JSONArray(result);
            for (int i = 0; i<jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String courseID = jsonObject.getString("courseID");
                String courseName = jsonObject.getString("courseName");
                //String location = jsonObject.getString("location");
                //String time = jsonObject.getString("TIME_FORMAT(time, '%H:%i')");

                System.out.println(courseID);
                overview_list.add(courseID + "\t" + courseName);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        // Create a List from String Array elements
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, overview_list);


        // DataBind ListView with items from ArrayAdapter
        lv.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button.
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
