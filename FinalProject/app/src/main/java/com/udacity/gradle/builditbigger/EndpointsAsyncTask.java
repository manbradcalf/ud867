package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.manbradcalf.android.androidjokes.JokeActivity;
import com.manbradcalf.android.finalproject.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by ben.medcalf on 1/27/17.
 */

public class EndpointsAsyncTask extends AsyncTask<Context, Void, String>
{
    private static MyApi myApiService = null;
    private Context context;
    private static String JOKE_KEY = "joke";


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

        context = params[0];

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
        Intent intent = new Intent(context, JokeActivity.class);
        intent.putExtra(JOKE_KEY, result);
        context.startActivity(intent);
    }
}

