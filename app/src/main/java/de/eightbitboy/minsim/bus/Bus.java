package de.eightbitboy.minsim.bus;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;

//https://stackoverflow.com/questions/40636946/updating-fragment-from-activity-using-rxjava-android

//https://lorentzos.com/rxjava-as-event-bus-the-right-way-10a36bdd49ba
//https://github.com/AndroidKnife/RxBus
//https://piercezaifman.com/how-to-make-an-event-bus-with-rxjava-and-rxandroid/
//https://github.com/futurice/android-best-practices/
//https://github.com/mihaip/dex-method-counts
public class Bus {
	private static Bus INSTANCE;

	private PublishSubject<Object> subject = PublishSubject.create();

	private Bus() {
	}

	public static void initialize() {
		if (INSTANCE == null) {
			INSTANCE = new Bus();
		}
	}

	public static Disposable subscribe(@NonNull Consumer<Object> action) {
		return INSTANCE.subject.subscribe(action);
	}

	public static void publish(@NonNull Object message) {
		INSTANCE.subject.onNext(message);
	}
}
