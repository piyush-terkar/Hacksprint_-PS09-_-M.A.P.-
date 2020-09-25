package com.example.mapeat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    protected static String CODE = "com.example.mapeat.ACTIVITYCODE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences loggedin = getSharedPreferences(LoginActivity.LOGGED_IN, 0);
        boolean isLoggedin = loggedin.getBoolean("isLoggedin", false);
        if(!isLoggedin){
            Intent login1st = new Intent(this, LoginActivity.class);
            startActivity(login1st);
        }
    }


    public void categorySelection(int catagory){
        Intent intent = new Intent(this, SearchActivity.class);
        String activityCode;
        switch(catagory){
            case 1:
                activityCode = "se,1,";
                intent.putExtra(CODE, activityCode);
                break;
            case 2:
                activityCode = "se,2,";
                intent.putExtra(CODE, activityCode);
                break;
            case 3:
                activityCode = "se,3,";
                intent.putExtra(CODE, activityCode);
                break;
            case 4:
                activityCode = "se,4,";
                intent.putExtra(CODE, activityCode);
                break;
            case 5:
                activityCode = "se,5,";
                intent.putExtra(CODE, activityCode);
                break;
        }
        startActivity(intent);
    }


    public void fruits(View view){
        categorySelection(1);
    }
    public void vegetables(View view){
        categorySelection(2);
    }
    public void cereals(View view){
        categorySelection(3);
    }
    public void cleaning(View view){
        categorySelection(4);
    }
    public void diary(View view){
        categorySelection(5);
    }
}