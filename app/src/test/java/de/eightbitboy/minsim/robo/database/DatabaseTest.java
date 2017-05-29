package de.eightbitboy.minsim.robo.database;

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

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class DatabaseTest {

    //TODO Read about setting up the activity for the whole class!
    @Test
    void initializeTest() {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        Database.initialize(activity.getApplicationContext());
        assertNotNull(Database.getDb());
    }

    @Test
    void schema0Test() {
        Realm db = Realm.getInstance(buildConfig(0));
    }

    @Test
    void schema1Test() {
        Realm db = Realm.getInstance(buildConfig(1));
    }

    @Test
    void schema2Test() {
        Realm db = Realm.getInstance(buildConfig(2));
    }

    RealmConfiguration buildConfig(long schemaVersion) {
        return new RealmConfiguration.Builder()
                .name("minsim_test.realm")
                .schemaVersion(schemaVersion)
                .inMemory()
                .build();
    }
}
