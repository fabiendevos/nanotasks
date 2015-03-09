package com.nanotasks;

import android.content.Context;
import android.os.AsyncTask;

import java.util.concurrent.Executor;

/**
 * @author Fabien Devos
 */
public final class Tasks {

    private Tasks() { throw new UnsupportedOperationException(); }

    public static <T> void executeInBackground(Context context, BackgroundWork<T> backgroundWork, Completion<T> completion) {
        executeInBackground(context, backgroundWork, completion, AsyncTask.THREAD_POOL_EXECUTOR);
    }

    public static <T> void executeInBackground(Context context, BackgroundWork<T> backgroundWork, Completion<T> completion, Executor executor) {
        new Task<T>(context, backgroundWork, completion).executeOnExecutor(executor);
    }

}
