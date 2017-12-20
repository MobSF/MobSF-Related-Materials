package opensecurity.getsecret;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Random;


public class AskSecret extends ActionBarActivity {
    public Button getsecret,hint;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_secret);
        getsecret = (Button) findViewById(R.id.button2);
        hint = (Button)findViewById(R.id.button3);
        getsecret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                int Low = 80;
                int High = 99;
                int get_token = r.nextInt(High - Low) + Low;
                    Intent i = new Intent();
                    i.setComponent(new ComponentName("opensecurity.sendsecret", "opensecurity.sendsecret.ValidateAccess"));
                    i.putExtra("token", get_token);
                     startActivity(i);


            }
        });
        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://opensecurity.in/labz/g4hctf_hints.txt"));
                startActivity(browserIntent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ask_secret, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
