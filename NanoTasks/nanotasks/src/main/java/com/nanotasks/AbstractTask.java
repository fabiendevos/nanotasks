package com.nanotasks;

import android.os.AsyncTask;
import android.util.Log;


/**
 * @author Fabien Devos
 */
/*package*/ abstract class AbstractTask<T> extends AsyncTask<Void, Void, T> {

    private BackgroundWork<T> backgroundWork;
    private Exception exception;

    /*package*/ AbstractTask(BackgroundWork<T> backgroundWork) {
        this.backgroundWork = backgroundWork;
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
    }

    protected abstract void onSuccess(T result);
    protected abstract void onError(Exception e);
}
