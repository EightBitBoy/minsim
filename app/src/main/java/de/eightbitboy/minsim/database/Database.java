package de.eightbitboy.minsim.database;

import android.content.Context;

import java.io.FileNotFoundException;

import de.eightbitboy.minsim.database.migrations.MigrationV0;
import de.eightbitboy.minsim.database.migrations.MigrationV1;
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
        migrate(config);
    }

    private static void migrate(RealmConfiguration config) {
        try {
            Realm.migrateRealm(config, new MigrationV0());
            Realm.migrateRealm(config, new MigrationV1());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Realm getDb() {
        return Realm.getDefaultInstance();
    }
}
