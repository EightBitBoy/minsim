package de.eightbitboy.minsim;

import android.content.Context;

import timber.log.Timber;

public class TestingGround {
	public static void initialize(Context context) {
		if (BuildConfig.DEBUG) {
			test(context);
		} else {
			Timber.d("Skipping all TestingGround functions!");
		}
	}

	private static void test(Context context) {

	}
}
