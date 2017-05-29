package de.eightbitboy.minsim.database.migrations;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;
import timber.log.Timber;

/**
 * Migration to the schema version 0. This file contains seed data only!
 */
public class MigrationV0 implements RealmMigration {
    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        if (oldVersion == 0 && newVersion == 0) {
            Timber.d("Applying MigrationV0!");
        } else {
            Timber.d("Skipping MigrationV0!");
        }
    }
}
