package com.manbradcalf.android.androidjokes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    private final String JOKE_KEY = "joke";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView jokeTextView = (TextView) findViewById(R.id.joke_textview);
        jokeTextView.setText(savedInstanceState.getString(JOKE_KEY));
    }
}
