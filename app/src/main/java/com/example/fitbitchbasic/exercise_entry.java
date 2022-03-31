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

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.RetryPolicy;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class exercise_entry extends AppCompatActivity implements View.OnClickListener {

    Button btn_exercise_entry;
    EditText exercise_type, set_duration;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super .onCreate(savedInstanceState);
        setContentView(R.layout.exercise_entry);

        btn_exercise_entry = findViewById(R.id.exercise_entry_btn);
        btn_exercise_entry.setOnClickListener(this);

        exercise_type = findViewById(R.id.exercise_type_editText);
        set_duration = findViewById(R.id.set_duration_editText);
    }

    @Override
    public void onClick(View view) {
        add_exercise_to_sheet();
    }

    public void add_exercise_to_sheet() {
        final ProgressDialog loading = ProgressDialog.show(this,"Adding Exercise Data","Please wait");
        StringRequest stringRequest = new StringRequest(Request.Method.POST,  getString(R.string.scripts_link),
                response -> {
                    if(loading.isShowing())loading.dismiss();
                    Toast.makeText(this,response,Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), exercise_entry.class);
                    startActivity(intent);
                },
                error -> {
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                //here we pass params
                params.put("action","addExercise");
                params.put("exercise_type", exercise_type.getText().toString().trim());
                params.put("set_duration", set_duration.getText().toString().trim());
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
