package com.example.hallbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class selectbanquethall extends AppCompatActivity {

    private Button selectBqStarterBtn;
    private Button selectBqBronzeBtn;
    private Button selectBqPlatinumBtn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectbanquethall);


        selectBqStarterBtn= findViewById(R.id.selectBqStarterBtn);
        selectBqStarterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(selectbanquethall.this, banquetbookingstarter.class);
                startActivity(intent);
            }
        });
        selectBqBronzeBtn= findViewById(R.id.selectBqBronzeBtn);
        selectBqBronzeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(selectbanquethall.this, banquetbookingbronze.class);
                startActivity(intent);
            }
        });

        selectBqPlatinumBtn= findViewById(R.id.selectBqPlatinumBtn);
        selectBqPlatinumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(selectbanquethall.this, banquetbookingplatinum.class);
                startActivity(intent);
            }
        });


    }
}