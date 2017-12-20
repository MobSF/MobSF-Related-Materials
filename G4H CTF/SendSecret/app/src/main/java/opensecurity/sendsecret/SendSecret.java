package opensecurity.sendsecret;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class SendSecret extends ActionBarActivity {
    public static final String VTOKEN="opensecurity.in1234567!@#$%^";
    public static final String TOPSECRET= "g4h-webcast-xb0z";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_secret);
        Intent intent = getIntent();
        String vt = intent.getStringExtra("VIEW_TOKEN");

        if (vt.equals(VTOKEN)) {

            Toast.makeText(getApplicationContext(), "Sending Secret Token....", Toast.LENGTH_SHORT).show();
            Intent i = new Intent();
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.setComponent(new ComponentName("opensecurity.getsecret", "opensecurity.getsecret.GetFlag"));
            i.putExtra("TOPSECRET", TOPSECRET);
            startActivity(i);

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_send_secret, menu);
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
