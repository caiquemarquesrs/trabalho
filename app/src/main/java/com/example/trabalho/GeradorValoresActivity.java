package com.example.trabalho;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class GeradorValoresActivity extends AppCompatActivity {

    private EditText etMinValue;
    private EditText etMaxValue;
    private Button btnGenerate;
    private TextView tvResult;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerador);
        etMinValue = findViewById(R.id.etMinValue);
        etMaxValue = findViewById(R.id.etMaxValue);
        btnGenerate = findViewById(R.id.btnGenerate);
        tvResult = findViewById(R.id.tvResult);
        random = new Random();
        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateRandomNumber();
            }
        });
    }

    private void generateRandomNumber() {
        try {
            int min = Integer.parseInt(etMinValue.getText().toString());
            int max = Integer.parseInt(etMaxValue.getText().toString());
            if (min >= max) {
                tvResult.setText("O valor mínimo deve ser menor que o valor máximo!");
                return;
            }
            int randomNumber = random.nextInt((max - min) + 1) + min;
            tvResult.setText(String.valueOf(randomNumber));
        } catch (NumberFormatException e) {
            tvResult.setText("Por favor, insira valores numéricos válidos!");
        }
    }
}
