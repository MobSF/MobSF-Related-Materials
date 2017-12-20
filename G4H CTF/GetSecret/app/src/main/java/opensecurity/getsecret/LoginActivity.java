package opensecurity.getsecret;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import dexguard.util.CertificateChecker;
import dexguard.util.TamperDetector;

public class LoginActivity extends ActionBarActivity {
    public EditText password;
    public Button unlock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        final Context context = LoginActivity.this;

        final int OK = 1;

        int apkChanged =TamperDetector.checkApk(context, OK);

        int certificateChanged =CertificateChecker.checkCertificate(context, OK);

        if (apkChanged != OK && certificateChanged!= OK)
        {
            android.os.Process.killProcess(android.os.Process.myPid());
        }
        password=(EditText) findViewById(R.id.editText);
        unlock = (Button) findViewById(R.id.button);

        unlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (password.getText().toString().equals("1337"))
                {
                Toast.makeText(getApplicationContext(), "Oh Boy! That escalated quickly.", Toast.LENGTH_SHORT).show();
                    Intent ask = new Intent(LoginActivity.this, AskSecret.class);
                    startActivity(ask);
                }
                else
                {
                Toast.makeText(getApplicationContext(), "Oh Boy! You missed it by an inch.", Toast.LENGTH_SHORT).show();

                }



            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
