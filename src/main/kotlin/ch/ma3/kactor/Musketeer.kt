package ch.ma3.kactor

import ch.ma3.kactor.bus.Executor
import ch.ma3.kactor.bus.MessageBus.subscribe
import ch.ma3.kactor.messages.Shout
import mu.KLogging


val ONE_FOR_ALL = "One for all"
val ALL_FOR_ONE = "All for one!"

class Musketeer(name: String) {

    companion object : KLogging()

    init {
        logger.debug("I'm $name.")
        Executor.register(this.javaClass)
        subscribe(this, Shout::class.java, {
            if (it.text == ONE_FOR_ALL) {
                logger.debug(ALL_FOR_ONE)
            }
        })
    }
}