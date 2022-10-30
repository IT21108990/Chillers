package com.pro1;

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

public class MainActivity extends AppCompatActivity {

    private EditText fName, fCnumber, fVenue, fDate, fTime, fGuestcount;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private String fID;
    private Button bookBtn;
    private rvModel rvmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fName = findViewById(R.id.Name);
        fCnumber = findViewById(R.id.Cnumber);
        fVenue = findViewById(R.id.Venue);
        fDate = findViewById(R.id.editTextDate);
        fTime = findViewById(R.id.editTextTime);
        fGuestcount = findViewById(R.id.editTextNumber);
        checkRoomBtn = findViewById(R.id.bookBtn);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("tables");

        // button
        bookBtn = findViewById(R.id.bookBtn);
        bookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Menus.class);
                startActivity(intent);

            }
        });
        bookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = fName.getText().toString();
                String number = fCnumber.getText().toString();
                String venue = fVenue.getText().toString();
                String date = fDate.getText().toString();
                String time = fTime.getText().toString();
                String guestcount = fGuestcount.getText().toString();

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        databaseReference.child(fID).setValue(rvmodel);
                        Toast.makeText(MainActivity.this, "Confirm", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, Menus.class));
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(MainActivity.this, "Error is this " + error.toString(), Toast.LENGTH_SHORT)
                                .show();
                    }
                });
            }
        });
    }

}
