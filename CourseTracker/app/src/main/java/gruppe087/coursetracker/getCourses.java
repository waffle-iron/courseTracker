package gruppe087.coursetracker;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class getCourses extends AsyncTask{


    private String[] output;

    @Override
    protected Object doInBackground(Object[] params) {

            try {
                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet("http://138.197.33.171/php/test.php");
                System.out.println("CONNECTING...");
                HttpResponse response = client.execute(request);
                System.out.println("CONNECTED!!!");

                // Get the response
                BufferedReader rd = new BufferedReader
                        (new InputStreamReader(
                                response.getEntity().getContent()));
                String line = "";
                while ((line = rd.readLine()) != null) {
                    System.out.println("connected!");
                    System.out.println(line);
                    output[1]=line;
                }
            } catch (Exception e) {
                System.out.println("ERROR!!");
                System.out.println(e.getMessage());
            }


        return null;

    }

    public String[] getOutput(){
        return output;
    }
}