package com.example.trabalho;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InvertorResultadoActivity extends AppCompatActivity {

    private TextView tvInvertedText;
    private Button btnGoToEventRegistry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invertorresultado);
        tvInvertedText = findViewById(R.id.tvInvertedText);
        btnGoToEventRegistry = findViewById(R.id.btnGoToEventRegistry);
        String inputText = getIntent().getStringExtra("INPUT_TEXT");
        if (inputText != null && !inputText.isEmpty()) {
            String invertedText = invertText(inputText);
            tvInvertedText.setText(invertedText);
        }
        btnGoToEventRegistry.setOnClickListener(new View.OnClickListener() {
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
