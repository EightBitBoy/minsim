package de.eightbitboy.minsim.logic;

import android.content.Context;

import io.realm.Realm;

public class Game {

	private static Game INSTANCE;

	private Game() {
		Realm db = Realm.getDefaultInstance();
	}

	public static void initialize(Context context) {
		INSTANCE = new Game();
	}

	public static Game get() {
		return INSTANCE;
	}
}
