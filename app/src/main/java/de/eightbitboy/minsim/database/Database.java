package de.eightbitboy.minsim.database;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

final public class Database {

    public static String DATABASE_NAME = "minsim.realm";

    private static boolean initialized = false;

    private Database(Context context) {
    }

    public static void initialize(Context context) {
        Realm.init(context);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name(DATABASE_NAME)
                .schemaVersion(0)
                .build();
        Realm.setDefaultConfiguration(config);
        initialized = true;
    }

    //TODO Initialization might be a code smell!
    public static Realm getDb(Context context) {
        if (!initialized) {
            throw new IllegalStateException("The database has not been initialized!");
        }
        return Realm.getDefaultInstance();
    }
}
