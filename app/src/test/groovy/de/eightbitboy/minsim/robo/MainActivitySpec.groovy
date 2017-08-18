package de.eightbitboy.minsim.robo

import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import spock.lang.Specification

import de.eightbitboy.minsim.BuildConfig
import de.eightbitboy.minsim.activities.MainActivity

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivitySpec extends Specification{

    def "the navigation is available"(){
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
    }
}
