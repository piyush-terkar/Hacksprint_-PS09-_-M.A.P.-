package com.example.mapeat;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class LoginActivity extends AppCompatActivity {
    public static final String LOGGED_IN = "pref_file";
    protected static String CODE = "com.example.mapeat.ACTIVITYCODE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void sign(View view)
    {
        Intent intent = new Intent(this, SignUpActivity.class);
        String activitycode = "si,";
        intent.putExtra(CODE,activitycode);
        startActivity(intent);
    }
    public void login(View view)
    {
        TextView sendinginterface = (TextView)findViewById(R.id.sendinginterface);
        EditText username = (EditText)findViewById(R.id.editTextTextPersonName3);
        EditText password = (EditText)findViewById(R.id.editTextTextPassword);
        String signal = "l,"+username.getText().toString().toLowerCase()+","+password.getText();
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
    @SuppressLint("WrongConstant")
    public void check(String check)
    {
        Intent intent = new Intent(this,MainActivity.class);
        switch(check)
        {
            case "None":
                SharedPreferences loggedin = getSharedPreferences(LoginActivity.LOGGED_IN , 0);
                SharedPreferences.Editor obj = loggedin.edit();
                obj.putBoolean("isloggedin", true);
                obj.commit();
                startActivity(intent);
                Toast.makeText(this,"Signed up and logged in Successfully!", 1000);
                LoginActivity.this.finish();
                break;

            case "1":
                TextView password = (TextView)findViewById(R.id.password);
                password.setText("Credentials entered are incorrect\nPlease enter valid credentials ");
                break;

            default:
                TextView password1 = (TextView)findViewById(R.id.password);
                password1.setText("Account does not exist.\nPlease Signup ");
                break;

        }
    }
}
