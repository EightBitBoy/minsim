package de.eightbitboy.minsim;

import android.content.Context;

import de.eightbitboy.minsim.bus.Bus;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
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
		Observable<String> obervable = Observable.just("foo", "bar", "baz");
		obervable.subscribe(new Consumer<String>() {
			@Override
			public void accept(@NonNull String s) throws Exception {
				Timber.d("### " + s);
			}
		});

		
		Bus.subscribe(new Consumer<Object>() {
			@Override
			public void accept(@NonNull Object o) throws Exception {

			}
		});
	}
}
