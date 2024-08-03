package com.example.multimedia_kr;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;

public class Audio extends AppCompatActivity {

    ImageView imagen;
    Button play, pausa, detener;
    ListView lista;
    int n;
    String Musica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        imagen = findViewById(R.id.Imagen);
        play = findViewById(R.id.Play);
        pausa = findViewById(R.id.Pausar);
        lista = findViewById(R.id.Lista);
        detener = findViewById(R.id.Detener);

        String[] audio = {"I'm the Villainess, So I'm Taming the Final Boss-Melody", "Mushikaburi-hime  - Let me love you"};
        String[] Music = {("android.resource://" + getPackageName() + "/" + R.raw.melody), ("android.resource://" + getPackageName() + "/" + R.raw.letmeloveyou)};
        Integer[] imag = {R.drawable.villano, R.drawable.prince};
        final ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,audio);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Musica = Music[position];
                    imagen.setImageResource(imag[position]);
                    Toast.makeText(getApplicationContext(), audio[position], Toast.LENGTH_LONG).show();

                Uri myUri = Uri.parse(Musica);
                MediaPlayer mediaPlayer = new MediaPlayer();

                try {
                    mediaPlayer.setDataSource(getApplicationContext(), myUri);
                }catch (IOException e){
                    e.printStackTrace();
                }

                try {
                    mediaPlayer.prepare();
                }catch (IOException e){
                    e.printStackTrace();
                }
                Toast.makeText(getApplicationContext(), "Otra", Toast.LENGTH_LONG).show();
                if (n==1){
                    mediaPlayer.stop();
                    n=0;
                }
                if (n==0){
                    mediaPlayer.start();
                }


                play.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mediaPlayer.start();
                        n = 1;
                        Toast.makeText(getApplicationContext(), "Iniciar", Toast.LENGTH_LONG).show();
                    }
                });

                pausa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mediaPlayer.pause();
                        n = 1;
                        Toast.makeText(getApplicationContext(), "Pausar", Toast.LENGTH_LONG).show();
                    }
                });

                detener.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mediaPlayer.stop();
                        n = 1;
                        Toast.makeText(getApplicationContext(), "Detener", Toast.LENGTH_LONG).show();
                    }
                });



            }
        });



    }
}