package com.nanotasks;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;

import java.util.concurrent.Executor;

/**
 * @author Fabien Devos
 */
public final class Tasks {

    private Tasks() { throw new UnsupportedOperationException(); }

    public static <T> void executeInBackground(Context context, BackgroundWork<T> backgroundWork, Completion<T> completion) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            new Task<T>(context, backgroundWork, completion).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        } else {
            new Task<T>(context, backgroundWork, completion).execute();
        }
    }

    public static <T> void executeInBackground(Context context, BackgroundWork<T> backgroundWork, Completion<T> completion, Executor executor) {
        new Task<T>(context, backgroundWork, completion).executeOnExecutor(executor);
    }

}
