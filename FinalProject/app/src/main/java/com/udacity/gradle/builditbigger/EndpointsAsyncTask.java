package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.util.Log;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.manbradcalf.android.finalproject.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by ben.medcalf on 1/27/17.
 */

public class EndpointsAsyncTask extends AsyncTask<Pair<Context,String >, Void, String>
{
    private static MyApi myApiService = null;
    private Context context;


    @Override
    protected String doInBackground(Pair<Context, String>... params)
    {
        if (myApiService == null)
        {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://build-it-bigger-udacity-157202.appspot.com/_ah/api/");
            // end options for devappserver

            myApiService = builder.build();
        }

        context = params[0].first;
        String name = params[0].second;

        try
        {
            return myApiService.sayHi(name).execute().getData();
        }
        catch (IOException e)
        {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        Log.d(this.getClass().getSimpleName(), "onPostExecute called at least?");
    }
}

