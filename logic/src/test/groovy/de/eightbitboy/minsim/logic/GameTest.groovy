package de.eightbitboy.minsim.logic

import spock.lang.Specification

class GameTest extends Specification {
    def "The tick counter is incremented."() {
        given:
        def game = new Game()

        when:
        game.doTick()

        then:
        game.tick == 1
    }

    def "bar"() {
        expect:
        assert 3 + 5 == 8
    }
}
