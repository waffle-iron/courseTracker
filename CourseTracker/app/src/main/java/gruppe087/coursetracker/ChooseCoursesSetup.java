package gruppe087.coursetracker;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ChooseCoursesSetup extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_courses_setup);

        // Get reference of widgets from XML layout
        final ListView lv = (ListView) findViewById(R.id.lv_choose_courses_setup);

        // Get the intent, verify the action and get the query
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            doMySearch(query, lv);
        }




    }

    private void doMySearch(String query, ListView lv){
        // Initializing getRequest class
        HttpGetRequest getRequest = new HttpGetRequest();
        String coursecode = "IE501109";
        String result;
        try {
            result = getRequest.execute(coursecode).get();
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
                String location = jsonObject.getString("location");
                String time = jsonObject.getString("TIME_FORMAT(time, '%H:%i')");

                System.out.println(courseName + " @ " + location + ": " + time);
                overview_list.add(courseName + " @ " + location + ": " + time);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Initializing a new String Array
        String[] courses
                = new String[]{
                "KTN @ R1, 09.15-11.00",
                "MMI @ S3, 12.15-14.00",
                "PU @ R1, 14.15-16.00",

        };

        // Create a List from String Array elements
        final List<String> course_list = new ArrayList<String>(Arrays.asList(courses));
        // Create an ArrayAdapter from List
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, overview_list);

        // DataBind ListView with items from ArrayAdapter
        lv.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
    }


}
