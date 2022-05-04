package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

    }
    public void history2(View view){
        Intent intent = new Intent(this,History2.class);
        startActivity(intent);
        finish();
    }
    public void back(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
