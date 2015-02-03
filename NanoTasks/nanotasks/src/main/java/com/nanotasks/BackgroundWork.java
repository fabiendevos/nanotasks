package com.nanotasks;

public interface BackgroundWork<T> {
    T doInBackground() throws Exception;
}
