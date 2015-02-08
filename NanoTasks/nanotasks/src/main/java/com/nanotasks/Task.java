package com.nanotasks;

import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fabien Devos
 */
/*package*/ class Task<T> extends AsyncTask<Void, Void, T> {

    private static List<Task> tasks = new ArrayList<Task>();

    private BackgroundWork<T> backgroundWork;
    private Completion<T> completion;
    private Exception exception;

    /*package*/ Task(BackgroundWork<T> backgroundWork, Completion<T> completion) {
        this.backgroundWork = backgroundWork;
        this.completion = completion;
    }

    /*package*/ static void clearTasks() {
        for (Task task : tasks) {
            task.completion = null;
        }
        tasks.clear();
    }

    private void onSuccess(T result) {
        if (completion != null) {
            completion.onSuccess(result);
        }
    }

    private void onError(Exception e) {
        if (completion != null) {
            completion.onError(e);
        }
    }

    @Override
    protected void onPreExecute() {
        tasks.add(this);
    }

    @Override
    protected final T doInBackground(Void... params) {
        try {
            return backgroundWork.doInBackground();
        } catch (Exception e) {
            exception = e;
            return null;
        }
    }

    @Override
    protected final void onPostExecute(T result) {
        if (!isCancelled()) {
            if (exception == null) {
                onSuccess(result);
            } else {
                Log.w(this.getClass().getSimpleName(), exception);
                onError(exception);
            }
        }
        tasks.remove(this);
    }

}
