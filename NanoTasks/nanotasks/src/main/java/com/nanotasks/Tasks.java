package com.nanotasks;

import android.content.Context;
import android.os.AsyncTask;

import java.util.concurrent.Executor;

/**
 * @author Fabien Devos
 */
public final class Tasks {

    private Tasks() { throw new UnsupportedOperationException(); }

    public static <C extends Context, T> void execute(C context, BackgroundWork<T> backgroundWork, Completion<C, T> completion) {
        new Task<C, T>(context, backgroundWork, completion).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    public static <C extends Context, T> void execute(C context, BackgroundWork<T> backgroundWork, Completion<C, T> completion, Executor executor) {
        new Task<C, T>(context, backgroundWork, completion).executeOnExecutor(executor);
    }

}
