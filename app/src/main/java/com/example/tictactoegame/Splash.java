package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        VideoView videoView = findViewById(R.id.videoView);

        // Set video path (Add your video file to res/raw folder)
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.splashvideo);
        videoView.setVideoURI(videoUri);

        // Start video
        videoView.start();

        // Listener for when the video completes
        videoView.setOnCompletionListener(mp -> {
            // After the video ends, move to MainActivity
            startActivity(new Intent(Splash.this, MainActivity.class));
            finish();
        });
    }
}