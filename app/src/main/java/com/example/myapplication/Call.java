package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Call extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
    }
    public void facebook(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.EMPTY.parse("https://www.facebook.com/TAT.Phitsanulok/"));
        startActivity(intent);
    }
    public void facebook1(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.EMPTY.parse("https://www.facebook.com/umpradamnam/"));
        startActivity(intent);
    }
    /*public void email(View view){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_EMAIL, "koulza9999@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "");
        intent.putExtra(Intent.EXTRA_TEXT, "");

        startActivity(Intent.createChooser(intent, "Send Email"));
    }
     */
    public void email(View view){
    Intent intent=new Intent(Intent.ACTION_SEND);
    String[] recipients={"tatphlok@tat.or.th "};
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT,"");
        intent.putExtra(Intent.EXTRA_TEXT,"");
        intent.setType("text/html");
        intent.setPackage("com.google.android.gm");
    startActivity(Intent.createChooser(intent, "Send mail"));
    }
    public void phone(View view){
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:055259907"));
        startActivity(callIntent);
    }
    public void back(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}

