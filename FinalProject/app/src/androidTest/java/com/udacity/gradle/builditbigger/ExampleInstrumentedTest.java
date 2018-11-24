package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.tourenathan.bakingapp.androidlib.DisplayActivity;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        Log.d("Testa", appContext.getPackageName());
        assertEquals("com.udacity.gradle.builditbigger.free", appContext.getPackageName());

    }


    @Test
    public void testAsyncTask() throws InterruptedException {
        try {
            // create  a signal to let us know when our task is done.
            final CountDownLatch signal = new CountDownLatch(1);
            EndpointsAsyncTask task = new EndpointsAsyncTask(InstrumentationRegistry.getTargetContext()) {
                @Override
                protected void onPostExecute(String result) {
                    super.onPostExecute(result);
                    Log.i("Test value", result);
                    assertNotEquals("Good", "", result);
                    signal.countDown();
                }
            };
            task.execute();
            signal.await(30, TimeUnit.SECONDS);

        } catch (Exception e) {
            assertFalse(true);
        }
    }
}
