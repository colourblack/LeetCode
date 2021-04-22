package thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yf-Fangjunjin
 * @version 1.0
 * @since 4/19/21 3:26 PM
 */
@Slf4j
public class VolatileTest {

    public static volatile int race = 0;

    public static void increase() {
        race++;
    }

    private static final int THREADS_COUNT = 5;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threadGroup = new Thread[THREADS_COUNT];

        for (int i = 0; i < THREADS_COUNT; i++) {
            threadGroup[i] = new Thread(() -> {
                for (int j = 0; j < 20; j++) {
                    VolatileTest.increase();
                }
            }, "Thread - " + i);

            threadGroup[i].start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        log.info("race: {}", VolatileTest.race);

    }
}
