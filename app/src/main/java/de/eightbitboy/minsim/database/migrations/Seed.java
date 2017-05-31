package de.eightbitboy.minsim.database.migrations;

import de.eightbitboy.minsim.data.Level;
import io.realm.Realm;
import timber.log.Timber;

public class Seed implements Realm.Transaction {
    @Override
    public void execute(Realm realm) {
        Timber.d("Seeding the database!");
        
        Level level1 = new Level();
        level1.setId(1);
        level1.setHealth(10);
        realm.insert(level1);
    }
}
