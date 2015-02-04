package com.nanotasks;

import android.content.Context;

public interface Completion<C extends Context, T> {
    void onSuccess(C context, T result);
    void onError(C context, Exception e);
}
