package com.example.multimedia_kr;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;

public class VideoSurface extends AppCompatActivity {

    SurfaceView Surface;
    SurfaceHolder superficie;
    MediaPlayer mediaPlayer;
    MediaController media;

    Button menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_surface);

        menu = findViewById(R.id.Menu);

        Surface = findViewById(R.id.Surface);
        superficie = Surface.getHolder();
        superficie.setKeepScreenOn(true);

        media = new MediaController(this);
        media.setAnchorView(Surface);

        superficie.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                mediaPlayer = new MediaPlayer();
                mediaPlayer.setDisplay(superficie);

                Uri myUri = Uri.parse("android.resource://"+getPackageName()+ "/" + R.raw.video);

                try {
                    mediaPlayer.setDataSource(getApplicationContext(),myUri);
                    mediaPlayer.prepareAsync();
                    mediaPlayer.setOnPreparedListener(this::onPrepared);
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            public void onPrepared(MediaPlayer mp) {
                media.setMediaPlayer(new MediaController.MediaPlayerControl() {
                    @Override
                    public void start() {
                        mediaPlayer.start();
                    }

                    @Override
                    public void pause() {
                        mediaPlayer.pause();
                    }

                    @Override
                    public int getDuration() {
                        return mediaPlayer.getDuration();
                    }

                    @Override
                    public int getCurrentPosition() {
                        return mediaPlayer.getCurrentPosition();
                    }

                    @Override
                    public void seekTo(int pos) {
                        mediaPlayer.seekTo(pos);
                    }

                    @Override
                    public boolean isPlaying() {
                        return mediaPlayer.isPlaying();
                    }

                    @Override
                    public int getBufferPercentage() {
                        return 0;
                    }

                    @Override
                    public boolean canPause() {
                        return true;
                    }

                    @Override
                    public boolean canSeekBackward() {
                        return true;
                    }

                    @Override
                    public boolean canSeekForward() {
                        return true;
                    }

                    @Override
                    public int getAudioSessionId() {
                        return mediaPlayer.getAudioSessionId();
                    }
                });

                media.setAnchorView(Surface);
                media.setEnabled(true);
                media.show();
                mediaPlayer.start();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

    }
}