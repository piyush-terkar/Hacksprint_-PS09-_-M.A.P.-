package com.example.mapeat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ProductDisplay extends AppCompatActivity {
    protected static String Searchresult = "com.example.mapeat.ACTIVITYCODE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productdisplay);
        TextView name = (TextView)findViewById(R.id.productname);
        TextView stock = (TextView)findViewById(R.id.quantity);
        TextView cost = (TextView)findViewById(R.id.Cost);
        Intent intent = getIntent();
        String info = intent.getStringExtra(SearchActivity.Searchresult);
        String[] brokeninfo = breakstring(info);
        name.setText(brokeninfo[0].toUpperCase());
        stock.setText("Stock : " + brokeninfo[1]);
        cost.setText("Rs" + brokeninfo[2]);
    }
    public void viewcart(View view)
    {
        Intent intent = new Intent(this, CheckOutActivity.class);
        startActivity(intent);
    }
    public double mul(int quantity, double cost)
    {
      double total = quantity * cost;
      return total;
    }
    public String[] breakstring(String receive)
    {
        String[] info = receive.split(" " , 5);
        return info;
    }
    public void checkParams(View view){
        TextView stock = (TextView)findViewById(R.id.quantity);
        TextView cost = (TextView)findViewById(R.id.Cost);
        EditText quantity = (EditText)findViewById(R.id.editTextNumberDecimal);
        while(true){
            if(!quantity.getText().equals("")){
                int quan = Integer.valueOf(quantity.getText().toString());
                double price = Double.valueOf(cost.getText().toString());
                cost.append(String.valueOf(mul(quan, price)));
            }
        }
    }

    public void addtoCart(View view){
        Intent intent = new Intent(this, CheckOutActivity.class);
        Intent previntent = getIntent();
        String result = previntent.getStringExtra(SearchActivity.Searchresult);
        intent.putExtra(Searchresult, result);
    }
}