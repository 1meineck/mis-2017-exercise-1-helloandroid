package mis1.httpconnection;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Code adapted from https://medium.com/@JasonCromer/android-asynctask-http-request-tutorial-6b429d833e28
 * Last viewed on 04/20/17
 */

public class HttpAsyncTask extends AsyncTask<String, Void, String> {

    // Setting the request Method
    public static final String REQUEST_METHOD = "GET";

    // Establishing standard timeout of 15s
    public static final int READ_TIMEOUT = 15000;
    public static final int CONNECTION_TIMEOUT = 15000;


    @Override
    protected String doInBackground(String... params) {
        String stringUrl = params[0];
        String result;
        String inputLine;

        try {
            // Object, holding the URL
            URL url = new URL(stringUrl);

            // Creating a connection to the URL
            HttpURLConnection connection = (HttpURLConnection)
                    url.openConnection();

            // Setting of Method and Timeouts
            connection.setRequestMethod(REQUEST_METHOD);
            connection.setReadTimeout(READ_TIMEOUT);
            connection.setConnectTimeout(CONNECTION_TIMEOUT);

            // Connecting
            connection.connect();

            //Creating a InputStreamReader, reading the request input
            InputStreamReader streamReader = new
                    InputStreamReader(connection.getInputStream());

            // Creating a new buffered reader,
            // that allows iterating through the response and appending it to the StringBuilder
            BufferedReader reader = new BufferedReader(streamReader);
            StringBuilder stringBuilder = new StringBuilder();

            while((inputLine = reader.readLine()) != null) {
                stringBuilder.append(inputLine);
            }

            reader.close();
            streamReader.close();

            //Setting the result equal to the stringBuilder
            result = stringBuilder.toString();

        }
        // Returning the message of the IOException as a result
        catch(IOException e){
            result = e.getMessage();
        }


        return result;

    }

    @Override
    protected void onPostExecute(String s) {

        super.onPostExecute(s);

    }


}
