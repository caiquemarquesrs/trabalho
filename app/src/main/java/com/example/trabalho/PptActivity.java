package com.example.trabalho;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class PptActivity extends AppCompatActivity {

    private ImageButton ibtnRock;
    private ImageButton ibtnPaper;
    private ImageButton ibtnScissors;
    private ImageView ivComputerChoice;
    private TextView tvResult;

    private final int ROCK = 0;
    private final int PAPER = 1;
    private final int SCISSORS = 2;

    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ppt);
        ibtnRock = findViewById(R.id.ibtnRock);
        ibtnPaper = findViewById(R.id.ibtnPaper);
        ibtnScissors = findViewById(R.id.ibtnScissors);
        ivComputerChoice = findViewById(R.id.ivComputerChoice);
        tvResult = findViewById(R.id.tvResult);
        random = new Random();
        ibtnRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame(ROCK);
            }
        });

        ibtnPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame(PAPER);
            }
        });

        ibtnScissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame(SCISSORS);
            }
        });
    }

    private void playGame(int userChoice) {
        int computerChoice = random.nextInt(3);
        switch (computerChoice) {
            case ROCK:
                ivComputerChoice.setImageResource(R.drawable.rock);
                break;
            case PAPER:
                ivComputerChoice.setImageResource(R.drawable.paper);
                break;
            case SCISSORS:
                ivComputerChoice.setImageResource(R.drawable.scissors);
                break;
        }
        if (userChoice == computerChoice) {
            tvResult.setText("Empate!");
        } else if ((userChoice == ROCK && computerChoice == SCISSORS) ||
                (userChoice == PAPER && computerChoice == ROCK) ||
                (userChoice == SCISSORS && computerChoice == PAPER)) {
            tvResult.setText("Você venceu!");
        } else {
            tvResult.setText("Você perdeu!");
        }
    }
}
