package de.eightbitboy.minsim.logic;

import android.content.Context;

import de.eightbitboy.minsim.data.Level;
import io.reactivex.Observable;
import io.realm.Realm;

public class Game {

	private static Game INSTANCE;

	private Game() {
		Realm db = Realm.getDefaultInstance();

		Observable<Level> levelObservable = Observable.create(emitter -> {});
	}

	public static void initialize(Context context) {
		INSTANCE = new Game();
	}

	public static Game get() {
		return INSTANCE;
	}
}
