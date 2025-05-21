package com.example.trabalho;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class GeradorValoresActivity extends AppCompatActivity {

    private EditText valorMin;
    private EditText valorMax;
    private Button btnGerador;
    private TextView resultado;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerador);
        valorMin = findViewById(R.id.valorMin);
        valorMax = findViewById(R.id.valorMax);
        btnGerador = findViewById(R.id.btnGerador);
        resultado = findViewById(R.id.resultado);
        random = new Random();
        btnGerador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateRandomNumber();
            }
        });
    }

    private void generateRandomNumber() {
        try {
            int min = Integer.parseInt(valorMin.getText().toString());
            int max = Integer.parseInt(valorMax.getText().toString());
            if (min >= max) {
                resultado.setText("O valor mínimo deve ser menor que o valor máximo!");
                return;
            }
            int randomNumber = random.nextInt((max - min) + 1) + min;
            resultado.setText(String.valueOf(randomNumber));
        } catch (NumberFormatException e) {
            resultado.setText("Por favor, insira valores numéricos válidos!");
        }
    }
}
