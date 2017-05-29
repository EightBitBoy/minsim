package de.eightbitboy.minsim.database.migrations;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;
import timber.log.Timber;

/**
 * Migration to the schema version 1.
 */
public class MigrationV1 implements RealmMigration {
    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        if (oldVersion == 0 && newVersion == 1) {
            Timber.d("Applying MigrationV1!");
        } else {
            Timber.d("Skipping MigrationV1!");
        }
    }
}
