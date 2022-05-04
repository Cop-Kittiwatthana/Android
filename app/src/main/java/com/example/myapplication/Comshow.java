package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;

public class Comshow extends AppCompatActivity {


    ListView listView;
    FirebaseDatabase database;
    DatabaseReference reference;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comshow);

        user = new User();
        listView = (ListView)findViewById(R.id.listView);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("comment");
        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this,R.layout.item,R.id.titem, list);
        //reference.addValueEventListener(new ValueEventListener() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds: dataSnapshot.getChildren())
                {

                    user = ds.getValue(User.class);
                    list.add(user.getId().toString() + "\n"+ user.getCommend().toString() + "\n");
                }
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public void back(View view){
        Intent intent = new Intent(this,Comment.class);
        startActivity(intent);
        finish();
    }

}