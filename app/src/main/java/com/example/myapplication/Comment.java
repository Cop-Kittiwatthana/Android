package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class Comment extends AppCompatActivity {
    private DatabaseReference firebaseReference;
    private EditText textcm;
    private Button btnAdd;
    private List<User> users;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        initInstances();
        initFirebase();



    }
    private void initFirebase() {
        firebaseReference = FirebaseDatabase.getInstance().getReference();
    }

    private void initInstances() {
        textcm =  findViewById(R.id.textcm);
        btnAdd =  findViewById(R.id.btnadd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v==btnAdd){
                    addUser();
                    add();
                }
            }
        });
        users = new ArrayList<>();
    }


    private void addUser() {
        String name = textcm.getText().toString();
        //checking if the value is provided
        if (!TextUtils.isEmpty(name)) {
            //String id = firebaseReference.child("users").push().getKey();

            Calendar c = Calendar.getInstance();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedDate = df.format(c.getTime());

            User users = new User();
            users.setId(formattedDate);
            users.setCommend(name);

            firebaseReference.child("comment").child(formattedDate).setValue(users);

            Toast.makeText(this, "บันทึกเรีบยร้อยแล้ว", Toast.LENGTH_LONG).show();
            textcm.setText("");
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "กรุณากรองข้อมูลใหม่อีกครั่ง", Toast.LENGTH_LONG).show();
        }
    }
    private void add(){
        Intent intent = new Intent(this,Comshow.class);
        startActivity(intent);
        finish();
    }

    public void back(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void show(View view){
        Intent intent = new Intent(this,Comshow.class);
        startActivity(intent);
        finish();
    }
}
