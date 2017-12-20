package opensecurity.getsecret;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


public class GetFlag extends ActionBarActivity {
    public Button getflag;
    public EditText secret;
    public TextView flg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_flag2);
        Intent intent = getIntent();
        final String tp = intent.getStringExtra("TOPSECRET");
        getflag = (Button) findViewById(R.id.button4);
        secret = (EditText) findViewById(R.id.editText2);
        flg =(TextView) findViewById(R.id.textView2);
        getflag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = secret.getText().toString();
                try {
                    String crypto = "q7jwHCFy7ADGQ+ol3V9k225uOOi21J6n8Q974DNoPi6uy+ushhg/L/MVVCdr8393RhbTYs/jP7eDvTEUJUucpg==";
                    String flag = decrypt(crypto,key);
                    flg.setText(flag);
                    Log.v("FLAG", flag);

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Wrong Secret" , Toast.LENGTH_SHORT).show();

                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_get_flag, menu);
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


    protected String decrypt(String encryptedText, String key) {
        byte[] clearText = null;
        try {
            byte[] keyData = key.getBytes();
            SecretKey ks = new SecretKeySpec(keyData, "AES");
            Cipher c = Cipher.getInstance("AES");
            c.init(Cipher.DECRYPT_MODE, ks);
            clearText = c.doFinal(Base64.decode(encryptedText, Base64.DEFAULT));
            return new String(clearText, "UTF-8");
        } catch (Exception e) {

            return null;
        }
    }
}