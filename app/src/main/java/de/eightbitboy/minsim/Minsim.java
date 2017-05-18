package de.eightbitboy.minsim;

import android.app.Application;

import timber.log.Timber;

public class Minsim extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initLogging();
        initDatabase();
    }

    private void initLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        Timber.d("### Logger has been initialized!");
    }

    private void initDatabase() {
        Timber.d("### Database has been initialized!");
    }
}
