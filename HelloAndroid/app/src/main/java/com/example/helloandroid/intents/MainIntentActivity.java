package com.example.helloandroid.intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloandroid.R;

public class MainIntentActivity extends AppCompatActivity {
    public static final String ACTION_MSA = "com.example.helloandroid.LAUNCH";
    Button bView1, bView2, bMSA1, bMSA2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_intent);
        bView1 = (Button) findViewById(R.id.bView1);
        bView2 = (Button) findViewById(R.id.bView2);
        bMSA1 = (Button) findViewById(R.id.bMSA1);
        bMSA2 = (Button) findViewById(R.id.bMSA2);


        bView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://www.google.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        bView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:00401213456");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        bMSA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://www.google.com");
                Intent intent = new Intent("com.example.helloandroid.LAUNCH", uri);
                startActivity(intent);
            }
        });

        bMSA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:00401213456");
                Intent intent = new Intent("com.example.helloandroid.LAUNCH", uri);
                startActivity(intent);
            }
        });
    }
}
