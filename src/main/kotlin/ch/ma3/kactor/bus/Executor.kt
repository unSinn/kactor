package ch.ma3.kactor.bus

import java.util.concurrent.*
import java.util.concurrent.TimeUnit.*

object Executor {
    private val actors = mutableListOf<Actor>()

    private val workQueue = LinkedBlockingQueue<Runnable>()

    private val INITIAL_POOL_SIZE = 3
    private val MAX_POOL_SIZE = 5

    // Sets the amount of time an idle thread waits before terminating
    private val KEEP_ALIVE_TIME = 10


    private val threadFactory = ActorThreadFactory()

    private val threadPoolExecutor = ThreadPoolExecutor(INITIAL_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME.toLong(), SECONDS,
            this.workQueue, this.threadFactory)


    fun register(instance: Any) {
        actors.add(Actor(instance, false))
    }

    fun execute(runnable: Runnable) {
        this.threadPoolExecutor.execute(runnable)
    }


    private class ActorThreadFactory : ThreadFactory {
        private var actors = 0

        override fun newThread(runnable: Runnable): Thread {
            return Thread(runnable, "kactor_" + actors++)
        }
    }
}