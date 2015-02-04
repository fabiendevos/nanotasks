package com.nanotasks;

import android.content.Context;

import java.lang.ref.WeakReference;


/**
 * @author Fabien Devos
 */
/*package*/ class Task<C extends Context, T> extends AbstractTask<T> {

    private WeakReference<C> weakContext;
    private Completion<C, T> completion;

    /*package*/ Task(C context, BackgroundWork<T> backgroundWork, Completion<C,T> completion) {
        super(backgroundWork);
        this.weakContext = new WeakReference<C>(context);
        this.completion = completion;
    }

    @Override
    protected void onSuccess(T result) {
        final C context = weakContext.get();
        if (completion != null && context != null) {
            completion.onSuccess(context, result);
        }
    }

    @Override
    protected void onError(Exception e) {
        final C context = weakContext.get();
        if (completion != null && context != null) {
            completion.onError(context, e);
        }
    }
}
