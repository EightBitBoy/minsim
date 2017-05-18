package de.eightbitboy.minsim;

import android.app.Application;

import io.realm.Realm;
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
        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();
        Timber.d("### Database has been initialized!");
    }
}
