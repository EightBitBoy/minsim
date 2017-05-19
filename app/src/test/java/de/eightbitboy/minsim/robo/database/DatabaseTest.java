package de.eightbitboy.minsim.robo.database;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import de.eightbitboy.minsim.BuildConfig;
import de.eightbitboy.minsim.activities.MainActivity;
import de.eightbitboy.minsim.database.Database;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class DatabaseTest {

    //TODO Read about setting up the activity for the whole class!
    @Test
    public void initializeTest() {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        assertNotNull(Database.getSession());
    }
}
