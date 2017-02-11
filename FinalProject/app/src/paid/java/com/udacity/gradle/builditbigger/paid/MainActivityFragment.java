package com.udacity.gradle.builditbigger.paid;


import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityFragment extends Fragment
{
    Button mTellJokeButton;
    ProgressBar mProgressBar;



    public MainActivityFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_main_activity, container, false);

        mProgressBar = (ProgressBar) root.findViewById(R.id.progress_bar);
        mProgressBar.setVisibility(View.GONE);
        mTellJokeButton = (Button) root.findViewById(R.id.tell_joke_button);
        mTellJokeButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                tellJoke();
            }
        });
        return root;
    }

    private void tellJoke()
    {
        AsyncTask<Context, Void, String> task = new EndpointsAsyncTask(getContext(), mProgressBar);
        task.execute(getContext());
    }

}
