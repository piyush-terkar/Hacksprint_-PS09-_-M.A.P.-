package com.example.mapeat;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class CheckOutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_out);
    }

    public String[] breakstring(String receive)
    {
        String[] info = receive.split(" " , 5);
        return info;
    }

    @SuppressLint("WrongConstant")
    public void checkout(View view) {
        Toast.makeText(this,"Your order has been placed Successfully!", 1000);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void giveReview(View view){
        EditText giveReview = (EditText)findViewById(R.id.GiveReview);
        Communication communication = new Communication();
        try {
            String re = communication.execute("gr," + giveReview.getText().toString()).get();
            TextView output = (TextView)findViewById(R.id.Title);
            if(re.equals("[1]")){
                output.setText("Thank You for such a positive Review");
            }
            else{
                output.setText("We will try to improve.");
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}