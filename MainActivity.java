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
public class bookroom extends AppCompatActivity {

    private EditText fDate, fPeople, fRates;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private String fID;
    private Button checkRoomBtn;
    private rvModel rvmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fDate = findViewById(R.id.Date);
        fPeople = findViewById(R.id.People);
        fRates = findViewById(R.id.Rates);
        checkRoomBtn = findViewById(R.id.checkRoomBtn);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("rooms");

        //button
        checkRoomBtn = findViewById(R.id.checkRoomBtn) ;
        checkRoomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Menus.class );
                startActivity(intent);

            }
        });
        checkRoomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date = fDate.getText().toString();
                String people = fPeople.getText().toString();
                String rates = fRates.getText().toString();
                
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        databaseReference.child(fID).setValue(rvmodel);
                        Toast.makeText(bookroom.this, "Done", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(bookroom.this, Menus.class));
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(bookroom.this, "Error is this " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

}