package com.example.hallbooking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.google.android.material.textfield.TextInputEditText;

public class banquetbookingbronze extends AppCompatActivity {

    private EditText userName, userNumber, Date, Time, Guests;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private Button bqReserveBtn,Beverages,AudVid;
    private String BqBooking;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banquetbookingbronze);

        userName = findViewById(R.id.name);
        userNumber = findViewById(R.id.number);
        Date = findViewById(R.id.editTextDate);
        Time = findViewById(R.id.editTextTime);
        Guests = findViewById(R.id.editTextNumber);
        Beverages = findViewById(R.id.switch1);
        AudVid = findViewById(R.id.switch2);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Hallbooking");



        bqReserveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String bqName = userName.getText().toString();
                String bqNumber = userNumber.getText().toString();
                String bqDate = Date.getText().toString();
                String bqTime = Time.getText().toString();
                String bqGuest = Guests.getText().toString();
                String bqBev = Beverages.getText().toString();
                String bqAud = AudVid.getText().toString();
                BqBooking = bqName;

                BookingRVMModal bqBookingRVmodal = new BookingRVMModal(bqName, bqNumber,bqDate,bqTime,bqGuest,bqBev,bqAud);

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        databaseReference.child(BqBooking).setValue(BqBooking);
                        Toast.makeText(banquetbookingbronze.this, "Data added", Toast.LENGTH_SHORT).show();
                        startActivity(
                                new Intent(banquetbookingbronze.this, confirmBooking.class)
                        );
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {


                    }
                });


            }
        });


    }

}