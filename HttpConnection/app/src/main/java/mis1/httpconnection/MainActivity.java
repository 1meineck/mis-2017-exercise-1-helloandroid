package mis1.httpconnection;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.concurrent.ExecutionException;

/**
 * Code adapted from https://medium.com/@JasonCromer/android-asynctask-http-request-tutorial-6b429d833e28
 * Last viewed on 04/20/17
 */

public class MainActivity extends AppCompatActivity {

    //
    Button button;
    EditText editText;
    TextView text;
    String result;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.connectButton);
        editText = (EditText) findViewById(R.id.textfieldTarget);
        text = (TextView) findViewById(R.id.textView01);
        text.setMovementMethod(new ScrollingMovementMethod());


        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                // Creation of a new HttpAsyncTask that handles the request
                HttpAsyncTask httpRequest = new HttpAsyncTask();

                // Setting the url by getting the input from the input-field
                String url = editText.getText().toString();
                try {
                    // Getting the http-response of the url from the AsyncTask
                    result = httpRequest.execute(url).get();

                    // Displaying of the http-response
                    text.setText(result);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                    text.setText("InterruptedException");
                } catch (ExecutionException e) {
                    e.printStackTrace();
                    text.setText("ExecutionExeption");

                }



            }
        });


    }



}

