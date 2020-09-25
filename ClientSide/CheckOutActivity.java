package com.example.mapeat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class CheckOutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_out);
        Intent intent = getIntent();
        String re = intent.getStringExtra(ProductDisplay.Searchresult);
        String[] brokenre = breakstring(re);
        TextView order = (TextView)findViewById(R.id.Order);
        order.setText(brokenre[0] + "Cost" + brokenre[2]);
    }

    public String[] breakstring(String receive)
    {
        String[] info = receive.split(" " , 5);
        return info;
    }

    public void checkout(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void giveReview(View view){
        EditText giveReview = (EditText)findViewById(R.id.GiveReview);
        Communication communication = new Communication();
        try {
            String re = communication.execute(giveReview.getText().toString()).get();
            TextView output = (TextView)findViewById(R.id.Title);
            if(re == "1"){
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