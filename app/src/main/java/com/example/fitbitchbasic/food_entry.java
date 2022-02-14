package com.example.fitbitchbasic;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.RetryPolicy;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class food_entry extends AppCompatActivity implements View.OnClickListener{

    String calories, carbs, fats, water, protein;
    TextView cal_count, carbs_count, fats_count, water_count, protein_count;

    Button enter_data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.food_entry);

        // assigning the outputs of the user to the object
        cal_count = (TextView) findViewById(R.id.cal_count);
        carbs_count = (TextView) findViewById(R.id.carbs_count);
        fats_count = (TextView) findViewById(R.id.fats_count);
        water_count = (TextView) findViewById(R.id.water_count);
        protein_count = (TextView) findViewById(R.id.protein_count);

        enter_data = findViewById(R.id.food_entry_btn);
        enter_data.setOnClickListener (this);
    }

    @Override
    public void onClick(View v) {
        if (v==enter_data) {
            add_food_to_sheet();
        }
    }

    private void add_food_to_sheet() {
        final ProgressDialog loading = ProgressDialog.show(this,"Adding Food","Please wait");
        final String calories = cal_count.getText().toString().trim();
        final String carbs = carbs_count.getText().toString().trim();
        final String fats = fats_count.getText().toString().trim();
        final String protein = protein_count.getText().toString().trim();
        final String water = water_count.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://script.google.com/macros/s/AKfycbzCZ8F8PJKmO9avZBPY1KCp6qr8-34GTDj6u_KR8LzUI5kEPus7rvs4M4W1VFVI69wU/exec",
                response -> {
                    if(loading.isShowing())loading.dismiss();
                    Toast.makeText(this,response,Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                },
                error -> {
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                //here we pass params
                params.put("action","addFood");
                params.put("calories",calories);
                params.put("carbs",carbs);
                params.put("fats",fats);
                params.put("protein",protein);
                params.put("water",water);
                return params;
            }
        };

        int socketTimeOut = 5000;// u can change this .. here it is 50 seconds

        RetryPolicy retryPolicy = new DefaultRetryPolicy(socketTimeOut, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(retryPolicy);

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);
    }

    public void cal_add(View view) {
        // get current string
        calories = cal_count.getText().toString();
        // converts string to int
        int i = Integer.parseInt(calories);
        //increment
        i = i + 10;
        // convert int to string
        String a = new Integer(i).toString();
        // sets the score to the corresponding text view
        cal_count.setText(a);
    }

    public void cal_min(View view) {
        // get current string
        calories = cal_count.getText().toString();
        // converts string to int
        int i = Integer.parseInt(calories);
        //increment
        if (i <= 0) {
            i = 0;
        } else {
            i = i - 10;
        }
        // convert int to string
        String a = new Integer(i).toString();
        // sets the score to the corresponding text view
        cal_count.setText(a);
    }

    public void net_carbs_add(View view) {
        // get current string
        carbs = carbs_count.getText().toString();
        // converts string to int
        int i = Integer.parseInt(carbs);
        //increment
        i = i + 1;
        // convert int to string
        String a = new Integer(i).toString();
        // sets the score to the corresponding text view
        carbs_count.setText(a);
    }

    public void net_carbs_min(View view) {
        // get current string
        carbs = carbs_count.getText().toString();
        // converts string to int
        int i = Integer.parseInt(carbs);
        //increment
        if (i <= 0) {
            i = 0;
        } else {
            i = i - 1;
        }
        // convert int to string
        String a = new Integer(i).toString();
        // sets the score to the corresponding text view
        carbs_count.setText(a);
    }

    public void fats_add(View view) {
        // get current string
        fats = fats_count.getText().toString();
        // converts string to int
        int i = Integer.parseInt(fats);
        //increment
        i = i + 1;
        // convert int to string
        String a = new Integer(i).toString();
        // sets the score to the corresponding text view
        fats_count.setText(a);
    }

    public void fats_min(View view) {
        // get current string
        fats = fats_count.getText().toString();
        // converts string to int
        int i = Integer.parseInt(fats);
        //increment
        if (i <= 0) {
            i = 0;
        } else {
            i = i - 1;
        }
        // convert int to string
        String a = new Integer(i).toString();
        // sets the score to the corresponding text view
        fats_count.setText(a);
    }

    public void water_add(View view) {
        // get current string
        water = water_count.getText().toString();
        // converts string to int
        int i = Integer.parseInt(water);
        //increment
        i = i + 1;
        // convert int to string
        String a = new Integer(i).toString();
        // sets the score to the corresponding text view
        water_count.setText(a);
    }

    public void water_min(View view) {
        // get current string
        water = water_count.getText().toString();
        // converts string to int
        int i = Integer.parseInt(water);
        //increment
        if (i <= 0) {
            i = 0;
        } else {
            i = i - 1;
        }
        // convert int to string
        String a = new Integer(i).toString();
        // sets the score to the corresponding text view
        water_count.setText(a);
    }

    public void protein_add(View view) {
        // get current string
        protein = protein_count.getText().toString();
        // converts string to int
        int i = Integer.parseInt(protein);
        //increment
        i = i + 1;
        // convert int to string
        String a = new Integer(i).toString();
        // sets the score to the corresponding text view
        protein_count.setText(a);
    }

    public void protein_min(View view) {
        // get current string
        protein = protein_count.getText().toString();
        // converts string to int
        int i = Integer.parseInt(protein);
        //increment
        if (i <= 0) {
            i = 0;
        } else {
            i = i - 1;
        }
        // convert int to string
        String a = new Integer(i).toString();
        // sets the score to the corresponding text view
        protein_count.setText(a);
    }


}