package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menus extends AppCompatActivity {

    private Button Dessert;
    private Button rice;
    private Button beverages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);

        Dessert = findViewById(R.id.Dessert) ;
        Dessert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Menus.this, Desserts.class );
                startActivity(intent);


            }
        });

        rice = findViewById(R.id.rice) ;
        rice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Menus.this, riceAndCurries.class );
                startActivity(intent);


            }
        });

        beverages = findViewById(R.id.beverages) ;
        beverages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Menus.this, Beverages.class );
                startActivity(intent);


            }
        });
    }
}