package de.eightbitboy.minsim.robo.database;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import de.eightbitboy.minsim.BuildConfig;
import de.eightbitboy.minsim.activities.MainActivity;
import de.eightbitboy.minsim.database.Database;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.internal.RealmCore;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class DatabaseTest {

    //TODO Read about dynamic realms!
    //TODO Read about setting up the activity for the whole class!
    @Test
    public void initializeTest() {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        Database.initialize(activity.getApplicationContext());
        assertNotNull(Database.getDb());
    }

    @Test
    public void schema0Test() {
        Realm db = getDb(0);
    }

    @Test
    public void schema1Test() {
        Realm db = getDb(1);
    }

    @Test
    public void schema2Test() {
        Realm db = getDb(2);
    }

    private Realm getDb(long schemaVersion) {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        Realm.init(activity.getApplicationContext());
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("minsim_test.realm")
                .schemaVersion(schemaVersion)
                .inMemory()
                .build();
        return Realm.getInstance(config);
    }
}
