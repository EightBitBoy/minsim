package de.eightbitboy.minsim.bus;

//https://stackoverflow.com/questions/40636946/updating-fragment-from-activity-using-rxjava-android

//https://lorentzos.com/rxjava-as-event-bus-the-right-way-10a36bdd49ba
//https://github.com/AndroidKnife/RxBus
//https://piercezaifman.com/how-to-make-an-event-bus-with-rxjava-and-rxandroid/
//https://github.com/futurice/android-best-practices/
//https://github.com/mihaip/dex-method-counts
public class Bus {
    private static Bus INSTANCE;

    private Bus() {
    }

    public static Bus get() {
        if (INSTANCE == null) {
            INSTANCE = new Bus();
        }
        return INSTANCE;
    }
}
