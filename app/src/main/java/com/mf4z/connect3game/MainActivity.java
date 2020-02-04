package com.mf4z.connect3game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private int mActivePlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dropIn(View view) {

        int yellow = 0;
        int red = 1;

        ImageView counter = (ImageView) view;
        counter.setTranslationY(-1500);

        if (mActivePlayer == yellow){

            counter.setImageResource(R.drawable.yellow);
            mActivePlayer = red;
        }
        else {
            counter.setImageResource(R.drawable.red);
            mActivePlayer = yellow;
        }

        counter.animate().translationYBy(1500).rotation(3600).setDuration(300);



    }
}
