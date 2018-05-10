package ch.ma3.kactor

import ch.ma3.kactor.bus.MessageBus
import ch.ma3.kactor.bus.MessageBus.subscribe
import ch.ma3.kactor.messages.Shout

class Musketeer(name: String) {


    val oneForAll = "One for all"
    val allForOne = "All for one!"

    init {
        println("I'm $name.")
        subscribe(Shout::class.java, {
            if (it.text == oneForAll) {
                println(allForOne)
            }
        })
    }

    fun provoke() {
        MessageBus.post(Shout(oneForAll))
    }

}