package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();





        firebaseAuth.signInWithEmailAndPassword("123@123.com","123456")
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_LONG);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_LONG);
            }
        });
    }
    public void allactivity(View view){
        Intent intent = new Intent(this,AllImgActivity.class);
        startActivity(intent);

    }
    public void history(View view){
        Intent intent = new Intent(this,History.class);
        startActivity(intent);

    }
    public void comment(View view){
        Intent intent = new Intent(this,Comment.class);
        startActivity(intent);

    }
    public void call(View view){
        Intent intent = new Intent(this,Call.class);
        startActivity(intent);

    }
    public void program(View view){
        Intent intent = new Intent(this,Program.class);
        startActivity(intent);

    }
}
