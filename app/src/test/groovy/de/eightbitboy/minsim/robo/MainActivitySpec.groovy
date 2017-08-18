package de.eightbitboy.minsim.robo

import org.robolectric.Robolectric
import org.robolectric.annotation.Config
import spock.lang.Specification

import de.eightbitboy.minsim.BuildConfig
import de.eightbitboy.minsim.activities.MainActivity

@Config(constants = BuildConfig.class)
public class MainActivitySpec extends Specification{

    def "the navigation is available"(){
        setup:
        MainActivity activity = Robolectric.setupActivity(MainActivity.class)

        expect:
        activity != null
    }
}
