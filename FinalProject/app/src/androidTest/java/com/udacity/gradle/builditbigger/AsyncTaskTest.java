package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

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
        AsyncTask<Context, Void, String> task = new EndpointsAsyncTask();
        task.execute(InstrumentationRegistry.getContext());
        String result = null;
        try
        {
            result = task.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(result);
    }
}
