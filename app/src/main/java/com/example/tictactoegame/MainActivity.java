package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private ImageView b1, b2, b3, b4, b5, b6, b7, b8, b9;
    private HashMap<Integer, Integer> buttonClickStatus;
    private int cnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Button connection with XML
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);

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

        // Null check for button status
        Integer click = buttonClickStatus.get(buttonId);
        if (click == null || click != 0) {
            Toast.makeText(this, "Invalid click", Toast.LENGTH_SHORT).show();
            return;
        }

        cnt++;
        ImageView clickedImage = findViewById(buttonId);

        // Null check for clickedImage
        if (clickedImage == null) {
            Toast.makeText(this, "Invalid button view", Toast.LENGTH_SHORT).show();
            return;
        }

        // Set image based on counter
        if (cnt % 2 == 0) {
            clickedImage.setBackgroundResource(R.drawable.cro);
            buttonClickStatus.put(buttonId, 100); // CROSS
        } else {
            clickedImage.setBackgroundResource(R.drawable.ze);
            buttonClickStatus.put(buttonId, 101); // ZERO
        }

        // Check for a winner after the 5th move
        if (cnt >= 5) {
            Integer bb1 = buttonClickStatus.get(R.id.b1);
            Integer bb2 = buttonClickStatus.get(R.id.b2);
            Integer bb3 = buttonClickStatus.get(R.id.b3);
            Integer bb4 = buttonClickStatus.get(R.id.b4);
            Integer bb5 = buttonClickStatus.get(R.id.b5);
            Integer bb6 = buttonClickStatus.get(R.id.b6);
            Integer bb7 = buttonClickStatus.get(R.id.b7);
            Integer bb8 = buttonClickStatus.get(R.id.b8);
            Integer bb9 = buttonClickStatus.get(R.id.b9);

            // Row-wise checks
            if (bb1 != null && bb1.equals(bb2) && bb2.equals(bb3) && bb1 != 0) {
                showWinnerToast(bb1);
            } else if (bb4 != null && bb4.equals(bb5) && bb5.equals(bb6) && bb4 != 0) {
                showWinnerToast(bb4);
            } else if (bb7 != null && bb7.equals(bb8) && bb8.equals(bb9) && bb7 != 0) {
                showWinnerToast(bb7);
            }

            // Column-wise checks
            else if (bb1 != null && bb1.equals(bb4) && bb4.equals(bb7) && bb1 != 0) {
                showWinnerToast(bb1);
            } else if (bb2 != null  && bb2.equals(bb5) && bb5.equals(bb8) && bb2 != 0) {
                showWinnerToast(bb2);
            } else if (bb3 != null && bb3.equals(bb6) && bb6.equals(bb9) && bb3 != 0) {
                showWinnerToast(bb3);
            }

            // Diagonal checks
            else if (bb1 != null && bb1.equals(bb5) && bb5.equals(bb9) && bb1 != 0) {
                showWinnerToast(bb1);
            } else if (bb3 != null && bb3.equals(bb5) && bb5.equals(bb7) && bb3 != 0) {
                showWinnerToast(bb3);
            }

            // If no winner and all moves are used
            else if (cnt == 9) {
                showWinnerToast(105); // DRAW
            }
        }
    }

    private void showWinnerToast(int winner) {
        WinnerDialog(winner);
        resetGame();
    }

    @SuppressLint("SetTextI18n")
    private void WinnerDialog(int winner) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_winner); // Use your custom layout

        TextView winnerMessage = dialog.findViewById(R.id.winnerMessage);
        Button restartButton = dialog.findViewById(R.id.restartButton);

        // Null check for dialog views
        if (winnerMessage == null || restartButton == null) {
            Toast.makeText(this, "Dialog layout error", Toast.LENGTH_SHORT).show();
            return;
        }

        // Set the dialog title/message based on the winner
        if (winner == 100) {
            winnerMessage.setText("CROSS Wins!");
        } else if (winner == 101) {
            winnerMessage.setText("ZERO Wins!");
        } else {
            winnerMessage.setText("It's a DRAW!");
        }

        // Restart button click listener
        restartButton.setOnClickListener(v -> {
            dialog.dismiss(); // Close the dialog
            resetGame();      // Reset the game
        });

        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        }

        dialog.show();
    }

    // Method to reset the game
    private void resetGame() {
        b1.setBackgroundResource(R.drawable.box);
        b2.setBackgroundResource(R.drawable.box);
        b3.setBackgroundResource(R.drawable.box);
        b4.setBackgroundResource(R.drawable.box);
        b5.setBackgroundResource(R.drawable.box);
        b6.setBackgroundResource(R.drawable.box);
        b7.setBackgroundResource(R.drawable.box);
        b8.setBackgroundResource(R.drawable.box);
        b9.setBackgroundResource(R.drawable.box);

        buttonClickStatus.put(R.id.b1, 0);
        buttonClickStatus.put(R.id.b2, 0);
        buttonClickStatus.put(R.id.b3, 0);
        buttonClickStatus.put(R.id.b4, 0);
        buttonClickStatus.put(R.id.b5, 0);
        buttonClickStatus.put(R.id.b6, 0);
        buttonClickStatus.put(R.id.b7, 0);
        buttonClickStatus.put(R.id.b8, 0);
        buttonClickStatus.put(R.id.b9, 0);

        cnt = 0;
    }
}
