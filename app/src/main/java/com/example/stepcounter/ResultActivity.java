package com.example.stepcounter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private TextView stepsText;
    private TextView timeText;
    private TextView caloriesText;
    private TextView totalCaloriesText;
    private TextView distanceText;

    private ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Link UI elements
        stepsText = findViewById(R.id.stepsText);
        timeText = findViewById(R.id.timeText);
        caloriesText = findViewById(R.id.caloriesText);
        totalCaloriesText = findViewById(R.id.totalCaloriesText);
        distanceText = findViewById(R.id.distanceText);

        backButton = findViewById(R.id.backButton);

        // Get steps safely from Intent
        int steps = getIntent().getIntExtra("steps", 0);

        // Calculations
        double calories = steps * 0.04;
        double distance = steps * 0.0008; // km
        int activeTime = steps / 100;     // minutes estimate

        // Display values
        stepsText.setText(String.valueOf(steps));
        timeText.setText(activeTime + " min");
        caloriesText.setText((int) calories + " kcal");

        totalCaloriesText.setText("Total burned: " + (int) calories + " kcal");
        distanceText.setText(String.format("Distance: %.2f km", distance));

        // Back button action
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        });
    }
}