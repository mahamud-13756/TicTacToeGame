package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private HashMap<Integer, Boolean> buttonClickStatus;
    private int cnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the HashMap for button click status
        buttonClickStatus = new HashMap<>();
        buttonClickStatus.put(R.id.b1, false);
        buttonClickStatus.put(R.id.b2, false);
        buttonClickStatus.put(R.id.b3, false);
        buttonClickStatus.put(R.id.b4, false);
        buttonClickStatus.put(R.id.b5, false);
        buttonClickStatus.put(R.id.b6, false);
        buttonClickStatus.put(R.id.b7, false);
        buttonClickStatus.put(R.id.b8, false);
        buttonClickStatus.put(R.id.b9, false);
    }

    // Method to handle button clicks
    public void onButtonClick(View view) {
        int buttonId = view.getId(); // Get clicked button ID

        // Check if the button is clicked for the first time
        if (!buttonClickStatus.get(buttonId)) {
            cnt++;
            ImageView clickedImage = findViewById(buttonId); // Change Button to ImageView
            buttonClickStatus.put(buttonId, true);

            // Set image based on counter
            if (cnt % 2 == 0) {
                clickedImage.setBackgroundResource(R.drawable.cro); // Use cross image
            } else {
                clickedImage.setBackgroundResource(R.drawable.ze); // Use zero image
            }
        } else {
            // Show "Invalid click" message for second click
            Toast.makeText(this, "Invalid click", Toast.LENGTH_SHORT).show();
        }
    }
}
