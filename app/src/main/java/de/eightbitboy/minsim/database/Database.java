package de.eightbitboy.minsim.database;

import android.content.Context;

import java.io.FileNotFoundException;

import de.eightbitboy.minsim.database.migrations.MigrationV1;
import de.eightbitboy.minsim.database.migrations.Seed;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import timber.log.Timber;

final public class Database {

    public static String DATABASE_NAME = "minsim.realm";

    private Database() {
    }

    public static void initialize(Context context) {
        Realm.init(context);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name(DATABASE_NAME)
                .schemaVersion(0)
                .initialData(new Seed())
                .build();
        Realm.setDefaultConfiguration(config);
        migrate(config);
    }

    //TODO https://github.com/realm/realm-java/blob/master/examples/migrationExample/src/main/java/io/realm/examples/realmmigrationexample/MigrationExampleActivity.java
    public static void migrate(RealmConfiguration config) {
        try {
            Realm.migrateRealm(config, new MigrationV1());
        } catch (FileNotFoundException e) {
            Timber.d("The realm file does not exist, migrations will be skipped!");
        }
    }

    public static void migrateToVersion(RealmConfiguration config, long version) {

    }

    public static Realm getDb() {
        return Realm.getDefaultInstance();
    }
}
