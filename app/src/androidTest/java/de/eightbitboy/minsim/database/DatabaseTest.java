package de.eightbitboy.minsim.database;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import timber.log.Timber;

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
        System.out.print("bar");
        Realm db = getDb(0);
    }

    @Test
    public void schema1Test() {
        Realm db = getDb(1);
        Log.d("foo", "bar");
    }

    @Test
    public void schema2Test() {
        Realm db = getDb(2);
    }

    private Realm getDb(long schemaVersion) {
        Context context = InstrumentationRegistry.getTargetContext();
        Timber.plant(new Timber.DebugTree());
        Realm.init(context);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name(String.format("minsim_test%s.realm", schemaVersion))
                .schemaVersion(schemaVersion)
                .inMemory()
                .build();
        Database.migrate(config);
        return Realm.getInstance(config);
    }
}
