package thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yf-Fangjunjin
 * @version 1.0
 * @since 4/19/21 11:24 AM
 */
@Slf4j
public class LockTest {

    private static final ReentrantLock doctorLock = new ReentrantLock();

    private static class PatientThread extends Thread {

        @Override
        public void run() {
            try {
                doctorLock.lock();
                log.info("医生正在空闲");
                log.info("{} 病人看病",Thread.currentThread().getName());
            } finally {
                log.info("{} 病人看完病",Thread.currentThread().getName());
                doctorLock.unlock();
            }
        }
    }

    @Test
    public void test() {
        for (int i = 0; i < 3; i++) {
            new PatientThread().start();
        }
    }

}
