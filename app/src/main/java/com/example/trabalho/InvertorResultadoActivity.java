package com.example.trabalho;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InvertorResultadoActivity extends AppCompatActivity {

    private TextView invertorTexto;
    private Button btnIrRegistroEvento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invertorresultado);
        invertorTexto = findViewById(R.id.invertorTexto);
        btnIrRegistroEvento = findViewById(R.id.btnIrRegistroEvento);
        String inputText = getIntent().getStringExtra("INPUT_TEXT");
        if (inputText != null && !inputText.isEmpty()) {
            String invertedText = invertText(inputText);
            invertorTexto.setText(invertedText);
        }
        btnIrRegistroEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InvertorResultadoActivity.this, RegistrorEventosActivity.class);
                startActivity(intent);
            }
        });
    }
    private String invertText(String text) {
        return new StringBuilder(text).reverse().toString();
    }
}
