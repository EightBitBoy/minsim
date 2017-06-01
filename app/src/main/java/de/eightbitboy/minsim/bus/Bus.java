package de.eightbitboy.minsim.bus;

//http://www.vogella.com/tutorials/RxJava/article.html
//https://stackoverflow.com/questions/40636946/updating-fragment-from-activity-using-rxjava-android
//https://lorentzos.com/rxjava-as-event-bus-the-right-way-10a36bdd49ba
//https://github.com/AndroidKnife/RxBus
//https://piercezaifman.com/how-to-make-an-event-bus-with-rxjava-and-rxandroid/
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
