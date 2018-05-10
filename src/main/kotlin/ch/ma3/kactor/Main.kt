package ch.ma3.kactor

import ch.ma3.kactor.bus.MessageBus
import ch.ma3.kactor.messages.Shout


fun main(args: Array<String>) {
    println("Main")
    Musketeer("D'Artagnan")
    Musketeer("Athos")
    Musketeer("Aramis")
    Musketeer("Porthos")
    MessageBus.post(Shout(ONE_FOR_ALL))

}