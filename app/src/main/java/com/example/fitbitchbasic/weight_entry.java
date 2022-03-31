package com.example.fitbitchbasic;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.RetryPolicy;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class weight_entry extends AppCompatActivity implements View.OnClickListener{

    Button btn_weight_entry;
    EditText weight_entry;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super .onCreate(savedInstanceState);
        setContentView(R.layout.weight_entry);

        weight_entry = findViewById(R.id.weightNumberDecimal);

        btn_weight_entry = findViewById(R.id.weight_entry_btn);
        btn_weight_entry.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v==btn_weight_entry) {
            add_weight_to_sheet();
        }
    }

    private void add_weight_to_sheet() {
        final ProgressDialog loading = ProgressDialog.show(this,"Adding Weight Data","Please wait");
        final String weight = weight_entry.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, getString(R.string.scripts_link),
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
                params.put("action","addWeight");
                params.put("weight",weight);
                return params;
            }
        };

        int socketTimeOut = 5000;// u can change this .. here it is 50 seconds

        RetryPolicy retryPolicy = new DefaultRetryPolicy(socketTimeOut, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(retryPolicy);

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);
    }
}
