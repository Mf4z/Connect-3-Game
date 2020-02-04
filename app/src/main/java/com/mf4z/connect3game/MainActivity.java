package com.mf4z.connect3game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dropIn(View view) {

        int yellow = 0;
        int red = 1;
        int activePlayer = yellow;

        ImageView counter = (ImageView) view;
        counter.setTranslationY(-1500);

        if (activePlayer == yellow) {
            counter.setImageResource(R.drawable.yellow);
        }
        else {
            counter.setImageResource(R.drawable.red);
        }
        counter.animate().translationYBy(1500).rotation(3600).setDuration(300);

    }
}
