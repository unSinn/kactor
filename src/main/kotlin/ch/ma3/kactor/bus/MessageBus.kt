package ch.ma3.kactor.bus

import mu.KLogging
import mu.KotlinLogging
import org.slf4j.LoggerFactory


private val logger = KotlinLogging.logger {}


object MessageBus {

    private var topics = mutableMapOf<Class<*>, MutableList<Subscription>>()

    @Suppress("UNCHECKED_CAST")
    fun <T> subscribe(actor: Any, topic: Class<T>, callback: (T) -> Unit) {
        topics.computeIfAbsent(topic) { mutableListOf() }
                .add(Subscription(topic, actor, callback as (Any) -> Unit))
    }

    fun post(message: Any) {
        logger.debug { "Broadcasting $message" }
        topics[message.javaClass]?.let { subscribers ->
            subscribers.forEach {
                Executor.execute(Runnable { it.callback.invoke(message) })
            }
        }
    }


}