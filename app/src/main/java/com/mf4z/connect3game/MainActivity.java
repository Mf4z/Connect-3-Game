package com.mf4z.connect3game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // yellow : 0, red : 1; empty : 2

    private int mActivePlayer;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6},
            {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dropIn(View view) {

        ImageView counter = (ImageView) view;
        int yellow = 0;
        int red = 1;
        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        gameState[tappedCounter] = mActivePlayer;

        counter.setTranslationY(-1500);

        if (mActivePlayer == yellow) {

            counter.setImageResource(R.drawable.yellow);
            mActivePlayer = red;
        } else {
            counter.setImageResource(R.drawable.red);
            mActivePlayer = yellow;
        }

        counter.animate().translationYBy(1500).rotation(3600).setDuration(300);

        for (int[] winningPosition : winningPositions) {

            if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                    gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                    gameState[winningPosition[0]] != 2) {

                Toast.makeText(this,"Someone has won",Toast.LENGTH_LONG).show();
            }
        }

    }
}
