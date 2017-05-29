package de.eightbitboy.minsim.database;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import de.eightbitboy.minsim.activities.MainActivity;
import io.realm.Realm;
import io.realm.RealmConfiguration;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class DatabaseTest {

    //TODO Read about dynamic realms!
    //TODO Read about setting up the activity for the whole class!
    @Test
    public void initializeTest() {
        Context context = InstrumentationRegistry.getTargetContext();
        Database.initialize(context);
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
        Context context = InstrumentationRegistry.getTargetContext();
        Realm.init(context);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name(String.format("minsim_test%s.realm", schemaVersion))
                .schemaVersion(schemaVersion)
                .inMemory()
                .build();
        return Realm.getInstance(config);
    }
}
