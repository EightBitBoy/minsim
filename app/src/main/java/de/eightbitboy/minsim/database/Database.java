package de.eightbitboy.minsim.database;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

final public class Database {

    public static String DATABASE_NAME = "minsim.realm";

    private Database() {
    }

    public static void initialize(Context context) {
        Realm.init(context);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name(DATABASE_NAME)
                .schemaVersion(0)
                .build();
        Realm.setDefaultConfiguration(config);
    }

    public static Realm getDb() {
        return Realm.getDefaultInstance();
    }
}
