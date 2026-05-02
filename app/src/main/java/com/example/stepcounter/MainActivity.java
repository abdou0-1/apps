package com.example.stepcounter;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    
    private EditText stepsInput;
    private Button startButton, inputButton, calorieButton;

    private int steps = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stepsInput = findViewById(R.id.stepsInput);
        startButton = findViewById(R.id.startButton);
        inputButton = findViewById(R.id.inputButton);
        calorieButton = findViewById(R.id.calorieButton);

        // START button
        startButton.setOnClickListener(v ->
                Toast.makeText(this, "Tracking started", Toast.LENGTH_SHORT).show()
        );

        // INPUT steps (keyboard will show automatically due to focus)
        inputButton.setOnClickListener(v -> {
            stepsInput.requestFocus();

            String value = stepsInput.getText().toString().trim();

            if (!value.isEmpty()) {
                steps = Integer.parseInt(value);
                Toast.makeText(this, "Steps saved: " + steps, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Enter steps first", Toast.LENGTH_SHORT).show();
            }
        });

        // GO TO RESULT SCREEN
        calorieButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("steps", steps);
            startActivity(intent);
        });
    }
}