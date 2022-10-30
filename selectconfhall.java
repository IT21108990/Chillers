package com.example.hallbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class selectconfhall extends AppCompatActivity {

    private Button selectConfStarterBtn;
    private Button selectConfBronzeBtn;
    private Button selectConfPlatinumBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectconfhall);

        selectConfStarterBtn= findViewById(R.id.selectConfStarterBtn);
        selectConfStarterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(selectconfhall.this, confbookingstarter.class);
                startActivity(intent);
            }
        });

        selectConfBronzeBtn= findViewById(R.id.selectConfBronzeBtn);
        selectConfBronzeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(selectconfhall.this, confbookingbronze.class);
                startActivity(intent);
            }
        });

        selectConfPlatinumBtn= findViewById(R.id.selectConfPlatinumBtn);
        selectConfPlatinumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(selectconfhall.this, confbookingplatinum.class);
                startActivity(intent);
            }
        });
    }
}