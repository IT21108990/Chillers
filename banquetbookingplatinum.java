package com.example.hallbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class banquetbookingplatinum extends AppCompatActivity {
    private Button bqPlatiReserveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banquetbookingplatinum);

        bqPlatiReserveBtn=findViewById(R.id.bqPlatiReserveBtn);
        bqPlatiReserveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(banquetbookingplatinum.this, myReservations.class);
                startActivity(intent);
            }
        });
    }
}