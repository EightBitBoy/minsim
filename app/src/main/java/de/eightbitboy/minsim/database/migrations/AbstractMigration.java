package de.eightbitboy.minsim.database.migrations;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;
import timber.log.Timber;

public abstract class AbstractMigration implements RealmMigration {

    public abstract long getFromVersion();

    public abstract long getToVersion();

    public abstract void migrate(DynamicRealm realm);

    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        checkVersions();
        if (oldVersion == getFromVersion() && newVersion == getToVersion()) {
            Timber.d(String.format("Migrating from schema %s to %s!",
                    getFromVersion(), getToVersion()));
            migrate(realm);
        } else {
            Timber.d(String.format("Skipping migration from schema %s to %s!",
                    getFromVersion(), getToVersion()));
        }
    }

    private void checkVersions() {
        if (getFromVersion() < 0 || getToVersion() < 0) {
            throw new IllegalStateException("Schema versions must be positive!");
        }
        if (getToVersion() < getFromVersion()) {
            throw new IllegalStateException(
                    "The target schema version must be equal or greater than the source version!");
        }
    }
}
