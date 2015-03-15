package com.nanotasks;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;

import java.util.concurrent.Executor;

/**
 * @author Fabien Devos
 */
public final class Tasks {

    private Tasks() {
        throw new UnsupportedOperationException();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static <T> void executeInBackground(Context context, BackgroundWork<T> backgroundWork, Completion<T> completion) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            executeInBackground(context, backgroundWork, completion, AsyncTask.THREAD_POOL_EXECUTOR);
        } else {
            new Task<T>(context, backgroundWork, completion).execute();
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static <T> void executeInBackground(Context context, BackgroundWork<T> backgroundWork, Completion<T> completion, Executor executor) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            new Task<T>(context, backgroundWork, completion).executeOnExecutor(executor);
        } else {
            throw new RuntimeException("you cannot use a custom executor on pre honeycomb devices");
        }
    }

}
