package com.nanotasks.nanotasksample;

import android.app.Application;

import com.nanotasks.Tasks;

/**
 * @author Fabien Devos
 */
public class NanoTasksSampleApplication extends Application {

    @Override
    public void onCreate() {
        Tasks.autoCleanUpOnDestroy(this);
    }
}
