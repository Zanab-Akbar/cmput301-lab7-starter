package com.example.androiduitesting;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        TextView cityText = findViewById(R.id.city_text);
        Button backButton = findViewById(R.id.back_button);

        // Get city name from intent and display
        String cityName = getIntent().getStringExtra("city_name");
        cityText.setText(cityName);

        // Back button returns to MainActivity
        backButton.setOnClickListener(v -> finish());
    }
}
