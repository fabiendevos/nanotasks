package com.nanotasks;

import android.app.Application;
import android.os.AsyncTask;

import java.util.concurrent.Executor;

/**
 * API to handle Tasks.
 * @author Fabien Devos
 */
public final class Tasks {

    private Tasks() { throw new UnsupportedOperationException(); }

    public static void autoCleanUpOnDestroy(Application application) {
        application.registerActivityLifecycleCallbacks(new CleanUpTasksLifeCycleHandler());
    }

    public static <T> void execute(BackgroundWork<T> backgroundWork, Completion<T> completion) {
        new Task<T>(backgroundWork, completion).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    public static <T> void execute(BackgroundWork<T> backgroundWork, Completion<T> completion, Executor executor) {
        new Task<T>(backgroundWork, completion).executeOnExecutor(executor);
    }

}
