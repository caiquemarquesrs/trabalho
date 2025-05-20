package com.example.trabalho;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InvertorTextoActivity extends AppCompatActivity {

    private EditText etInputText;
    private Button btnInvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invertortexto);
        etInputText = findViewById(R.id.etInputText);
        btnInvert = findViewById(R.id.btnInvert);
        btnInvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = etInputText.getText().toString().trim();
                if (inputText.isEmpty()) {
                    Toast.makeText(InvertorTextoActivity.this, "Por favor, digite um texto!", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(InvertorTextoActivity.this, InvertorResultadoActivity.class);
                intent.putExtra("INPUT_TEXT", inputText);
                startActivity(intent);
            }
        });
    }
}
