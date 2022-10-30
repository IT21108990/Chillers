package com.example.roombooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class selectroom extends AppCompatActivity {

    private Button selectLuxuryBtn;
    private Button selectOutdoorBtn;
    private Button selectEconomyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectroom);

        selectLuxuryBtn= findViewById(R.id.selectLuxuryBtn);
        selectLuxuryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(selectroom.this, roomstarter.class);
                startActivity(intent);
            }
        });

        selectOutdoorBtn= findViewById(R.id.selectOutdoorBtn);
        selectOutdoorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(selectroom.this, roomStarterOut.class);
                startActivity(intent);
            }
        });

        selectEconomyBtn= findViewById(R.id.selectEconomyBtn);
        selectEconomyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(selectroom.this, confroomEco.class);
                startActivity(intent);
            }
        });
    }
}