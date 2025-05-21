package com.example.trabalho;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InvertorTextoActivity extends AppCompatActivity {

    private EditText inputTexto;
    private Button btnInvertor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invertortexto);
        inputTexto = findViewById(R.id.inputTexto);
        btnInvertor = findViewById(R.id.btnInvertor);
        btnInvertor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = inputTexto.getText().toString().trim();
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
