package de.eightbitboy.minsim.database.migrations;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;

/**
 * Migration to the schema version 0. This file contains seed data only!
 */
public class MigrationV0 implements RealmMigration {
    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        if (oldVersion == 0 && newVersion == 0) {

        }
    }
}
