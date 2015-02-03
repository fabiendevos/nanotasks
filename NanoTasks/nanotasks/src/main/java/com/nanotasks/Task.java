package com.nanotasks;

import android.content.Context;

import java.lang.ref.WeakReference;


/**
 * @author Fabien Devos
 */
/*package*/ class Task<T> extends AbstractTask<T> {

    private WeakReference<Context> weakContext;
    private Completion<T> completion;

    /*package*/ Task(Context context, BackgroundWork<T> backgroundWork, Completion<T> completion) {
        super(backgroundWork);
        this.weakContext = new WeakReference<Context>(context);
        this.completion = completion;
    }

    @Override
    protected void onSuccess(T result) {
        final Context context = weakContext.get();
        if (completion != null && context != null) {
            completion.onSuccess(context, result);
        }
    }

    @Override
    protected void onError(Exception e) {
        final Context context = weakContext.get();
        if (completion != null && context != null) {
            completion.onError(context, e);
        }
    }
}
