package com.example.fitbitchbasic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_food_entry, btn_weight_entry, btn_view_entry, btn_exercise_entry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super .onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_food_entry = findViewById(R.id.food_entry);
        btn_weight_entry = findViewById(R.id.weight_entry);
        btn_view_entry = findViewById(R.id.view_personalized_data);
        //btn_exercise_entry = findViewById(R.id.exercise_entry_btn);

        btn_view_entry.setOnClickListener(this);
        btn_food_entry.setOnClickListener(this);
        btn_weight_entry.setOnClickListener(this);
        //btn_exercise_entry.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v==btn_view_entry) {
            Intent intent = new Intent (getApplicationContext(), view_entry.class);
            startActivity(intent);
        } else if (v==btn_food_entry) {
            Intent intent = new Intent (getApplicationContext(), food_entry.class);
            startActivity(intent);
        } else if (v==btn_weight_entry) {
            Intent intent = new Intent (getApplicationContext(), weight_entry.class);
            startActivity(intent);
        } else if (v==btn_exercise_entry) {
            Intent intent = new Intent (getApplicationContext(), exercise_entry.class);
            startActivity(intent);
        }

    }

}