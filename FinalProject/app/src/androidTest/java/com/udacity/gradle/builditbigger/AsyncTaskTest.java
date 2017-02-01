package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.util.Pair;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by ben.medcalf on 1/31/17.
 */

@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest
{
    @Test
    public void TestAsync() throws Exception {
        AsyncTask<Pair<Context, String>, Void, String> task = new EndpointsAsyncTask();
        Pair pair = new Pair<>(InstrumentationRegistry.getContext(), "Test the toasty!");
        task.execute(pair);
        String string = task.get();
        Assert.assertNotNull(string);
    }
}
