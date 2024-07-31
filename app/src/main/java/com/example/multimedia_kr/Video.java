package com.example.multimedia_kr;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;

public class Video extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Uri myUri = Uri.parse("android.resource://"+getPackageName()+ "/" + R.raw.video);
        VideoView view = (VideoView)findViewById(R.id.Video);
        view.setVideoURI(myUri);
        MediaController media = new MediaController(this);
        view.setMediaController(media);
        media.setAnchorView(view);
        view.requestFocus();



//        MediaPlayer mediaPlayer = new MediaPlayer();
//        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//
//        try{
//            mediaPlayer.setDataSource(getApplicationContext(), myUri);
//        }catch (IllegalArgumentException e1){
//            e1.printStackTrace();
//        }catch (SecurityException e1){
//            e1.printStackTrace();
//        }catch (IllegalStateException e1){
//            e1.printStackTrace();
//        }catch (IOException e1){
//            e1.printStackTrace();
//        }
//        mediaPlayer.setLooping(true);
//
//        mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() {
//            @Override
//            public boolean onInfo(MediaPlayer mp, int what, int extra) {
//                return false;
//            }
//        });
//
//        mediaPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
//            @Override
//            public void onBufferingUpdate(MediaPlayer mp, int percent) {
//            }
//        });


    }
}