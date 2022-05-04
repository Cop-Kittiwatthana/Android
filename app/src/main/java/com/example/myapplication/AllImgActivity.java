package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class AllImgActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private  StorageReference storageReference;
    private SwipeRefreshLayout swipeRefreshLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_img);
        recyclerView = findViewById(R.id.recyclerview);
        FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
        storageReference = firebaseStorage.getReferenceFromUrl("gs://appdatabase-2c46c.appspot.com");
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        swipeRefreshLayout = findViewById(R.id.refresh);

        swipeRefreshLayout.setColorSchemeColors(
                getResources().getColor(android.R.color.holo_blue_bright),
                getResources().getColor(android.R.color.holo_green_light),
                getResources().getColor(android.R.color.holo_orange_light),
                getResources().getColor(android.R.color.holo_red_light)
        );
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                uPdateData();
            }
        });

    }
    private void uPdateData(){
        storageReference.child("img").listAll()
                .addOnSuccessListener(new OnSuccessListener<ListResult>() {
                    @Override
                    public void onSuccess(ListResult listResult) {
                        final List<String> imglist = new ArrayList<>();
                        for (StorageReference item : listResult.getItems()) {
                            Log.e("Filename", "onSuccess: " + item);
                            Log.e("Filename", "onSuccess: " + item.getName());
                            imglist.add(item.getName());
                            Log.e("Filename", "onSuccess: " + imglist.size());
                        }
                        ImgAdapter imgAdapter = new ImgAdapter(AllImgActivity.this,imglist);
                        recyclerView.setAdapter(imgAdapter);
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.e("Filename", "Error: " + e);

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        uPdateData();
    }
    public void back(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
