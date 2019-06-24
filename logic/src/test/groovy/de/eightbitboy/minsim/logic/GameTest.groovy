package de.eightbitboy.minsim.logic

import spock.lang.Specification

class GameTest extends Specification {
    "foobar"() {
        given:
        def a = 10
        def b = 30

        when:
        def c = a + b

        then:
        c == 41
    }
}
