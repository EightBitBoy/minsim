package de.eightbitboy.minsim;

import android.app.Application;

import de.eightbitboy.minsim.database.Database;
import de.eightbitboy.minsim.logic.Game;
import timber.log.Timber;

public class Minsim extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initLogging();
        initDatabase();
        initGame();
    }

    private void initLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        Timber.d("Logger has been initialized!");
    }

    private void initDatabase() {
        Database.initialize(this);
        Timber.d("Database has been initialized!");
    }

    private void initGame() {
        Game.initialize(this);
        Timber.d("Game has been initialized!");
    }
}
