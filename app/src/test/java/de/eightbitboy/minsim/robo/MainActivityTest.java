package de.eightbitboy.minsim.robo;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import de.eightbitboy.minsim.BuildConfig;
import de.eightbitboy.minsim.R;
import de.eightbitboy.minsim.activities.MainActivity;

import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityTest {

    @Test
    @Ignore
    public void navigationTest() {
        //TODO MainActivity uses realm database which is not supported by robolectric! :-(
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        assertNotNull(activity.findViewById(R.id.navigation));
    }
}
