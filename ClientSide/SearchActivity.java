package com.example.mapeat;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;


public class SearchActivity extends AppCompatActivity {
    protected static String Searchresult = "com.example.mapeat.ACTIVITYCODE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    private void setData(String data){
        TextView result = (TextView) findViewById(R.id.RecieveText);
        result.setText(data);
        Intent intent = new Intent(this,ProductDisplay.class);
        intent.putExtra(Searchresult, result.getText());
        startActivity(intent);
        SearchActivity.this.finish();
    }
    public void search(View view) {
        Intent intent = getIntent();
        Intent displayinfo = new Intent(this, ProductDisplay.class);
        String activiyCode = intent.getStringExtra(MainActivity.CODE);
        EditText searchBar = (EditText) findViewById(R.id.searchBar);
        String signal = activiyCode + searchBar.getText().toString().toLowerCase();
        Communication communication = new Communication();
        try {
            String re = communication.execute(signal).get();
            setData(re);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}