package com.example.trabalho;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class RegistrorEventosActivity extends AppCompatActivity {

    private EditText eventoTexto;
    private DatePicker datePicker;
    private Button btnRegistrorEventos;
    private ListView eventos;
    private TextView dataSelecionada;

    private ArrayList<String> listaEventos;
    private ArrayAdapter<String> adpaterEventos;
    private int eventCounter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registroreventos);
        eventoTexto = findViewById(R.id.eventoTexto);
        datePicker = findViewById(R.id.datePicker);
        btnRegistrorEventos = findViewById(R.id.btnRegistrorEventos);
        eventos = findViewById(R.id.eventos);
        dataSelecionada = findViewById(R.id.dataSelecionada);
        listaEventos = new ArrayList<>();
        adpaterEventos = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaEventos);
        eventos.setAdapter(adpaterEventos);
        updateDateDisplay();
        datePicker.init(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(),
                new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        updateDateDisplay();
                    }
                });
        btnRegistrorEventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerEvent();
            }
        });
    }

    private void updateDateDisplay() {
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth() + 1; // Month is 0-based
        int year = datePicker.getYear();
        String formattedDate = String.format(Locale.getDefault(), "%02d/%02d/%04d", day, month, year);
        dataSelecionada.setText(formattedDate);
    }

    private void registerEvent() {
        String eventText = eventoTexto.getText().toString().trim();

        if (eventText.isEmpty()) {
            Toast.makeText(this, "Por favor, digite um evento!", Toast.LENGTH_SHORT).show();
            return;
        }
        String formattedDate = dataSelecionada.getText().toString();
        String eventEntry = eventCounter + ". " + formattedDate + " - " + eventText;
        listaEventos.add(eventEntry);
        adpaterEventos.notifyDataSetChanged();
        eventCounter++;
        eventoTexto.setText("");

        Toast.makeText(this, "Evento registrado com sucesso!", Toast.LENGTH_SHORT).show();
    }
}
