package com.example.zadanieegzpawel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView textViewPunkty;
    private Button polub;
    private Button usun;
    private int liczbaPunktow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(savedInstanceState!=null){
    liczbaPunktow = savedInstanceState.getInt("POLUBIENIA");
        }
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textViewPunkty = findViewById(R.id.textView1);
        polub  = findViewById(R.id.polub);
        usun  = findViewById(R.id.usun);
        polub.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        liczbaPunktow++;
                        textViewPunkty.setText(Integer.toString(liczbaPunktow)+" polubień");
                    }
                }
        );
        usun.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (liczbaPunktow > 0){
                            liczbaPunktow--;
                        }
                        textViewPunkty.setText(Integer.toString(liczbaPunktow)+" polubień");
                    }
                }
        );
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("POLUBIENIA", liczbaPunktow);
    }
}