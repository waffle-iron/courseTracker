package gruppe087.coursetracker;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

/**
 * Created by henrikbossart on 27.02.2017.
 */

public class getCourses{

    public String request () {
        AsyncTask<Void, Void, Void> asyncTask = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                HttpClient httpClient = new DefaultHttpClient();
                HttpGet req = new HttpGet("http://138.197.33.171/php/test.php");
                try {
                    HttpResponse res = httpClient.execute(req);
                    System.out.println(res);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

        }.execute();
    return "Done";
    }
}
