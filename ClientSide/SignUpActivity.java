package com.example.mapeat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class SignUpActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
    public void signin(View view)
    {
        TextView sendinginterface = (TextView)findViewById(R.id.sendinginterface);
        EditText username = (EditText)findViewById(R.id.editTextTextPersonName);
        EditText password = (EditText)findViewById(R.id.editTextTextPassword2);
        EditText conpassword = (EditText)findViewById(R.id.editTextTextPassword3);
        EditText address = (EditText)findViewById(R.id.editTextTextPersonName2);
        if(password.getText().toString().equals(conpassword.getText().toString()))
        {
            String signal = "si,"+username.getText().toString().toLowerCase()+","+password.getText()+","+address.getText();
            sendinginterface.setText(signal);
            Communication communication = new Communication();
            try {
                String re = communication.execute(sendinginterface.getText().toString()).get();
                sendinginterface.setText(re);
                check(sendinginterface.getText().toString());
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void check(String chk){
        TextView sendinginterface = (TextView)findViewById(R.id.sendinginterface);
        if(sendinginterface.getText().equals("0")) {
            SharedPreferences loggedin = getSharedPreferences(LoginActivity.LOGGED_IN, 0);
            SharedPreferences.Editor obj = loggedin.edit();
            obj.putBoolean("isloggedin", true);
            obj.commit();
        }
    }
}