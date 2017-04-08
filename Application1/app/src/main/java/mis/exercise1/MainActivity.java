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

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;
    HttpURLConnection con;
    URL url;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.connect_button);
        editText = (EditText) findViewById(R.id.textfield_target);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    url = new URL(editText.getText().toString());

                    HttpURLConnection con = (HttpURLConnection) url.openConnection();


                } catch (MalformedURLException ex) {
                    Log.e("http-Test", Log.getStackTraceString(ex));
                }



            }
        });
    }
}
