package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
     ImageView b1, b2, b3, b4, b5, b6, b7, b8, b9;
    private HashMap<Integer, Integer> buttonClickStatus;
    private int cnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button Connect with XML
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);


        // Initialize the HashMap for button click status; jeno ekta button 2 bar click na korte pare
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


            // Set image based on counter
            if (cnt % 2 == 0) {
                clickedImage.setBackgroundResource(R.drawable.cro);
                buttonClickStatus.put(buttonId, 100);
            }
            else {
                clickedImage.setBackgroundResource(R.drawable.ze);
                buttonClickStatus.put(buttonId, 101);
            }

           if(cnt>=5){
               int bb1 = buttonClickStatus.get(R.id.b1);
               int bb2 = buttonClickStatus.get(R.id.b2);
               int bb3 = buttonClickStatus.get(R.id.b3);
               int bb4 = buttonClickStatus.get(R.id.b4);
               int bb5 = buttonClickStatus.get(R.id.b5);
               int bb6 = buttonClickStatus.get(R.id.b6);
               int bb7 = buttonClickStatus.get(R.id.b7);
               int bb8 = buttonClickStatus.get(R.id.b8);
               int bb9 = buttonClickStatus.get(R.id.b9);

               //Condition Check

               // Row-wise
               if (bb1 == bb2 && bb2 == bb3 && bb1 != 0) {
                   showWinnerToast(bb1);
               } else if (bb4 == bb5 && bb5 == bb6 && bb4 != 0) {
                   showWinnerToast(bb4);
               } else if (bb7 == bb8 && bb8 == bb9 && bb7 != 0) {
                   showWinnerToast(bb7);
               }

               // Column-wise
               else if (bb1 == bb4 && bb4 == bb7 && bb1 != 0) {
                   showWinnerToast(bb1);
               } else if (bb2 == bb5 && bb5 == bb8 && bb2 != 0) {
                   showWinnerToast(bb2);
               } else if (bb3 == bb6 && bb6 == bb9 && bb3 != 0) {
                   showWinnerToast(bb3);
               }

               // Diagonals
               else if (bb1 == bb5 && bb5 == bb9 && bb1 != 0) {
                   showWinnerToast(bb1);
               } else if (bb3 == bb5 && bb5 == bb7 && bb3 != 0) {
                   showWinnerToast(bb3);
               }

               //
               else if(cnt==9){
                   showWinnerToast(1);
               }


           }


        } else {
            Toast.makeText(this, "Invalid click", Toast.LENGTH_SHORT).show();
        }
    }



    private void showWinnerToast(int winner) {
        if (winner == 100) {
            Toast.makeText(this, "CROSS wins!", Toast.LENGTH_SHORT).show();
            resetGame();
        } else if (winner == 101) {
            Toast.makeText(this, "ZERO wins!", Toast.LENGTH_SHORT).show();
            resetGame();
        }
        else {
            Toast.makeText(this, "DRAW", Toast.LENGTH_SHORT).show();
            resetGame();
        }
    }




    // Method to reset the game
    private void resetGame() {
        // Reset images to default background
        b1.setBackgroundResource(R.drawable.box);
        b2.setBackgroundResource(R.drawable.box);
        b3.setBackgroundResource(R.drawable.box);
        b4.setBackgroundResource(R.drawable.box);
        b5.setBackgroundResource(R.drawable.box);
        b6.setBackgroundResource(R.drawable.box);
        b7.setBackgroundResource(R.drawable.box);
        b8.setBackgroundResource(R.drawable.box);
        b9.setBackgroundResource(R.drawable.box);

        // Reset the HashMap values to 0
        buttonClickStatus.put(R.id.b1, 0);
        buttonClickStatus.put(R.id.b2, 0);
        buttonClickStatus.put(R.id.b3, 0);
        buttonClickStatus.put(R.id.b4, 0);
        buttonClickStatus.put(R.id.b5, 0);
        buttonClickStatus.put(R.id.b6, 0);
        buttonClickStatus.put(R.id.b7, 0);
        buttonClickStatus.put(R.id.b8, 0);
        buttonClickStatus.put(R.id.b9, 0);

        // Reset counter
        cnt = 0;
    }


}
