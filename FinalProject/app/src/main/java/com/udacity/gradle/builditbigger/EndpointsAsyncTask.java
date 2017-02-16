package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.manbradcalf.android.finalproject.backend.myApi.MyApi;
import com.udacity.gradle.builditbigger.free.JokeRetrievedEvent;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

/**
 * Created by ben.medcalf on 1/27/17.
 */

public class EndpointsAsyncTask extends AsyncTask<Context, Void, String>
{
    private static MyApi myApiService = null;
    private ProgressBar progressBar;

    public void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    @Override
    protected void onPreExecute() {
        if (progressBar != null)
        {
            progressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected String doInBackground(Context... params)
    {
        if (myApiService == null)
        {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://build-it-bigger-udacity-157202.appspot.com/_ah/api/");
            // end options for devappserver

            myApiService = builder.build();
        }

        try
        {
            return myApiService.tellJoke().execute().getData();
        }
        catch (IOException e)
        {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {

        if (progressBar != null) {
            progressBar.setVisibility(View.GONE);
        }
        // Post the result to the event bus, so we can start the JokeActivity
        // from the Fragment which calls this task.
        EventBus.getDefault().post(new JokeRetrievedEvent(result));
    }
}

