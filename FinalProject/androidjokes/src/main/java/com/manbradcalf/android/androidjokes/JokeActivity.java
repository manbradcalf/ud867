package com.manbradcalf.android.androidjokes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    TextView jokeTextView;
    private final String JOKE_KEY = "joke";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        jokeTextView = (TextView) findViewById(R.id.joke_textview);
        Intent intent = getIntent();
        String joke = intent.getStringExtra(JOKE_KEY);
        jokeTextView.setText(joke);
    }
}
