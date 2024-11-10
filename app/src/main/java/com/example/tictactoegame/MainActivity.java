package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private HashMap<Integer, Integer> buttonClickStatus;
    private int cnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the HashMap for button click status
        buttonClickStatus = new HashMap<>();
        buttonClickStatus.put(R.id.b1, 0);
        buttonClickStatus.put(R.id.b2, 0);
        buttonClickStatus.put(R.id.b3, 0);
        buttonClickStatus.put(R.id.b4, 0);
        buttonClickStatus.put(R.id.b5, 0);
        buttonClickStatus.put(R.id.b6, 0);
        buttonClickStatus.put(R.id.b7, 0);
        buttonClickStatus.put(R.id.b8, 0);
        buttonClickStatus.put(R.id.b9, 0);
    }

    // Method to handle button clicks
    public void onButtonClick(View view) {
        int buttonId = view.getId();

        int click = buttonClickStatus.get(buttonId);
        // Check if the button is clicked for the first time
        if (click == 0) {
            cnt++;
            ImageView clickedImage = findViewById(buttonId);
            buttonClickStatus.put(buttonId, 101);

            // Set image based on counter
            if (cnt % 2 == 0) clickedImage.setBackgroundResource(R.drawable.cro);
            else clickedImage.setBackgroundResource(R.drawable.ze);

           


        } else {
            Toast.makeText(this, "Invalid click", Toast.LENGTH_SHORT).show();
        }
    }
}
