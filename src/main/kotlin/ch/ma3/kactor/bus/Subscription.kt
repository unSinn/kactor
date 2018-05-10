package ch.ma3.kactor.bus

data class Subscription(val topic: Class<*>, val actorInstance: Any, val callback: (Any) -> Unit)