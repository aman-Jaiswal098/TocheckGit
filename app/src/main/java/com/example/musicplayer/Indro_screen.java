package com.example.musicplayer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class Indro_screen extends AppCompatActivity {
VideoView videoView;
TextView skip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indro_screen);
        videoView = findViewById(R.id.videoView);
        skip =findViewById(R.id.skip_button);
        MediaController mediaController = new MediaController(this);
        mediaController.setMediaPlayer(videoView);
        videoView.setMediaController(null);
        videoView.setVideoURI(Uri.parse("https://ak.picdn.net/shutterstock/videos/1054738973/preview/stock-footage--beautiful-model-in-indian-style.webm"));
        videoView.start();
        videoView.isPlaying();



        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iH=new Intent(Indro_screen.this, MainActivity.class);
                startActivity(iH);

                finish();

            }
        });



    }
}