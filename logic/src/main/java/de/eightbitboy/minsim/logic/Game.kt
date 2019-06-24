package de.eightbitboy.minsim.logic

class Game {

    var tick: Long = 0

    fun doTick() {
        tick = tick.inc()
    }
}
