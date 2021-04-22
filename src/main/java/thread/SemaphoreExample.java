package thread;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 信号量简单demo
 * @author yf-Fangjunjin
 * @version 1.0
 * @since 4/21/21 8:59 AM
 */
@Slf4j
public class SemaphoreExample {

    private static final Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();

            log.info("老司机 - {} - 在排队, {}", threadName, new Date());

            try {
                // 让所有线程睡眠排队
                Thread.sleep(100);

                // 执行阻塞
                semaphore.acquire();
                log.info("老司机 - {} - 在进入停车场, {}", threadName, new Date());

                Thread.sleep(1000);

                log.info("老司机 - {} - 在离开停车场, {}", threadName, new Date());
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        threadPool.submit(runnable);
        threadPool.submit(runnable);
        threadPool.submit(runnable);
        threadPool.submit(runnable);
        threadPool.submit(runnable);
        threadPool.shutdown();
    }


}
