package de.eightbitboy.minsim;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import de.eightbitboy.minsim.database.Database;
import io.fabric.sdk.android.Fabric;
import timber.log.Timber;

public class Minsim extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		Fabric.with(this, new Crashlytics());
		initLogging();
		initTestingGround();
		initDatabase();
	}

	private void initLogging() {
		//TODO Does this make sense, will logging still work when not DEBUG?
		if (BuildConfig.DEBUG) {
			Timber.plant(new Timber.DebugTree());
		}
		Timber.d("Logger has been initialized!");
	}

	private void initTestingGround() {
		TestingGround.initialize(this);
		Timber.d("TestingGround has been initialized!");
	}

	private void initDatabase() {
		Database.initialize(this);
		Timber.d("Database has been initialized!");
	}
}
