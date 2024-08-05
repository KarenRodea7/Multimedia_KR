package com.example.multimedia_kr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button Audio, Video1, Video2, Video3, Camara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Audio = findViewById(R.id.Audio);
        Video1 = findViewById(R.id.Video1);
        Video2 = findViewById(R.id.Video2);
        Video3 = findViewById(R.id.Video3);
        Camara = findViewById(R.id.Camara);

        Audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Audio.class);
                startActivity(i);
            }
        });

        Video1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Video.class);
                startActivity(i);
            }
        });

        Video2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), VideoSurface.class);
                startActivity(i);
            }
        });

        Video3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Video.class);
                startActivity(i);
            }
        });

        Camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Camara.class);
                startActivity(i);
            }
        });

    }
}