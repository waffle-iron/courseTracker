package gruppe087.coursetracker;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class OverviewFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_overview, container, false);
    }

    /*    // Tatt fra gamle Activity'en før vi gikk over til fragments
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_missed_lectures);


    // Get reference of widgets from XML layout
    final ListView lv = (ListView) findViewById(R.id.lv);

    // Initializing a new String Array
    String[] missed
            = new String[] {
            "MMI, 12.15-14.00 (3/2/17)",
            "KTN, 09.15-11.00 (3/2/17)",
            "KTN, 12.15-14.00 (2/2/17)"
    };

    // Create a List from String Array elements
    final List<String> missed_list = new ArrayList<String>(Arrays.asList(missed));

    // Create an ArrayAdapter from List
    final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
            (this, android.R.layout.simple_list_item_1, missed_list);

    // DataBind ListView with items from ArrayAdapter
    lv.setAdapter(arrayAdapter);
    arrayAdapter.notifyDataSetChanged();
    }*/

}
