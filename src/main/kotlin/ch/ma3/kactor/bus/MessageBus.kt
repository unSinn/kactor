package ch.ma3.kactor.bus

object MessageBus {

    private var topics = mutableMapOf<Class<*>, MutableList<(Any) -> Unit>>()

    @Suppress("UNCHECKED_CAST")
    fun <T> subscribe(topic: Class<T>, callback: (T) -> Unit) {
        topics.computeIfAbsent(topic) { mutableListOf() }
                .add(callback as (Any) -> Unit)
    }

    fun post(message: Any) {
        println(message)
        topics[message.javaClass]?.let { subscribers ->
            subscribers.forEach { it.invoke(message) }
        }
    }

}