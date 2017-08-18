package de.eightbitboy.minsim

import spock.lang.Specification

public class ExampleSpec extends Specification{

    def "add values"(){
        setup:
        int valueA = 5
        int valueB = 8

        when:
        int result = valueA + valueB

        then:
        result == 13
    }
}
