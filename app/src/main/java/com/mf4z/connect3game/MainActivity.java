package com.mf4z.connect3game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // yellow : 0, red : 1; empty : 2

    private int mActivePlayer = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6},
            {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    boolean gameActive = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dropIn(View view) {

        ImageView counter = (ImageView) view;
        int tappedCounter = Integer.parseInt(counter.getTag().toString());

                //Check if box is empty and has no counter and if game is active
        if (gameState[tappedCounter] == 2 && gameActive) {
            gameState[tappedCounter] = mActivePlayer;
            counter.setTranslationY(-1500); //Moves the view(Counter) off the screen initially


            //Check to determine which player is active and setting the color of Counter
            if (mActivePlayer == 0) {

                counter.setImageResource(R.drawable.yellow);
                mActivePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                mActivePlayer = 0;
            }

            //Responsible for the animated effect of Counter being dropped
            counter.animate().translationYBy(1500).rotation(3600).setDuration(300);

            //Iteration to check possible winning combinations
            for (int[] winningPosition : winningPositions) {

                //Check if winning condition satisfies one of the winning combinations
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2) {

                    //Someone has won

                    gameActive = false;

                    String winner = "";

                    if (mActivePlayer == 1) {
                        winner = "Yellow";
                    } else {
                        winner = "Red";

                    }

                    TextView winnerTextView = (TextView) findViewById(R.id.winner_textView);
                    Button playAginaBtn = (Button) findViewById(R.id.play_again_button);

                    winnerTextView.setText(winner + " player has won");

                    //Displays when there is a winner

                    winnerTextView.setVisibility(View.VISIBLE);
                    playAginaBtn.setVisibility(View.VISIBLE);
                }
            }

        }
    }

    public void playAgain(View view){

        TextView winnerTextView = (TextView) findViewById(R.id.winner_textView);
        Button playAginaBtn = (Button) findViewById(R.id.play_again_button);

        //Hide Button and Text View
        winnerTextView.setVisibility(View.INVISIBLE);
        playAginaBtn.setVisibility(View.INVISIBLE);

        //ImageView counter = (ImageView) view;

        GridLayout  gridLayout = (GridLayout) findViewById(R.id.gridLayout);

        //Get the child views(ImageView) of the parent view (Gridview)
        final int childCount = gridLayout.getChildCount();

        //Loop and set ImageView to null
        for (int i = 0; i < childCount; i++) {
            ImageView counter = (ImageView) gridLayout.getChildAt(i);
           counter.setImageDrawable(null);
        }

       //Reset active player
         mActivePlayer = 0;

        //Reset game state
        for (int i = 0;i< gameState.length;i++){
            gameState[i] = 2;
        }

        //Reset game to active
        gameActive = true;
    }
}
