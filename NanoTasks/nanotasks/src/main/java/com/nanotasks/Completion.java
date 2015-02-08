package com.nanotasks;

public interface Completion<T> {
    void onSuccess(T result);
    void onError(Exception e);
}
