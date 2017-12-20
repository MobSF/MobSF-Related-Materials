package opensecurity.sendsecret;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Random;

import dexguard.util.CertificateChecker;
import dexguard.util.TamperDetector;


public class ValidateAccess extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validate_access);
        final Context context = ValidateAccess.this;


        final int OK = 1;

        int apkChanged = TamperDetector.checkApk(context, OK);

        int certificateChanged = CertificateChecker.checkCertificate(context, OK);

        if (apkChanged != OK && certificateChanged!= OK)
        {
            android.os.Process.killProcess(android.os.Process.myPid());
        }
        final String VIEW_TOKEN="opensecurity.in1234567!@#$%^";
        Random r = new Random();
        int Low = 80;
        int High = 99;
        int sent_token = r.nextInt(High-Low) + Low;
        Intent intent = getIntent();
        int token = intent.getIntExtra("token",0);
        Toast.makeText(getApplicationContext(), "Received Token: "+ token, Toast.LENGTH_SHORT).show();
        if (token==sent_token)
        {
           Intent ask = new Intent(ValidateAccess.this, SendSecret.class);
            ask.putExtra("VIEW_TOKEN",VIEW_TOKEN);
            startActivity(ask);


        }


}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_validate_access, menu);
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
