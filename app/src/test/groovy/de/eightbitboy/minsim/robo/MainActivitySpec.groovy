package de.eightbitboy.minsim.robo

import hkhc.electricspock.ElectricSpecification
import org.robolectric.Robolectric
import org.robolectric.annotation.Config

import de.eightbitboy.minsim.BuildConfig
import de.eightbitboy.minsim.activities.MainActivity

@Config(constants = BuildConfig.class, manifest='src/debug/AndroidManifest.xml')
public class MainActivitySpec extends ElectricSpecification{

    def "the navigation is available"(){
        setup:
        MainActivity activity = Robolectric.setupActivity(MainActivity.class)

        expect:
        activity != null
    }
}
