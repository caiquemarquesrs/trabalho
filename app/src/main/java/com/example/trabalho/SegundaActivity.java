package com.example.trabalho;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SegundaActivity extends AppCompatActivity {

    private Button btnRandomGenerator;
    private Button btnWordInverter;
    private Button btnEventRegistry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        btnRandomGenerator = findViewById(R.id.btnRandomGenerator);
        btnWordInverter = findViewById(R.id.btnWordInverter);
        btnEventRegistry = findViewById(R.id.btnEventRegistry);
        btnRandomGenerator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SegundaActivity.this, GeradorValoresActivity.class);
                startActivity(intent);
            }
        });
        btnWordInverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SegundaActivity.this, InvertorTextoActivity.class);
                startActivity(intent);
            }
        });
        btnEventRegistry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SegundaActivity.this, RegistrorEventosActivity.class);
                startActivity(intent);
            }
        });
    }
}
