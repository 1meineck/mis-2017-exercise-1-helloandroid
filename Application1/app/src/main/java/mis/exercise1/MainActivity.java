package mis.exercise1;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

// Code adapted from https://developer.android.com/training/basics/network-ops/connecting.html#HeadlessFragment

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;

    // Boolean that is true if a download is in progress
    private boolean mDownloading = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.connect_button);
        editText = (EditText) findViewById(R.id.textfield_target);

        String url = editText.getText().toString();
        String result;

        HttpAsyncTask getRequest = new HttpAsyncTask();

        result = getRequest.execute(url).get();

    }



}

