package com.example.project1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class foodOrderHistory extends AppCompatActivity {

    private EditText fName, fNumber, fDate, fTime, fGuestCount, fRoom;
    private Button updateDetails,deleteDetails;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private String fID;
    private rvModel rvmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_order_history);
        firebaseDatabase = FirebaseDatabase.getInstance();
        fName = findViewById(R.id.name);
        fNumber = findViewById(R.id.number);
        fDate = findViewById(R.id.editTextDate);
        fTime = findViewById(R.id.editTextTime);
        fGuestCount = findViewById(R.id.editTextNumber);
        fRoom = findViewById(R.id.editRoomNumber);
        updateDetails = findViewById(R.id.button10);
        deleteDetails = findViewById(R.id.button11);
        rvmodel = getIntent().getParcelableExtra("details");
        if (rvmodel != null){
            fName.setText(rvmodel.getrName());
            fNumber.setText(rvmodel.getrNumber());
            fDate.setText(rvmodel.getrDate());
            fTime.setText(rvmodel.getrTime());
            fGuestCount.setText(rvmodel.getRGuestCount());
            fRoom.setText(rvmodel.getRRoom());
        }
        databaseReference = firebaseDatabase.getReference("details").child(fID);
        updateDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = fName.getText().toString();
                String Number = fNumber.getText().toString();
                String Date = fDate.getText().toString();
                String Time = fTime.getText().toString();
                String GuestCount = fGuestCount.getText().toString();
                String Room = fRoom.getText().toString();

                Map<String, Object> map = new HashMap<>();
                map.put("Name",fName);
                map.put("Number",fNumber);
                map.put("date",fDate);
                map.put("Time",fTime);
                map.put("GuestCount",fGuestCount);
                map.put("Room",fRoom);

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        databaseReference.updateChildren(map);
                        Toast.makeText(foodOrderHistory.this, "Details Updated", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(foodOrderHistory.this, Home.class));
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(foodOrderHistory.this, "Fail to update details..", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        deleteDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteDetails();
            }
        });
    }

    private void deleteDetails() {
        databaseReference.removeValue();
        Toast.makeText(this, "Details Deleted..", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(foodOrderHistory.this, Home.class));
    }
}