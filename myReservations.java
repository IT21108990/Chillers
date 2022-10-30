package com.example.hallbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class myReservations extends AppCompatActivity {

    private Button myresvUpdateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_reservations);

        myresvUpdateBtn=findViewById(R.id.myresvUpdateBtn);
        myresvUpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(myReservations.this,banquetbookingedit.class);
                startActivity(intent);
            }
        });
    }
}