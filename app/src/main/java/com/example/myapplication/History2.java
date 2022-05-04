package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class History2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history2);
    }
    public void history(View view){
        Intent intent = new Intent(this,History.class);
        startActivity(intent);
        finish();
    }
    public void back(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
