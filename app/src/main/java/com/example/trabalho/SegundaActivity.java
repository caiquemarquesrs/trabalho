package com.example.trabalho;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SegundaActivity extends AppCompatActivity {

    private Button btnGeradorRandomerator;
    private Button btnTextoInvertorInverter;
    private Button btnRegistrorEventosRegistry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        btnGeradorRandomerator = findViewById(R.id.btnGeradorRandomerator);
        btnTextoInvertorInverter = findViewById(R.id.btnTextoInvertorInverter);
        btnRegistrorEventosRegistry = findViewById(R.id.btnRegistrorEventosRegistry);
        btnGeradorRandomerator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SegundaActivity.this, GeradorValoresActivity.class);
                startActivity(intent);
            }
        });
        btnTextoInvertorInverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SegundaActivity.this, InvertorTextoActivity.class);
                startActivity(intent);
            }
        });
        btnRegistrorEventosRegistry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SegundaActivity.this, RegistrorEventosActivity.class);
                startActivity(intent);
            }
        });
    }
}
