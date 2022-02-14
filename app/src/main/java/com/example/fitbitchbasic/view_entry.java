package com.example.fitbitchbasic;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.RetryPolicy;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class view_entry extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_entry);

        /*
        final ProgressDialog loading = ProgressDialog.show(this,"Retrieving Data","Please wait");

        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://script.google.com/macros/s/AKfycbzCZ8F8PJKmO9avZBPY1KCp6qr8-34GTDj6u_KR8LzUI5kEPus7rvs4M4W1VFVI69wU/exec",
                response -> {
                    if(loading.isShowing())loading.dismiss();
                    Toast.makeText(this,response,Toast.LENGTH_LONG).show();
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
         */
    }
}
