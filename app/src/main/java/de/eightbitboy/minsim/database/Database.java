package de.eightbitboy.minsim.database;

import android.content.Context;

import io.realm.Realm;

final public class Database {

    private Database(Context context) {
    }

    public static void initialize(Context context) {
        Realm.init(context);
    }
}
