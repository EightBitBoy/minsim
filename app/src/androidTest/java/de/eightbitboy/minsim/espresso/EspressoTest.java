package de.eightbitboy.minsim.espresso;

import android.support.test.espresso.ViewInteraction;

abstract class EspressoTest {

	private static final long DELAY = 1000;

	ViewInteraction onView(org.hamcrest.Matcher<android.view.View> viewMatcher) {
		try {
			Thread.sleep(DELAY);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return android.support.test.espresso.Espresso.onView(viewMatcher);
	}
}
